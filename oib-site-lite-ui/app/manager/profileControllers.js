    'use strict';

var oibManagerModule = angular.module('oibManagerModule', ['ui.router','ngResource', 'ab-base64', 'ui.bootstrap']);

oibManagerModule.controller('ProfileCtrl', ['$scope', '$modal', 'profileFactory', '$state', function ($scope, $modal, profileFactory, $state) {

        $scope.localProfiles = [];
        $scope.cloudProfiles = [];
        $scope.status;
        $scope.items = JSON.parse(localStorage.getItem("oids"));

        getLocalProfiles();

        function getLocalProfiles() {
            profileFactory.getProfiles()
                    .success(function (profiles) {
                        var xmlDoc;
                        profiles.forEach (function (profile) {
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
                            var $xml = $(xmlDoc);
                            var $profileD = $xml.find("profileDescription");
                            profile.profileDescription = $profileD.text();
                        });
                        $scope.localProfiles = profiles;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load local profiles: ' + error;
                    });
        }

        $scope.updateStatus = function (profile, status) {
            profile.status = status;
            profileFactory.updateProfile(profile)
                .success(function (msg) {
                    $scope.statusMessage = msg.object + ' ' + msg.event;
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to save profile:' + error;
                });
        };

    $scope.editOids = function(profile) {

        var selectedOids = profileFactory.getOids(profile);
        var profileOids = angular.copy(selectedOids);
        var items = $scope.items;
        var uniqueItems = [];
        for (var i = 0; i < items.length; i++)
        {
            for (var c = 0; c < profileOids.length; c++)
            {
                if ((profileOids[c].orgOid != items[i].orgOid))
                {
                    if ((c + 1) == profileOids.length)
                    {
                        uniqueItems.push(items[i]);
                    }
                }
                else
                {
                    break;
                }
            }
        }
        if (profileOids.length  == 0) {

            profileOids = $scope.items;
        }
        else
        {
            for (var x = 0; x < uniqueItems.length; x++)
            {
                profileOids.push(uniqueItems[x]);
            }
        }
        var modalInstance = $modal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalController',
            resolve: {
                items: function () {
                    return profileOids;
                },
                selectedOids : function () {
                    return selectedOids;
                },
                edit: function () {

                    return true;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            changeOids(profile,selectedItem);
        }, function () {
            $scope.status ='Modal dismissed at: ' + new Date();
        });
    };

    function changeOids (profile, oids) {
        profileFactory.changeOids(profile, oids)
            .success(function (msg) {
                $scope.statusMessage = msg.object + ' ' + msg.event;
                $state.reload();
            })
            .error(function (error) {
                $scope.statusMessage = 'Unable to update profile oids:' + error;
                $state.reload();
            });
    }

    return $scope;
    }]);

oibManagerModule.controller('ProfileFormCtrl', ['$scope', '$stateParams', 'profileFactory', function ($scope, $stateParams, profileFactory) {

        loadProfile();

        function loadProfile () {
            if ($stateParams.id) {
                profileFactory.getProfile($stateParams.id)
                    .success(function (profile) {                        
                        $scope.profile = profile;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load local profile ' + $stateParams.id + ': ' + error;
                    });
            }
            else {

                $scope.new = true;
            }
        }

        $scope.clearDb = function () {

        };

        $scope.clearForm = function (profile) {
            $scope.profile = {};
        
        };

        $scope.create = function (profile) {
            
            profileFactory.insertProfile(profile)
                    .success(function (msg) {                        
                        $scope.statusMessage = msg.object + ' ' + msg.event;
                    })
                    .error(function (error) {
                        $scope.statusMessage = 'Unable to save profile:' + error;
                    });
            
        };

        $scope.update = function (profile) {

            profileFactory.updateProfile(profile)
                .success(function (msg) {
                    $scope.statusMessage = msg.object + ' ' + msg.event;
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to save profile:' + error;
                });
        };

        $scope.insert = function (profile) {
            profileFactory.insertProfile(profile)
                .success(function (msg) {
                    $scope.statusMessage = msg.object + ' ' + msg.event;
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to create profile:' + error;
                });
        };

        $scope.delete = function (profile) {
            alert("delete profile!");
        };

        return $scope;
    }]);

oibManagerModule.controller('CloudProfileCtrl', ['$scope', '$modal','$http', '$state', 'base64', 'cloudProfileFactory', function ($scope, $modal, $http, $state, base64, cloudProfileFactory) {

    $scope.repoUrl = 'https://github.com/' + 'VHAINNOVATIONS/InfoButtons' + '/blob/development/' + 'profilestore' + '/';

    var cloudProfileLinks = [];

    cloudProfileLinks = cloudProfileFactory.getCloudProfiles(base64);

    getLocalCloudProfiles();

    function getLocalCloudProfiles() {
        cloudProfileFactory.getLocalCloudProfiles()
            .success(function (profiles) {
                profiles.forEach (function (profile) {

                    var xmlDoc = $.parseXML(profile.content);
                    var $xml = $(xmlDoc);
                    var $profileD = $xml.find("profileDescription");
                    profile.profileDescription = $profileD.text();
                });
                $scope.localCloudProfiles = profiles;
            })
            .error(function (error) {
                $scope.status = 'Unable to load local profiles: ' + error;
            });
    }

    $scope.cloudProfileLinks = cloudProfileLinks;

   function downloadProfile (profile, oids) {
        cloudProfileFactory.downloadProfile(profile, oids)
            .success(function (msg) {
                $scope.statusMessage = msg.object + ' ' + msg.event;
                $state.reload();
            })
            .error(function (error) {
                $scope.statusMessage = 'Unable to download profile:' + error;
                $state.reload();
            });
    }

    function changeOids (profile, oids) {
        cloudProfileFactory.changeOids(profile, oids)
            .success(function (msg) {
                $scope.statusMessage = msg.object + ' ' + msg.event;
                $state.reload();
            })
            .error(function (error) {
                $scope.statusMessage = 'Unable to update profile oids:' + error;
                $state.reload();
            });
    }

    $scope.update = function (profile) {
        cloudProfileFactory.updateProfile(profile, $scope.cloudProfileLinks);
        confirm();
    };

    $scope.updateStatus = function (profile, status) {

        profile.status = status;
        cloudProfileFactory.updateStatus(profile);
    };

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
    };

    $scope.isUpdated = function () {

        return function (localCloudProfile) {
            var x = true;
            cloudProfileLinks.forEach(function (cloudProfileLink) {

                if (localCloudProfile.name === cloudProfileLink.title) {
                    if (localCloudProfile.version != cloudProfileLink.sha || localCloudProfile.imageUrl != cloudProfileLink.imgUrl)
                    x = false;
                }
            });
            return x;
        }
    };

    $scope.needsUpdate = function () {

        return function (localCloudProfile) {
            var x = false;
            cloudProfileLinks.forEach(function (cloudProfileLink) {

                if (localCloudProfile.name === cloudProfileLink.title) {
                    if (localCloudProfile.version != cloudProfileLink.sha || localCloudProfile.imageUrl != cloudProfileLink.imgUrl)
                        x = true;
                }
            });
            return x;
        }
    };

    var oids = [];
    oids.push({});

    $scope.items = JSON.parse(localStorage.getItem("oids"));

    $scope.openModal = function(profile) {

        var modalInstance = $modal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalController',
            resolve: {
                items: function () {
                    return $scope.items;
                },
                selectedOids : function () {
                    return [];
                },
                edit: function () {

                    return false;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            downloadProfile(profile,selectedItem);
        }, function () {
            $scope.status ='Modal dismissed at: ' + new Date();
        });
    };

    $scope.editOids = function(profile) {

        var selectedOids = cloudProfileFactory.getOids(profile);
        var profileOids = angular.copy(selectedOids);
        var items = $scope.items;
        var uniqueItems = [];
        for (var i = 0; i < items.length; i++)
        {
            for (var c = 0; c < profileOids.length; c++)
            {
                if ((profileOids[c].orgOid != items[i].orgOid))
                {
                    if ((c + 1) == profileOids.length)
                    {
                        uniqueItems.push(items[i]);
                    }
                }
                else
                {
                    break;
                }
            }
        }
        if (profileOids.length  == 0) {

            profileOids = $scope.items;
        }
        else
        {
            for (var x = 0; x < uniqueItems.length; x++)
            {
                profileOids.push(uniqueItems[x]);
            }
        }
        var modalInstance = $modal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalController',
            resolve: {
                items: function () {
                    return profileOids;
                },
                selectedOids : function () {
                    return selectedOids;
                },
                edit: function () {

                    return true;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            changeOids(profile,selectedItem);
        }, function () {
            $scope.status ='Modal dismissed at: ' + new Date();
        });
    };

    function confirm() {

        var modalInstance = $modal.open({
            templateUrl: 'confirm.html',
            controller: 'ConfirmController'
        });

        modalInstance.result.then(
            function () {
                $state.reload();
        });
    }
}]);

    /**
     * Checklist-model
     * AngularJS directive for list of checkboxes
     */

    angular.module('checklist-model', [])
        .directive('checklistModel', ['$parse', '$compile', function($parse, $compile) {
            // contains
            function contains(arr, item, comparator) {
                if (angular.isArray(arr)) {
                    for (var i = arr.length; i--;) {
                        if (comparator(arr[i], item)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            // add
            function add(arr, item, comparator) {
                arr = angular.isArray(arr) ? arr : [];
                if(!contains(arr, item, comparator)) {
                    arr.push(item);
                }
                return arr;
            }

            // remove
            function remove(arr, item, comparator) {
                if (angular.isArray(arr)) {
                    for (var i = arr.length; i--;) {
                        if (comparator(arr[i], item)) {
                            arr.splice(i, 1);
                            break;
                        }
                    }
                }
                return arr;
            }

            // http://stackoverflow.com/a/19228302/1458162
            function postLinkFn(scope, elem, attrs) {
                // compile with `ng-model` pointing to `checked`
                $compile(elem)(scope);

                // getter / setter for original model
                var getter = $parse(attrs.checklistModel);
                var setter = getter.assign;
                var checklistChange = $parse(attrs.checklistChange);

                // value added to list
                var value = $parse(attrs.checklistValue)(scope.$parent);


                var comparator = angular.equals;

                if (attrs.hasOwnProperty('checklistComparator')){
                    comparator = $parse(attrs.checklistComparator)(scope.$parent);
                }

                // watch UI checked change
                scope.$watch('checked', function(newValue, oldValue) {
                    if (newValue === oldValue) {
                        return;
                    }
                    var current = getter(scope.$parent);
                    if (newValue === true) {
                        setter(scope.$parent, add(current, value, comparator));
                    } else {
                        setter(scope.$parent, remove(current, value, comparator));
                    }

                    if (checklistChange) {
                        checklistChange(scope);
                    }
                });

                // declare one function to be used for both $watch functions
                function setChecked(newArr, oldArr) {
                    scope.checked = contains(newArr, value, comparator);
                }

                // watch original model change
                // use the faster $watchCollection method if it's available
                if (angular.isFunction(scope.$parent.$watchCollection)) {
                    scope.$parent.$watchCollection(attrs.checklistModel, setChecked);
                } else {
                    scope.$parent.$watch(attrs.checklistModel, setChecked, true);
                }
            }

            return {
                restrict: 'A',
                priority: 1000,
                terminal: true,
                scope: true,
                compile: function(tElement, tAttrs) {
                    if (tElement[0].tagName !== 'INPUT' || tAttrs.type !== 'checkbox') {
                        throw 'checklist-model should be applied to `input[type="checkbox"]`.';
                    }

                    if (!tAttrs.checklistValue) {
                        throw 'You should provide `checklist-value`.';
                    }

                    // exclude recursion
                    tElement.removeAttr('checklist-model');

                    // local scope var storing individual checkbox model
                    tElement.attr('ng-model', 'checked');

                    return postLinkFn;
                }
            };
        }]);
