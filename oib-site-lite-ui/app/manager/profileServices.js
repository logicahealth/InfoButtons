'use strict';

var oibManagerServiceModule = angular.module('oibManagerServiceModule', ['ngResource']);

var baseCloudUrl = 'https://api.github.com/repos/VHAINNOVATIONS/InfoButtons/contents/';
var profileDirectoryUrl = baseCloudUrl + 'profilestore?ref=development';
var profileContentUrl = baseCloudUrl + 'git/blobs/';

var testCloudProfiles = [{cha: "cha1.1", title: "cloud title 1.1", description: "cloud profile 1.1"}
    , {cha: "cha2", title: "site title 2", description: "site profile 2"}
    , {cha: "cha3.1", title: "cloud title 3.1", description: "cloud profile 3.1"}];

var testSiteProfiles = [{logo: "http://www.uptodate.com/images/UTD3_masthead.png", cha: "c1", title: "UpToDate", description: "Evidence-based clinical decision support resources."}
    , {logo: "http://static.pubmed.gov/portal/portal3rc.fcgi/3908092/img/546849", cha: "c2", title: "PubMed Health", description: "Information for consumers and clinicians on prevention and treatment of diseases and conditions."}
    , {logo: "http://www.merckmanuals.com/assets/images/logo-small.png", cha: "c3", title: "Merck Manual", description: "Concise and complete medical references for doctors, medical students, and healthcare professionals."}];

oibManagerServiceModule.factory('profileFactory', ['$http', function($http) {

    var urlBase = 'http://localhost:3000/';
//    var urlBase = 'http://service.oib.utah.edu:8080/infobutton-service-dev/manager/';
    var profileFactory = {};

    profileFactory.getProfiles = function () {
        return $http.get(urlBase + 'profiles', {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    profileFactory.getProfile = function (id) {
        return $http.get(urlBase + 'profile/' + id, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    profileFactory.insertProfile = function (profile) {
        return $http.put(urlBase + 'profile/create', profile, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    profileFactory.updateProfile = function (profile) {
        return $http.put(urlBase + 'profile/update', profile, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    profileFactory.deleteProfile = function (id) {
        return $http.delete(urlBase + 'profile/delete/' + id, {
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

oibManagerServiceModule.factory('cloudProfileFactory', ['$http', '$resource', 'idGenerator', function ($http, $resource, idGenerator) {

    var serviceUrlBase = 'http://localhost:3000/';

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
        $http.defaults.headers.common.Authorization = 'Basic ' + base64.encode('aniskand:WND-r3700');

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
                        if ($title.text().length > 1) {
                            jsonString = {'sha': data.sha, 'url': profileLink.url, 'title': data.name, 'description': attr0, 'version': version,
                                            'content_utf8': xmlContentString, 'gitUrl': profileLink.html_url, 'profileDescription': profileDescription};
                            profileLinkList.push(jsonString);
                        }

                    });
                }
            });
        });
        return profileLinkList;
    };

    cloudProfileFactory.updateProfile = function(profile) {

            $http.get(baseCloudUrl + 'profilestore/' + profile.name + '?ref=development').success(function (profileData) {

                var xmlContentString = atob(profileData.content);
                var xmlDoc = $.parseXML(xmlContentString);
                var $xml = $(xmlDoc);
                var $contexts = $xml.find("context");
                var attr0 = $contexts[0].attributes[0].value;
                var profileJsonString = {'sha' : profileData.sha, 'name' : profile.name, 'content_utf8' : xmlContentString};
                $http.put(serviceUrlBase + 'profile/updateCloud', profileJsonString, {
                    headers: {
                        'Authorization' : undefined
                    }
                });
            });
    };

    cloudProfileFactory.updateStatus = function (profile) {
        return $http.put(serviceUrlBase + 'profile/updateCloudStatus', profile, {
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
            nameattr.nodeValue = oids.items[i].name;
            idattr.nodeValue = oids.items[i].oid;
            authorizedOrg.setAttributeNode(nameattr)
            authorizedOrg.setAttributeNode(idattr)
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
        return $http.put(serviceUrlBase + 'profile/download', profile, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    cloudProfileFactory.getLocalCloudProfiles = function () {
        return $http.get(serviceUrlBase + 'cloudProfiles', {
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
