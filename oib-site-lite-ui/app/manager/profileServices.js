'use strict';

var oibManagerServiceModule = angular.module('oibManagerServiceModule', ['ngResource', 'ab-base64']);

var baseRepoUrl = 'https://api.github.com/repos/' + localStorage.getItem('gitRepo');
var baseCloudUrl = baseRepoUrl + '/contents/';
var baseCommitUrl = baseRepoUrl + '/commits?sha=development&path=' + localStorage.getItem('profileStorePath') + '/';
var profileDirectoryUrl = baseCloudUrl + localStorage.getItem('profileStorePath') + '?ref=development';
var valueSetDirectoryUrl = baseCloudUrl + 'valuesets' + '?ref=development';

oibManagerServiceModule.factory('profileFactory', ['$http', 'base64', 'propertiesService', function($http, base64, propertiesService) {

    var oibManagerUrl = 'https://' + localStorage.getItem('hostName') + '/infobutton-service/liteManager/'
    var profileFactory = {};

    profileFactory.getProfiles = function () {
        return $http.get(oibManagerUrl + 'customProfiles', {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    profileFactory.getProfile = function (id) {
       return $http.get(oibManagerUrl + 'getProfile/' + id, {
            headers: {
                'Authorization' : undefined
            }
        }).success(function (response) {
           return response;
       });
    };

    profileFactory.getJSONProfile = function (id) {
        return $http.get(oibManagerUrl + 'jsonProfile/' + id, {
            headers: {
                'Authorization' : undefined
            }
        }).success(function (response) {
            return response;
        });
    };

    profileFactory.insertProfile = function (profile) {
        return $http.post(oibManagerUrl + 'createProfile', profile, {
            headers: {
                'Authorization' : undefined
            }
        }).success(function (response) {
            return response;
        }).error (function (error) {
            return error;
        });
    };

    profileFactory.updateProfileContent = function (profile, id) {
        return $http.post(oibManagerUrl + 'updateCustomProfile/' + id, profile, {
            headers: {
                'Authorization' : undefined
            }
        }).success(function (response) {
            return response;
        }).error (function (error) {
            return error;
        });
    };

    profileFactory.getValueSets = function() {

        var valueSetList = [];
        var gitUser = {};
        propertiesService.getGitUsername().then(function(data) {

            gitUser.user = data.propValue;
            return propertiesService.getGitPassword();
        }).then(function(data)
        {
            gitUser.password = data.propValue;
            return;
        }).then(function()
        {
            $http.defaults.headers.common.Authorization = 'Basic ' + base64.encode(gitUser.user + ':' + gitUser.password);
            return;
        }).then(function(){
            $http.get(valueSetDirectoryUrl).success(function (data) {

                data.forEach(function (valueset) {

                    if (valueset.name.indexOf("[") != -1)
                    {
                        valueset = valueset.name.substring(0, valueset.name.length - 11)
                    }
                    else
                    {
                        valueset = valueset.name.substring(0, valueset.name.length - 5)
                    }
                    valueSetList.push({"name" : valueset, "value" : { "id" : valueset, "name" : valueset, "namespace" :"" }});
                })
            });
        });
        return valueSetList;
    };

    profileFactory.getOids = function (profile) {

        var xmlProfile;
        if (window.DOMParser)
        {
            var parser=new DOMParser();
            xmlProfile=parser.parseFromString(profile.content,"text/xml");
        }
        else // code for IE
        {
            xmlProfile=new ActiveXObject("Microsoft.XMLDOM");
            xmlProfile.async=false;
            xmlProfile.loadXML(profile.content);
        }
        var x = xmlProfile.getElementsByTagName("authorizedOrganization");
        var oids = [];
        for (var i = 0; i < x.length; i++)
        {
            oids.push({orgOid : x[i].id, orgName : x[i].getAttribute("name"), selected : false})
        }
        return oids;
    };

    profileFactory.changeOids = function (profile, oids) {

        var xmlDoc;
        if (window.DOMParser)
        {
            var parser=new DOMParser();
            xmlDoc=parser.parseFromString(profile.content,"text/xml");
        }
        else // code for IE
        {
            xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async=false;
            xmlDoc.loadXML(profile.content);
        }
        var authorizedOrgs = xmlDoc.createElement('authorizedOrganizations');
        var authorizedOrg;
        var nameattr;
        var idattr;

        for (var i = 0; i < oids.items.length; i++)
        {
            authorizedOrg = xmlDoc.createElement('authorizedOrganization');
            nameattr = xmlDoc.createAttribute("name");
            idattr = xmlDoc.createAttribute("id");
            nameattr.nodeValue = oids.items[i].orgName;
            idattr.nodeValue = oids.items[i].orgOid;
            authorizedOrg.setAttributeNode(nameattr);
            authorizedOrg.setAttributeNode(idattr);
            authorizedOrgs.appendChild(authorizedOrg)
        }

        var oidsString = new XMLSerializer().serializeToString(authorizedOrgs);
        var x = xmlDoc.getElementsByTagName("authorizedOrganizations")[0];
        while (x.firstChild)
        {
            x.removeChild(x.firstChild);
        }
        for (var oid=authorizedOrgs.childNodes.length - 1; oid > -1; oid--)
        {
            x.appendChild(authorizedOrgs.getElementsByTagName("authorizedOrganization")[oid]);
        }
        var xelement = new XMLSerializer().serializeToString(x);
        var newProfile = new XMLSerializer().serializeToString(xmlDoc);
        profile.content_utf8 = newProfile;
        var profileJsonString = {'version' : profile.version, 'name' : profile.name, 'content' : profile.content_utf8, 'imageUrl': profile.imageUrl, 'status' : profile.status, 'id' : profile.id};
        return $http.post(oibManagerUrl + 'createProfile', profileJsonString, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    return profileFactory;
}]);

var uuidGenerator = angular.module('uuidGenerator', []);
uuidGenerator.factory("idGenerator", function () {
    return {
        getNewUuid: function () {
            // http://www.ietf.org/rfc/rfc4122.txt
            var s = [];
            var hexDigits = "0123456789abcdef";
            for (var i = 0; i < 36; i++) {
                s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
            }
            s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
            s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
            s[8] = s[13] = s[18] = s[23] = "-";
            return s.join("");
        }
    }
});

oibManagerServiceModule.factory('cloudProfileFactory', ['$http', '$resource', 'idGenerator', '$filter', 'propertiesService', function ($http, $resource, idGenerator, $filter, propertiesService) {

    var oibManagerUrl = 'https://' + localStorage.getItem('hostName') + '/infobutton-service/liteManager/'

    var cloudProfileFactory = {};

    cloudProfileFactory.getNewId = function () {
        return idGenerator.getNewUuid();
    };
    cloudProfileFactory.getSiteProfiles = function () {
        return testSiteProfiles;
    };
    cloudProfileFactory.addSiteProfile = function (profile) {
    };
    cloudProfileFactory.deleteSiteProfile = function (profileId) {
    };
    cloudProfileFactory.changeSiteProfileStatus = function (status) {
    };

    cloudProfileFactory.getCloudProfiles = function(base64) {
        var profileLinkList = [];
        var jsonString = {};
        var gitUser ={};
        propertiesService.getGitUsername().then(function(data) {

            gitUser.user = data.propValue;
            return propertiesService.getGitPassword();
        }).then(function(data)
        {
            gitUser.password = data.propValue;
            return;
        }).then(function()
        {
            $http.defaults.headers.common.Authorization = 'Basic ' + base64.encode(gitUser.user + ':' + gitUser.password);
            return;
        }).then(function(){
            $http.get(profileDirectoryUrl).success(function (data) {

                data.forEach(function (profileLink) {

                    // filter xml files only
                    if (profileLink.path.indexOf('.xml') === (profileLink.path.length - 4)) {

                        var profileUrl = baseCloudUrl + profileLink.path + '?ref=development';
                        var profileInJson = $http.get(profileUrl).success(function (data) {

                            var xmlContentString = base64.decode(data.content);
                            var xmlDoc = $.parseXML(xmlContentString);
                            var $xml = $(xmlDoc);
                            var $title = $xml.find("title");
                            var $contexts = $xml.find("context");
                            var $profileD = $xml.find("profileDescription");
                            var profileDescription = $profileD.text();
                            var $versionControl = $xml.find("versionControl");
                            var version = $versionControl[0].attributes[0].value;
                            var attr0 = $contexts[0].attributes[0].value;
                            var imageUrl = $filter('limitTo')(profileLink.path, profileLink.path.length - 4);
                            $http.get(baseCommitUrl + data.name)
                                .success (function(commit) {
                                    $http.get(baseCloudUrl + imageUrl + '.gif'  + '?ref=development')
                                        .success(function(image) {
                                            imageUrl = image.download_url;
                                            if ($title.text().length > 1) {
                                                jsonString = {'sha': data.sha, 'url': profileLink.url, 'title': data.name, 'description': attr0, 'version': commit[0].commit.committer.date,
                                                    'content_utf8': xmlContentString, 'gitUrl': profileLink.html_url, 'profileDescription': profileDescription, 'imgUrl': imageUrl};
                                                profileLinkList.push(jsonString);
                                            }
                                        })
                                        .error(function() {
                                            $http.get(baseCloudUrl + imageUrl + '.png'  + '?ref=development')
                                                .success(function(image) {
                                                    imageUrl = image.download_url;
                                                    if ($title.text().length > 1) {
                                                        jsonString = {'sha': data.sha, 'url': profileLink.url, 'title': data.name, 'description': attr0, 'version': commit[0].commit.committer.date,
                                                            'content_utf8': xmlContentString, 'gitUrl': profileLink.html_url, 'profileDescription': profileDescription, 'imgUrl': imageUrl};
                                                        profileLinkList.push(jsonString);
                                                    }
                                                })
                                                .error(function() {
                                                    imageUrl = null;
                                                    if ($title.text().length > 1) {
                                                        jsonString = {'sha': data.sha, 'url': profileLink.url, 'title': data.name, 'description': attr0, 'version': commit[0].commit.committer.date,
                                                            'content_utf8': xmlContentString, 'gitUrl': profileLink.html_url, 'profileDescription': profileDescription, 'imgUrl': imageUrl};
                                                        profileLinkList.push(jsonString);
                                                    }
                                                })
                                        });
                                });
                        });
                    }
                });
            });
        });

        return profileLinkList;
    };

    cloudProfileFactory.getOids = function (profile) {

        var xmlProfile;
        if (window.DOMParser)
        {
            var parser=new DOMParser();
            xmlProfile=parser.parseFromString(profile.content,"text/xml");
        }
        else // code for IE
        {
            xmlProfile=new ActiveXObject("Microsoft.XMLDOM");
            xmlProfile.async=false;
            xmlProfile.loadXML(profile.content);
        }
        var x = xmlProfile.getElementsByTagName("authorizedOrganization");
        var oids = [];
        for (var i = 0; i < x.length; i++)
        {
            oids.push({orgOid : x[i].id, orgName : x[i].getAttribute("name"), selected : false})
        }
        return oids;
    };

    cloudProfileFactory.updateProfile = function(profile, cloudProfileLinks) {

            $http.get(baseCloudUrl + 'profilestore/' + profile.name + '?ref=development').success(function (profileData) {

                var xmlContentString = atob(profileData.content);
                var xmlProfile;
                if (window.DOMParser)
                {
                    var parser=new DOMParser();
                    xmlProfile=parser.parseFromString(profile.content,"text/xml");
                }
                else // code for IE
                {
                    xmlProfile=new ActiveXObject("Microsoft.XMLDOM");
                    xmlProfile.async=false;
                    xmlProfile.loadXML(profile.content);
                }
                var x = xmlProfile.getElementsByTagName("authorizedOrganizations")[0];
                var xelement = new XMLSerializer().serializeToString(x);
                var xmlDoc = $.parseXML(xmlContentString);
                var $xml = $(xmlDoc);
                $xml.find("authorizedOrganizations").replaceWith(xelement);
                var xmlString = (new XMLSerializer()).serializeToString(xmlDoc);
                var $contexts = $xml.find("context");
                var attr0 = $contexts[0].attributes[0].value;
                var imgUrl = profile.image_url;
                cloudProfileLinks.forEach (function(profileLink) {
                    if (profileLink.title == profile.name)
                    {
                        imgUrl = profileLink.imgUrl;
                        profile.published = profileLink.version;
                    }
                });
                var profileJsonString = {'version' : profileData.sha, 'name' : profile.name, 'content' : xmlString,
                    'imageUrl': imgUrl, 'published': profile.published, 'id' : profile.id, 'status' : profile.status};
                $http.post(oibManagerUrl + 'createCloudProfile', profileJsonString, {
                    headers: {
                        'Authorization' : undefined
                    }
                });

            });
    };

    cloudProfileFactory.updateStatus = function (profile) {
        return $http.post(oibManagerUrl + 'createCloudProfile', profile, {
            headers: {
                'Authorization' : undefined
            }
        });
    };
    cloudProfileFactory.downloadProfile = function (profile, oids) {

        var xmlDoc;
        if (window.DOMParser)
        {
            var parser=new DOMParser();
            xmlDoc=parser.parseFromString(profile.content_utf8,"text/xml");
        }
        else // code for IE
        {
            xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async=false;
            xmlDoc.loadXML(profile.content_utf8);
        }
        var authorizedOrgs = xmlDoc.createElement('authorizedOrganizations');
        var authorizedOrg;
        var nameattr;
        var idattr;

        for (var i = 0; i < oids.items.length; i++)
        {
            authorizedOrg = xmlDoc.createElement('authorizedOrganization');
            nameattr = xmlDoc.createAttribute("name");
            idattr = xmlDoc.createAttribute("id");
            nameattr.nodeValue = oids.items[i].orgName;
            idattr.nodeValue = oids.items[i].orgOid;
            authorizedOrg.setAttributeNode(nameattr);
            authorizedOrg.setAttributeNode(idattr);
            authorizedOrgs.appendChild(authorizedOrg)
        }

        var oidsString = new XMLSerializer().serializeToString(authorizedOrgs);
        var x = xmlDoc.getElementsByTagName("authorizedOrganizations")[0];
        while (x.firstChild)
        {
            x.removeChild(x.firstChild);
        }
        for (var oid=authorizedOrgs.childNodes.length - 1; oid > -1; oid--)
        {
            x.appendChild(authorizedOrgs.getElementsByTagName("authorizedOrganization")[oid]);
        }
        var xelement = new XMLSerializer().serializeToString(x);
        var newProfile = new XMLSerializer().serializeToString(xmlDoc);
        profile.content = newProfile;
        profile.imageUrl = profile.imgUrl;
        profile.version = profile.sha;
        profile.name = profile.title;
        profile.status = 3;
        return $http.post(oibManagerUrl + 'createCloudProfile', profile, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    cloudProfileFactory.changeOids = function (profile, oids) {

        var xmlDoc;
        if (window.DOMParser)
        {
            var parser=new DOMParser()
            xmlDoc=parser.parseFromString(profile.content,"text/xml");
        }
        else // code for IE
        {
            xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async=false;
            xmlDoc.loadXML(profile.content);
        }
        var authorizedOrgs = xmlDoc.createElement('authorizedOrganizations');
        var authorizedOrg;
        var nameattr;
        var idattr;

        for (var i = 0; i < oids.items.length; i++)
        {
            authorizedOrg = xmlDoc.createElement('authorizedOrganization');
            nameattr = xmlDoc.createAttribute("name");
            idattr = xmlDoc.createAttribute("id");
            nameattr.nodeValue = oids.items[i].orgName;
            idattr.nodeValue = oids.items[i].orgOid;
            authorizedOrg.setAttributeNode(nameattr);
            authorizedOrg.setAttributeNode(idattr);
            authorizedOrgs.appendChild(authorizedOrg)
        }

        var oidsString = new XMLSerializer().serializeToString(authorizedOrgs);
        var x = xmlDoc.getElementsByTagName("authorizedOrganizations")[0];
        while (x.firstChild)
        {
            x.removeChild(x.firstChild);
        }
        for (var oid=authorizedOrgs.childNodes.length - 1; oid > -1; oid--)
        {
            x.appendChild(authorizedOrgs.getElementsByTagName("authorizedOrganization")[oid]);
        }
        var xelement = new XMLSerializer().serializeToString(x);
        var newProfile = new XMLSerializer().serializeToString(xmlDoc);
        profile.content_utf8 = newProfile;
        var profileJsonString = {'version' : profile.version, 'name' : profile.name, 'content' : profile.content_utf8,
            'imageUrl': profile.imageUrl, 'published': profile.published, 'id' : profile.id, 'status' : profile.status};
        return $http.post(oibManagerUrl + 'createCloudProfile', profileJsonString, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    cloudProfileFactory.getLocalCloudProfiles = function () {
        return $http.get(oibManagerUrl + 'cloudProfiles', {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    cloudProfileFactory.getGitProfilesFromUrl = function () {   //return cloudProfiles;};

        var profileLinkList = [];
        $http.get(profileDirectoryUrl).success(function (data) {

            data.forEach(function (profileLink) {

                // filter xml files only
                if (profileLink.path.indexOf('.xml') === (profileLink.path.length - 4)) {

                    var profileUrl = baseCloudUrl + profileLink.path;
                    var profileInJson = $http.get(profileUrl).success(function (profileData) {

                        var xmlContentString = atob(profileData.content);
                        var xmlDoc = $.parseXML(xmlContentString);
                        var $xml = $(xmlDoc);
                        var $title = $xml.find("title");
                        var $contexts = $xml.find("context");
                        var attr0 = $contexts[0].attributes[0].value;
                        if ($title.text().length > 1) {
                            var jsonString = {'sha': profileData.sha, 'url': profileLink.url, 'title': $title.text(), 'description': attr0};
                            profileLinkList.push(jsonString);
                        }

                    });
                }
            });
        });

        return profileLinkList;

    };

    return cloudProfileFactory;

}]);

oibManagerServiceModule.service('properties', function () {

    return function(selectedProperty, assetId) {
        var instance = $uibModal.open({
            templateUrl: 'responder/editProperty.html',
            controller: 'ProfileFormCtrl',
            controllerAs: 'ProfileFormCtrl',
            resolve: {
                selectedProperty : function () {

                    return selectedProperty;
                },
                assetId : function () {

                    return assetId;
                }
            }
        });

        return instance.result;
    };

});

