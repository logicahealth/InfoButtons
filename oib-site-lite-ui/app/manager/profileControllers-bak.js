'use strict';

var oibManagerModule = angular.module('oibManagerModule', ['ngRoute']);

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

oibManagerModule.controller('ProfileCtrl', ['$scope', 'ProfileService', function ($scope, ProfileService) {

//        $scope.profileLinks = [{logo: "http://www.uptodate.com/images/UTD3_masthead.png", cha: "c1", title: "UpToDate", description: "Evidence-based clinical decision support resources."}
//            , {logo: "http://static.pubmed.gov/portal/portal3rc.fcgi/3908092/img/546849", cha: "c2", title: "PubMed Health", description: "Information for consumers and clinicians on prevention and treatment of diseases and conditions."}
//            , {logo: "http://www.merckmanuals.com/assets/images/logo-small.png", cha: "c3", title: "Merck Manual", description: "Concise and complete medical references for doctors, medical students, and healthcare professionals."}];

//        $scope.cloudProfileLinks = [{cha: "cha1.1", title: "Cloud Profile Title 1.1", description: "How about this cloud profile 1.1"}
//            , {cha: "cha2", title: "Cloud Profile Title 2", description: "This is the extra awesome profile 2"}
//            , {cha: "cha3.1", title: "Cloud Profile Title 3.1", description: "This is cloud profile 3.1"}];
        
        var profileLinks = [];
        profileLinks = ProfileService.getSiteProfiles();
        $scope.profileLinks = profileLinks;

        var cloudProfileLinks = [];
        cloudProfileLinks = ProfileService.getCloudProfiles();
        $scope.cloudProfileLinks = cloudProfileLinks;

        return $scope;
    }]);

oibManagerModule.controller('ProfileFormCtrl', ['$scope', '$routeParams', 'ProfileService', function ($scope,$routeParams,ProfileService) {

        $scope.master = [];
        $scope.profile = function () {
            if ($routeParams.cloudId) {
                return ProfileService.getCloudProfile();
            }
        }
        
        $scope.clearDb = function() {
            $scope.master = [];
        }
        
        var getProfileIndexById = function (profiles, id) {

            for (var i=0; i < profiles.length; i++ ) {
                
                if ( profiles[i].id === id ) {
                    return i;
                    break;
                }
                
            }
            
            return -1;

        }
        
        $scope.clearForm = function(profile) {
            $scope.profile = {};
        }
        
        $scope.create = function(profile) {
            profile.id = ProfileService.getNewId();
            $scope.master.push(angular.copy(profile));
        };
        
        $scope.update = function(profile) {
                        
            var i = getProfileIndexById($scope.master, profile.id);       
            
            if ( i > -1 ) {
                $scope.master[i] = angular.copy(profile);
            } else {
                $scope.create(profile);
            }
            
        };
        
        $scope.delete = function(profile) {
            
            var i = getProfileIndexById($scope.master, profile.id);       
            
            if ( i > -1 ) {
                $scope.master.splice(i,1);
            }
            
        };

        return $scope;
    }]);

oibManagerModule.controller('CloudProfileCtrl', ['$scope', 'CloudProfileService', function ($scope, CloudProfileService) {

        $scope.cloudProfileLinks = [{cha: "cha1.1", title: "Cloud Profile Title 1.1", description: "How about this cloud profile 1.1"}
            , {cha: "cha2", title: "Cloud Profile Title 2", description: "This is the extra awesome profile 2"}
            , {cha: "cha3.1", title: "Cloud Profile Title 3.1", description: "This is cloud profile 3.1"}];

        return $scope;
    }]);
