    'use strict';

var oibManagerModule = angular.module('oibManagerModule', ['ui.router','ngResource', 'ab-base64', 'ui.bootstrap', 'directives']);

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
            profileFactory.insertProfile(profile)
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

        var selectedId;
        var newAsset = false;
        $scope.selected_items= [];

        $scope.clearSelectedCodes = function() {

            $scope.selected_items = [];
        };
    var selectedProperty = null;
    var assetId = null;

    initialize();

    function initialize() {
        if (!(selectedProperty == null)) {
            $scope.selected = {
                "property": {
                    "propName": selectedProperty.propertyName,
                    "codeSystem": {"name": selectedProperty.codeSystem, "oid": selectedProperty.codeSystem},
                    "codes": [{"code": selectedProperty.code, "displayName": selectedProperty.displayName}]
                }
            };
            $scope.selected_items= [{"code": selectedProperty.code, "displayName": selectedProperty.displayName}];
            selectedId = selectedProperty.assetPropertyId;
        } else {
            $scope.selected = {
                "property": {
                    "propName": null,
                    "codeSystem": {"name": null, "oid": null},
                    "codes": null
                }
            };

            selectedId = assetId;
            newAsset = true;

        }
    }

    var codeSystems = [{"name": "HL7 ActCode", "oid" : "2.16.840.1.113883.5.4"},
        {"name": "ICD9-CM", "oid" : "2.16.840.1.113883.6.103"},
        {"name": "ICD10-CM", "oid" : "2.16.840.1.113883.6.90"},
        {"name": "ICD10", "oid" : "2.16.840.1.113883.6.3"},
        {"name": "SNOMED-CT", "oid" : "2.16.840.1.113883.6.96"},
        {"name": "RxNorm", "oid" : "2.16.840.1.113883.6.88"},
        {"name": "HL7 AdminstrativeGender", "oid": "2.16.840.1.113883.5.1"},
        {"name" : "MeSH" , "oid" : "2.16.840.1.113883.6.177"},
        {"name" : "NDC", "oid" : "2.16.840.1.113883.6.69"},
        {"name" : "NUCC Health Care provider taxonomy", "oid" : "2.16.840.1.113883.6.101"},
        {"name" : "ietf3066", "oid" : "2.16.840.1.113883.6.121"},
        {"name" : "LOINC", "oid" : "2.16.840.1.113883.6.1"},
        {"name" : "ObservationInterpretation", "oid" : "2.16.840.1.113883.5.83"},
        {"name" : "ISO 3166 Part 1 Country Codes, 2nd Edition, Alpha-3 ", "oid" : "1.0.3166.1.2.3"}];

    var mainSearchCodes = [{"name": "ICD9-CM", "oid" : "2.16.840.1.113883.6.103"},
        {"name": "ICD10-CM", "oid" : "2.16.840.1.113883.6.90"},
        {"name": "ICD10", "oid" : "2.16.840.1.113883.6.3"},
        {"name": "SNOMED-CT", "oid" : "2.16.840.1.113883.6.96"},
        {"name": "RxNorm", "oid" : "2.16.840.1.113883.6.88"},
        {"name" : "MeSH" , "oid" : "2.16.840.1.113883.6.177"},
        {"name" : "LOINC", "oid" : "2.16.840.1.113883.6.1"},
        {"name" : "CPT", "oid": "2.16.840.1.113883.6.12"},
        {"name" : "CDS Rules", "oid": "http://socraticgrid.org/cds/ka/ecarule"}]

    var genderCodes= [{"displayName" : "Female", "code" : "F", "id": "1a"},
        {"displayName" : "Male", "code" : "M", "id": "2a"},
        {"displayName" : "Undifferentiated", "code" : "UN", "id": "3a"}];

    var ageCodes= [{"displayName" : "infant, newborn; birth to 1 month", "code" : "D007231", "id": '1b'},
        {"displayName" : "Infant; 1 to 23 months", "code" : "D007223", "id": "2b"},
        {"displayName" : "child, preschool; 2 to 5 years", "code" : "D002675", "id": "3b"},
        {"displayName" : "child; 6 to 12 years", "code" : "D002648", "id": "4b"},
        {"displayName" : "adolescent; 13-18 years", "code" : "D000293", "id": "5b"},
        {"displayName" : "young adult; 19-24 years", "code" : "D055815", "id": "6b"},
        {"displayName" : "adult; 19-44 years", "code" : "D000293", "id": "7b"},
        {"displayName" : "aged; 56-79 years", "code" : "D000368", "id": "8b"},
        {"displayName" : "middle aged; 45-64 years", "code" : "D008875", "id": "9b"},
        {"displayName" : "aged, 80 and older; a person 80 years of age and older", "code" : "D000369", "id": "10b"}];

    var taskCodes = [{"displayName" : "order entry", "code" : "OE", "id": "1c"},
        {"displayName" : "laboratory test order entry", "code" : "LABOE", "id": "2c"},
        {"displayName" : "medication order entry", "code" : "MEDOE", "id": "3c"},
        {"displayName" : "patient documentation", "code" : "PATDOC", "id": "4c"},
        {"displayName" : "clinical note entry", "code" : "CLINNOTEE", "id": "5c"},
        {"displayName" : "diagnosis list entry", "code" : "DIAGLISTE", "id": "6c"},
        {"displayName" : "discharge summary entry", "code" : "DISCHSUME", "id": "7c"},
        {"displayName" : "Patient education entry", "code" : "PATEDUE", "id": "8c"},
        {"displayName" : "Discharge instruction entry", "code" : "DISCHINSTE", "id": "9c"},
        {"displayName" : "pathology report entry", "code" : "PATREPE", "id": "10c"},
        {"displayName" : "problem list entry", "code" : "PROBLISTE", "id": "11c"},
        {"displayName" : "reminder list entry", "code" : "REMLE", "id": "12c"},
        {"displayName" : "wellness reminder list entry", "code" : "WELLREMLE", "id": "13c"},
        {"displayName" : "patient information review", "code" : "PATINFO", "id": "14c"},
        {"displayName" : "allergy list entry", "code" : "ALLERLE", "id": "15c"},
        {"displayName" : "clinical note review", "code" : "CLINNOTEREV", "id": "16c"},
        {"displayName" : "discharge summary review", "code" : "DISCHSUMREV", "id": "17c"},
        {"displayName" : "diagnosis list review", "code" : "DIAGLISTREV", "id": "18c"},
        {"displayName" : "immunization list entry", "code" : "IMMLE", "id": "19c"},
        {"displayName" : "labratory results review", "code" : "LABRREV", "id": "20c"},
        {"displayName" : "microbiology results review", "code" : "MICRORREV", "id": "21c"},
        {"displayName" : "microbiology organisms results review", "code" : "MICROORGRREV", "id": "22c"},
        {"displayName" : "microbiology sensitivity test results review", "code" : "MICROSENSRREV", "id": "23c"},
        {"displayName" : "medication list review", "code" : "MLREV", "id": "24c"},
        {"displayName" : "medication administration record work list review", "code" : "MARWLREV", "id": "25c"},
        {"displayName" : "orders review", "code" : "OREV", "id": "26c"},
        {"displayName" : "pathology report review", "code" : "OREV", "id": "27c"},
        {"displayName" : "problem list review", "code" : "PROBLISTREV", "id": "28c"},
        {"displayName" : "radiology report review", "code" : "RADREPREV", "id": "29c"},
        {"displayName" : "immunization list review", "code" : "IMMLREV", "id": "30c"},
        {"displayName" : "reminder list review", "code": "REMLREV", "id": "31c"},
        {"displayName" : "wellness reminder list review", "code" : "WELLREMLREV", "id": "32c"},
        {"displayName" : "risk assessment instrument", "code" : "RISKASSESS", "id": "33c"},
        {"displayName" : "falls risk assessment instrument", "code" : "FALLRISK", "id": "34c"},
        {"displayName" : "CDS Review" , "code" : "CDSREV", "id" : "35c"}];

    var encounterCodes = [{"displayName" : "Ambulatory", "code" : "AMB", "id": "1d"},
        {"displayName" : "Emergency", "code" : "EMER", "id": "2d"},
        {"displayName" : "Field", "code" : "FLD", "id": "3d"},
        {"displayName" : "Home health", "code" : "HH", "id": "4d"},
        {"displayName" : "Inpatient encounter", "code" : "IMP", "id": "5d"},
        {"displayName" : "Inpatient acute", "code" : "ACUTE", "id": "6d"},
        {"displayName" : "Inpatient non-acute", "code" : "NONAC", "id": "7d"},
        {"displayName" : "short stay", "code" : "SS", "id": "8d"},
        {"displayName" : "virtual", "code" : "VR", "id": "9d"}];

    var observationCodes = [{"displayName" : "Abnormal", "code" : "A", "id": "1e"},
        {"displayName" : "Abnormal alert", "code" : "AA", "id": "2e"},
        {"displayName" : "High", "code" : "H", "id": "3e"},
        {"displayName" : "High alert", "code" : "HH", "id": "4e"},
        {"displayName" : "Low", "code" : "L", "id": "5e"},
        {"displayName" : "Low alert", "code" : "LL", "id": "6e"},
        {"displayName" : "Normal", "code" : "N", "id": "7e"}];

    var subtopicCodes = [{"displayName" : "administration & dosage", "code" : "Q000008", "id": "1f"},
        {"displayName" : "contraindications", "code" : "Q000744", "id": "2f"},
        {"displayName" : "adverse effects", "code" : "Q000009", "id": "3f"},
        {"displayName" : "drug interaction", "code" : "D004347", "id": "4f"},
        {"displayName" : "classification", "code" : "Q000145", "id": "5f"},
        {"displayName" : "etiology", "code" : "Q000209", "id": "6f"},
        {"displayName" : "diagnosis", "code" : "Q000175", "id": "7f"},
        {"displayName" : "therapy", "code" : "Q000628", "id": "8f"},
        {"displayName" : "prognosis", "code" : "D011379", "id": "9f"},
        {"displayName" : "therapeutic use", "code" : "Q000627", "id": "10f"},
        {"displayName" : "pharmacokinetics", "code" : "Q000493", "id": "11f"},
        {"displayName" : "pharmacology", "code" : "Q000494", "id": "12f"},
        {"displayName" : "toxicity", "code" : "Q000633", "id": "13f"},
        {"displayName" : "poisoning", "code" : "Q000506", "id": "14f"},
        {"displayName" : "Drug interaction", "code" : "79899007", "id": "15f"},
        {"displayName" : "Differential diagnosis", "code" : "47965005", "id": "16f"},
        {"displayName" : "Drug interaction with drug", "code" : "404204005", "id": "17f"},
        {"displayName" : "Drug interaction with food", "code" : "95907004", "id": "18f"},
        {"displayName" : "Drug interaction with alcohol", "code" : "95906008", "id": "19f"}];

    var performerAndInfoRecipCodes = [{"displayName" : "Healthcare Provider", "code" : "PROV", "id": "1g"},
        {"displayName" : "Patient", "code" : "PAT", "id": "2g"}];

    $scope.properties = [{"name": "Task Context", "propName" : "taskContext.c", "codeSystem" : codeSystems[0], "codes": taskCodes},
        {"name": "Gender", "propName" : "administrativeGenderCode.c", "codeSystem" : codeSystems[6], "codes": genderCodes},
        {"name": "Age Groups", "propName" : "ageGroup.v", "codeSystem" : codeSystems[7], "codes": ageCodes},
        {"name": "Encounter", "propName" : "encounter.c", "codeSystem" : codeSystems[0], "codes": encounterCodes},
        {"name": "Performer Language", "propName" : "performer.languageCode.c", "codeSystem" : codeSystems[10], "codes": {"displayName" : "", "code" : ""}},
        {"name": "Information Recipient Language", "propName" : "informationRecipient.languageCode.c", "codeSystem" : codeSystems[10], "codes": {"displayName" : "", "code" : ""}},
        {"name": "Performer", "propName" : "performer", "codeSystem" : codeSystems[9], "codes": performerAndInfoRecipCodes},
        {"name": "Information Recipient", "propName" : "informationRecipient", "codeSystem" : codeSystems[9], "codes": performerAndInfoRecipCodes},
        {"name": "Severity Observation", "propName" : "severityObservation.interpretationCode.c", "codeSystem" : codeSystems[12], "codes": observationCodes},
        {"name": "Sub Topic", "propName" : "subTopic.v", "codeSystem" : [codeSystems[7]], "codes": subtopicCodes},
        {"name": "Main Search Criteria", "propName" : "mainSearchCriteria.v", "codeSystem" : mainSearchCodes, "codes" : {"displayName" : "", "code" : ""}}];


        loadProfile();

        function loadProfile () {
            if ($stateParams.id) {
                profileFactory.getProfile($stateParams.id)
                    .success(function (profile) {
                        profile.status = profile.status.toString();
                        $scope.profile = profile;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load local profile ' + $stateParams.id + ': ' + error;
                    });
            }
            else {

                $scope.new = true;
                $scope.profile = {id: null, name: null, version: "1", published: null, status: 3, content: null, imageUrl: null}
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

            profile.published = new Date();
            profileFactory.insertProfile(profile)
                .success(function (msg) {
                    $scope.statusMessage = 'Profile Successfully Updated';
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to save profile:' + error;
                });
        };

        $scope.insert = function (profile) {
            profileFactory.insertProfile(profile)
                .success(function (msg) {
                    $scope.statusMessage = 'Profile Successfully Created';
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
