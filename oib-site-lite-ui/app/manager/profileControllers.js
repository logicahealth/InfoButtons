'use strict';

var oibManagerModule = angular.module('oibManagerModule', ['ngRoute', 'ngResource', 'ab-base64']);

oibManagerModule.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
                .when('/editProfile', {
                    templateUrl: 'manager/profileForm.html',
                    controller: 'ProfileFormCtrl'
                })
                .when('/editProfile/:id', {
                    templateUrl: 'manager/profileForm.html',
                    controller: 'ProfileFormCtrl'
                })
                .when('/manager', {
                    templateUrl: 'manager/profiles.html',
                    controller: 'ProfileCtrl'
                })
                .when('/cloudManager', {
                    templateUrl: 'manager/cloudManager.html',
                    controller: 'CloudProfileCtrl'
                });
    }]);

oibManagerModule.controller('ProfileCtrl', ['$scope', 'profileFactory', function ($scope, profileFactory) {

        $scope.localProfiles = [];
        $scope.cloudProfiles = [];
        $scope.status;

        getLocalProfiles();

        function getLocalProfiles() {
            profileFactory.getProfiles()
                    .success(function (profiles) {
                        $scope.localProfiles = profiles;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load local profiles: ' + error;
                    });
        }

        return $scope;
    }]);

oibManagerModule.controller('ProfileFormCtrl', ['$scope', '$routeParams', 'profileFactory', function ($scope, $routeParams, profileFactory) {

        loadProfile();

        function loadProfile () {
            if ($routeParams.id) {
                profileFactory.getProfile($routeParams.id)
                    .success(function (profile) {                        
                        $scope.profile = profile;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load local profile ' + $routeParams.id + ': ' + error;
                    });
            }
        }

        $scope.clearDb = function () {

        }

        $scope.clearForm = function (profile) {
            $scope.profile = {};
        
        }

        $scope.create = function (profile) {
            
            profileFactory.insertProfile(profile)
                    .success(function (msg) {                        
                        $scope.statusMessage = msg.object + ' ' + msg.event;
                    })
                    .error(function (error) {
                        $scope.statusMessage = 'Unable to save profile:' + error;
                    });
            
        }

        $scope.update = function (profile) {
            profileFactory.updateProfile(profile)
                    .success(function (msg) {                        
                        $scope.statusMessage = msg.object + ' ' + msg.event;
                    })
                    .error(function (error) {
                        $scope.statusMessage = 'Unable to save profile:' + error;
                    });
        }

        $scope.delete = function (profile) {
            alert("delete profile!");
        }

        return $scope;
    }]);

oibManagerModule.controller('CloudProfileCtrl', ['$scope', '$http', '$route', 'base64', 'cloudProfileFactory', function ($scope, $http, $route, base64, cloudProfileFactory) {

        //$scope.cloudLinks = [{cha: "cha1.1", title: "Cloud Profile Title 1.1", description: "How about this cloud profile 1.1"}
        //    , {cha: "cha2", title: "Cloud Profile Title 2", description: "This is the extra awesome profile 2"}
        //    , {cha: "cha3.1", title: "Cloud Profile Title 3.1", description: "This is cloud profile 3.1"}];

    var cloudProfileLinks = [];

    cloudProfileLinks = cloudProfileFactory.getCloudProfiles(base64);

    getLocalCloudProfiles();

    function getLocalCloudProfiles() {
        cloudProfileFactory.getLocalCloudProfiles()
            .success(function (profiles) {
                $scope.localCloudProfiles = profiles;
            })
            .error(function (error) {
                $scope.status = 'Unable to load local profiles: ' + error;
            });
    }

    $scope.cloudProfileLinks = cloudProfileLinks;

    $scope.download = function (profile) {
        cloudProfileFactory.downloadProfile(profile)
            .success(function (msg) {
                $scope.statusMessage = msg.object + ' ' + msg.event;
            })
            .error(function (error) {
                $scope.statusMessage = 'Unable to download profile:' + error;
            });
        $route.reload();
    }

    $scope.update = function (profile) {
        cloudProfileFactory.updateProfile(profile.name);
        $route.reload();
    }

    $scope.notInstalled = function (localCloudProfiles) {

        return function (cloudProfileLink) {
            var x = true;
            localCloudProfiles.forEach(function (localProfile) {

                if (localProfile.name === cloudProfileLink.title) {
                    x = false;
                }
            });
            return x;
        }
    }

    $scope.isUpdated = function () {

        return function (localCloudProfile) {
            var x = true;
            cloudProfileLinks.forEach(function (cloudProfileLink) {

                if (localCloudProfile.name === cloudProfileLink.title) {
                    if (localCloudProfile.version != cloudProfileLink.sha)
                    x = false;
                }
            });
            return x;
        }
    }

    $scope.needsUpdate = function () {

        return function (localCloudProfile) {
            var x = false;
            cloudProfileLinks.forEach(function (cloudProfileLink) {

                if (localCloudProfile.name === cloudProfileLink.title) {
                    if (localCloudProfile.version != cloudProfileLink.sha)
                        x = true;
                }
            });
            return x;
        }
    }

    }]);
