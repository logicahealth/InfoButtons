// server.js - basic rest services - crud methods against mysql

//retrieve environment config
var env = require('./env.json');

//set environment config
var mysql_server_hostname = env.mysql_server_hostname;
var mysql_user = env.mysql_user;
var mysql_pass = env.mysql_pass;
var lite_server_url = env.lite_server_url;
var resource_profile_db = env.resource_profile_db;
var responder_db = env.responder_db;

var express = require('express'),
    app     = express(),
    mysql   = require('mysql'),
	bodyParser = require('body-parser'),

    profileConnectionPool = mysql.createPool({
        host     : mysql_server_hostname,
        user     : mysql_user,
        password : mysql_pass,
        database : resource_profile_db,
		supportBigNumbers: true
    }),
	
    responderConnectionPool = mysql.createPool({
        host     : mysql_server_hostname,
        user     : mysql_user,
        password : mysql_pass,
        database : responder_db
    });

// configure app to use bodyParser()
// assists with getting data from a POST
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// Add headers
app.use(function (req, res, next) {

    // Website you wish to allow to connect
    res.setHeader('Access-Control-Allow-Origin', lite_server_url);

    // Request methods you wish to allow
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');

    // Request headers you wish to allow
    res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');

    // Set to true if you need the website to include cookies in the requests sent
    // to the API (e.g. in case you use sessions)
    res.setHeader('Access-Control-Allow-Credentials', true);

    // Pass to next layer of middleware
    next();
});

function getProfiles(req,res) {
	
	profileConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + resource_profile_db + '.v_custom_profiles', function(err,rows,fields) {
			res.send(rows);
		});
		connection.release();
	});
	
}

function getLocalCloudProfiles(req,res) {

	profileConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + resource_profile_db + '.v_installed_store_profiles', function(err,rows,fields) {
			res.send(rows);
		});
		connection.release();
	});

}

function getProfile(req,res) {

	profileConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + resource_profile_db + '.v_custom_profiles where id=' + req.params.id, function(err,rows,fields) {
			// res.send({fields:fields,rows:rows});
			res.send(rows[0]);
		});
		connection.release();
	});

}

function twoDigits(d) {
    if(0 <= d && d < 10) return "0" + d.toString();
    if(-10 < d && d < 0) return "-0" + (-1*d).toString();
    return d.toString();
}

Date.prototype.toMysqlFormat = function() {
    return this.getUTCFullYear() + "-" + twoDigits(1 + this.getUTCMonth()) + "-" + twoDigits(this.getUTCDate()) + " " + twoDigits(this.getUTCHours()) + ":" + twoDigits(this.getUTCMinutes()) + ":" + twoDigits(this.getUTCSeconds());
};


function createProfile(req,res) {

	console.log("Creating new profile: " + req.body.name);

	profileConnectionPool.getConnection( function(err,connection) {

		var newRecord = {name:req.body.name, version:'1', status:'2', content:req.body.content_utf8, published: new Date().toMysqlFormat()};
		
		if (req.body.image_url) {
			newRecord.image_url = req.body.image_url;
		}

		connection.query('insert into ' + resource_profile_db + '.custom_profiles set ?',
			newRecord, function(err,result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send({"object":"profile","name":req.body.name,"event":"created"});
				}
			});
		connection.release();
	});
}

function createCloudProfile(req,res) {

	console.log("Creating new profile: " + req.body.name);

	profileConnectionPool.getConnection(function (err, connection) {

		var newRecord = {name: req.body.title, version: req.body.sha, status: '2', content: req.body.content_utf8,
			published: req.body.version};

		if (req.body.imgUrl) {
			newRecord.image_url = req.body.imgUrl;
		}

		connection.query('insert into ' + resource_profile_db + '.installed_store_profiles set ?',
			newRecord, function (err, result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send({"object": "profile", "name": req.body.name, "event": "created"});
				}
			});
		connection.release();
	});
}

function updateCloudProfile(req,res) {

	// var errorResult = {"object":"profile","id":req.body.id,"event":"update","error":"profile id =" + req.body.id + " is not found in the database."};

	profileConnectionPool.getConnection( function(err,connection) {

		console.log("Updating profile name=" + req.body.name);

		var updateRecord = {};

		if (req.body.sha) {
			updateRecord.version=req.body.sha;
			console.log("\tversion:" + req.body.sha);
		};
		if (req.body.content_utf8) {
			updateRecord.content=req.body.content_utf8;
			console.log("\tcontent:...");
		};

        var oibView = resource_profile_db + '.installed_store_profiles.name';

		var name = { oibView : req.body.name };

		connection.query('update low_priority ' + resource_profile_db + '.installed_store_profiles set version = ?, content=?, image_url=?, published=? where name = ?',
			[req.body.sha, req.body.content_utf8, req.body.image_url, req.body.published, req.body.name], function(err,result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send({"object":"profile","name":req.body.name,"event":"updated"});
				}
			});

		connection.release();
	});
}

function updateCloudStatus(req,res) {

	// var errorResult = {"object":"profile","id":req.body.id,"event":"update","error":"profile id =" + req.body.id + " is not found in the database."};

	profileConnectionPool.getConnection( function(err,connection) {

		console.log("Updating profile name=" + req.body.name);

		var updateRecord = {};

		if (req.body.sha) {
			updateRecord.version=req.body.status;
			console.log("\tstatus:" + req.body.status);
		};

		connection.query('update low_priority ' + resource_profile_db + '.installed_store_profiles set status = ? where id = ?',
			[req.body.status, req.body.id], function(err,result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send({"object":"profile","name":req.body.name,"event":"updated status"});
				}
			});

		connection.release();
	});
}


function updateProfile(req,res) {

	// var errorResult = {"object":"profile","id":req.body.id,"event":"update","error":"profile id =" + req.body.id + " is not found in the database."};

	profileConnectionPool.getConnection( function(err,connection) {

		console.log("Updating profile id=" + req.body.id);

		var updateRecord = {};

		if (req.body.name) {
			updateRecord.name=req.body.name;
			console.log("\tname:" + req.body.name);
		};
		if (req.body.version) {
			updateRecord.version=req.body.version;
			console.log("\tversion:" + req.body.version);
		};
		if (req.body.status) {
			updateRecord.status=req.body.status;
			console.log("\tstatus:" + req.body.status);
		};
		if (req.body.image_url) {
			updateRecord.image_url=req.body.image_url;
			console.log("\timage_url:" + req.body.image_url);
		};
		if (req.body.content_utf8) {
			updateRecord.content=req.body.content_utf8;
			console.log("\tcontent:...");
		};

		connection.query('update ' + resource_profile_db + '.custom_profiles rp set name = ?, version = ?, status = ?, image_url = ?, content = ? where id = ?',
			[req.body.name, req.body.version, req.body.status, req.body.image_url, req.body.content_utf8, req.body.id], function(err,result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send({"object":"profile","id":req.body.id,"event":"updated"});
				}
			});

		connection.release();
	});
}

function getAssets(req,res) {
	
	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + responder_db + '.OIB_ASSET', function(err,rows,fields) {
			res.send(rows);
		});
		connection.release();
	});
	
}

function getAsset(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + responder_db + '.OIB_ASSET where ASSET_ID=' + req.params.id, function(err,rows,fields) {
			res.send(rows[0]);
		});
		connection.release();
	});

}

function createAsset(req,res) {

	console.log("Creating new asset: " + req.body.displayName);

	profileConnectionPool.getConnection( function(err,connection) {

		var newRecord = {
			ASSET_ID:req.body.ASSET_ID,
			DISPLAY_NAME:req.body.DISPLAY_NAME,
			NAMESPACE_CD:req.body.NAMESPACE_CD,
			ASSET_URL:req.body.ASSET_URL,
			ASSET_MIME_TYPE:req.body.ASSET_MIME_TYPE
		};

		connection.query('insert into ' + responder_db + '.OIB_ASSET set ?',
			newRecord, function(err,result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send([{"object":"asset","name":req.body.displayName,"event":"created"}]);
				}
			});
		connection.release();
	});
}

function updateAsset(req,res) {

	console.log("Updating asset: " + req.body.displayName);

	profileConnectionPool.getConnection( function(err,connection) {

		var updateRecord = {};
		
		if (req.body.displayName) {
			updateRecord.DISPLAY_NAME=req.body.DISPLAY_NAME;
		}
		if (req.body.namespace) {
			updateRecord.NAMESPACE_CD=req.body.NAMESPACE_CD;
		}
		if (req.body.assetUrl) {
			updateRecord.ASSET_URL=req.body.ASSET_URL;
		}
    	if (req.body.assetMimeType) {
			updateRecord.ASSET_MIME_TYPE=req.body.ASSET_MIME_TYPE;
		}

		connection.query('update ' + responder_db + '.OIB_ASSET set DISPLAY_NAME = ?, NAMESPACE_CD = ?, ASSET_URL = ?, ASSET_MIME_TYPE = ? where ASSET_ID= ?',
			[req.body.DISPLAY_NAME, req.body.NAMESPACE_CD, req.body.ASSET_URL, req.body.ASSET_MIME_TYPE, req.body.ASSET_ID], function(err,result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send([{"object":"asset","name":req.body.displayName,"event":"updated"}]);
				}
			});
		connection.release();
	});
}

function getAssetProperties(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + responder_db + '.OIB_ASSET_PROPERTY where ASSET_ID=' + req.params.assetId, function(err,rows,fields) {
			res.send(rows);
		});
		connection.release();
	});

}

function getAssetProperty(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + responder_db + '.OIB_ASSET_PROPERTY where ASSET_PROPERTY_ID=' + req.params.assetPropertyId, function(err,rows,fields) {
			res.send(rows);
		});
		connection.release();
	});

}

function createAssetProperty(req,res) {
	
	var newAssetProperty = {
		ASSET_PROPERTY_ID: req.body.ASSET_PROPERTY_ID, // need to come up with distributed ID strategy
		ASSET_ID:       req.body.ASSET_ID,
		PROP_NAME:      req.body.PROP_NAME,
		PROP_TYPE_CD:   req.body.PROP_TYPE_CD,
		CODE:           req.body.CODE,
		CODE_SYSTEM:    req.body.CODE_SYSTEM,
		DISPLAY_NAME:   req.body.DISPLAY_NAME,
		PROP_VALUE:     req.body.PROP_VALUE,
		GENERATED_BY_CD:"AUTHOR"
	}

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('insert into ' + responder_db + '.OIB_ASSET_PROPERTY set ? ', newAssetProperty,
		 function(err,result) {
			if (err) {
				throw err;
			}
			if (result) {
				res.type('application/json')
				res.send([{"object":"assetProperty","name":"asset(" + req.body.assetId + ")." + req.body.propertyName,"event":"created"}]);
			}
		});
		connection.release();
	});

}

function updateAssetProperty(req,res) {
	
	var updateRecord = {};
	
	if (req.body.assetId) {
		updateRecord.ASSET_ID = req.body.ASSET_ID;
	}
	if (req.body.propertyName) {
		updateRecord.PROP_NAME = req.body.PROP_NAME;
	}
	if (req.body.propertyType) {
		updateRecord.PROP_TYPE_CD = req.body.PROP_TYPE_CD;
	}
	if (req.body.code) {
		updateRecord.CODE = req.body.CODE;
	}
	if (req.body.codeSystem) {
		updateRecord.CODE_SYSTEM = req.body.CODE_SYSTEM;
	}
	if (req.body.displayName) {
		updateRecord.DISPLAY_NAME = req.body.DISPLAY_NAME;
	}
	if (req.body.propertyValue) {
		updateRecord.PROP_VALUE = req.body.PROP_VALUE;
	}

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('update ' + responder_db + '.OIB_ASSET_PROPERTY set ? where ASSET_PROPERTY_ID=' + req.body.assetPropertyId, updateRecord,
			function(err,result) {
				if (err) {
					throw err;
				}
				if (result) {
					res.type('application/json')
					res.send([{"object":"assetProperty","name":"assetPropety(" + req.body.assetPropertyId + ")","event":"updated"}]);
				}
			});
		connection.release();
	});

}

function getValueSets(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + responder_db + '.OIB_VALUE_SET', function(err,rows,fields) {
			res.send(rows);
		});
		connection.release();
	});
	
}

function getValueSet(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query('select * from ' + responder_db + '.OIB_VALUE_SET_CODE where VALUE_SET_ID=' + req.params.valueSetId + ' ORDER BY LIST_ORDER ASC', function(err,rows,fields) {
			res.send(rows);
		});
		connection.release();
	});
	
}

function getRequestParameters(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query(
			'select * from ' + responder_db + '.OIB_REQUEST_PARAMETER order by PARAMETER_NAME', function(err,rows,fields) {
 		 		res.send(rows);
		});
		connection.release();
	});
	
}

function getRequestParameterRoots(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query(
			'select distinct PARAMETER_ROOT from ' + responder_db + '.OIB_REQUEST_PARAMETER where PARAMETER_ROOT is not null order by PARAMETER_ROOT', function(err,rows,fields) {
				res.send(rows);
		});
		connection.release();
	});
	
}

function getRequestParameter(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		connection.query(
			'select * from ' + responder_db + '.OIB_REQUEST_PARAMETER where REQUEST_PARAMETER_ID=' + req.params.requestParameterId, function(err,rows,fields) {
				res.send(rows);
		});
		connection.release();
	});
	
}

function getRequestParametersByParameterRoot(req,res) {

	responderConnectionPool.getConnection( function(err,connection) {
		
		var queryString = 'select * from ' + responder_db + '.OIB_REQUEST_PARAMETER where PARAMETER_ROOT=\'' + req.params.parameterRoot + '\' order by PARAMETER_ROOT asc, TYPE_CD asc';
		  		
		connection.query( queryString, function(err,rows,fields) {
				res.send(rows);
		});
		connection.release();
	});
	
}


app.get('/profiles', function(req,res){ getProfiles(req,res); } );
app.get('/cloudProfiles', function(req,res){ getLocalCloudProfiles(req,res); } );
app.get('/profile/:id', function(req,res){ getProfile(req,res); } );
app.put('/profile/create', function(req,res){ createProfile(req,res); });
app.put('/profile/download', function(req,res){ createCloudProfile(req,res); });
app.put('/profile/updateCloud', function(req,res){ updateCloudProfile(req,res); });
app.put('/profile/updateCloudStatus', function(req,res){ updateCloudStatus(req,res); });
app.put('/profile/update', function(req,res){ updateProfile(req,res); });
app.get('/assets', function(req,res) { getAssets(req,res); });
app.get('/asset/:id', function(req,res) { getAsset(req,res); });
app.put('/asset/create', function (req,res) { createAsset(req,res); });
app.put('/asset/update', function (req,res) { updateAsset(req,res); });

app.get('/assetProperties/:assetId', function(req,res) { getAssetProperties(req,res); });
app.get('/assetProperty/:assetPropertyId', function(req,res) { getAssetProperty(req,res); });
app.put('/assetProperty/create', function (req,res) { createAssetProperty(req,res); });
app.put('/assetProperty/update', function (req,res) { updateAssetProperty(req,res); });

app.get('/valueSets', function(req,res) { getValueSets(req,res); });
app.get('/valueSet/:valueSetId', function(req,res) { getValueSet(req,res); });

app.get('/requestParameters', function(req,res) { getRequestParameters(req,res); });
app.get('/requestParameterRoots', function(req,res) { getRequestParameterRoots(req,res); });
app.get('/requestParameters/:parameterRoot', function(req,res) { getRequestParametersByParameterRoot(req,res); });
app.get('/requestParameter/:requestParameterId', function(req,res) { getRequestParameter(req,res); });

app.listen(3000);
console.log('OpenInfobutton Rest Services Listening on port 3000');