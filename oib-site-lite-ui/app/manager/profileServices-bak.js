'use strict';

var oibManagerServiceModule = angular.module('oibManagerServiceModule', ['ngResource']);

// hard-coded stuff for temporary development/testing
var baseCloudUrl = 'https://api.github.com/repos/VHAINNOVATIONS/InfoButtons/';
var profileDirectoryUrl = baseCloudUrl + 'contents/DeploymentPackage/TailoringTool';
var profileContentUrl = baseCloudUrl + 'git/blobs/';

var testCloudProfiles = [{cha: "cha1.1", title: "cloud title 1.1", description: "cloud profile 1.1"}
    , {cha: "cha2", title: "site title 2", description: "site profile 2"}
    , {cha: "cha3.1", title: "cloud title 3.1", description: "cloud profile 3.1"}];

var testSiteProfiles = [{logo: "http://www.uptodate.com/images/UTD3_masthead.png", cha: "c1", title: "UpToDate", description: "Evidence-based clinical decision support resources."}
    , {logo: "http://static.pubmed.gov/portal/portal3rc.fcgi/3908092/img/546849", cha: "c2", title: "PubMed Health", description: "Information for consumers and clinicians on prevention and treatment of diseases and conditions."}
    , {logo: "http://www.merckmanuals.com/assets/images/logo-small.png", cha: "c3", title: "Merck Manual", description: "Concise and complete medical references for doctors, medical students, and healthcare professionals."}];

var getCloudProfiles = function ($http) {

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

oibManagerServiceModule.service('CloudProfileService', ['$http', '$resource', 'idGenerator', function ($http, $resource, idGenerator) {

        this.getNewId = function () {
            return idGenerator.getNewUuid();
        };
        this.getSiteProfiles = function () {
            return testSiteProfiles;
        };
        this.addSiteProfile = function (profile) {
        };
        this.deleteSiteProfile = function (profileId) {
        };
        this.changeSiteProfileStatus = function (status) {
        };

        this.getCloudProfiles = function () {
            return testCloudProfiles; // $resource('manager/cloudProfiles', {}, {getProfiles: {method: 'GET', isArray: true}});
        }

        this.getCloudProfile = function (profileId) {

        }

        this.getProfileFromUrl = function (sha) {

            var profileJsonData = {};

            $http.get(profileContentUrl + sha).success(function (profileData) {

                var xmlContentString = atob(profileData.content);
                var xmlDoc = $.parseXML(xmlContentString);
                var $xml = $(xmlDoc);
                var $title = $xml.find("title");
                var $contexts = $xml.find("context");
                var attr0 = $contexts[0].attributes[0].value;
                if ($title.text().length > 1) {
                    profileJsonData = {'sha': profileData.sha, 'url': profileData.url, 'title': $title.text(), 'description': attr0, 'content': xmlContentString};
                }
            });
            return profileJsonData;
        };

        this.getGitProfilesFromUrl = function () {   //return cloudProfiles;};

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



    }]);
