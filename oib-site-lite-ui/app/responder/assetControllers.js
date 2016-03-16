'use strict';

var oibAssetControllerModule = angular.module('oibAssetControllerModule', ['ui.router', 'datatables', 'datatables.bootstrap', 'ui.bootstrap', 'ngNotify', 'directives']);

oibAssetControllerModule.controller('AssetsCtrl', ['$scope', '$state', 'ngNotify', '$stateParams', 'assetFactory', 'DTOptionsBuilder', function ($scope, $state, ngNotify, $stateParams, assetFactory, DTOptionsBuilder) {

        $scope.currentPage = 1;
        $scope.pageSize = 10;
        $scope.assets = [];
        $scope.dtOptions = DTOptionsBuilder.newOptions().withOption('order', [2, 'desc']).withBootstrap();
        loadAssets();

        function loadAssets() {

            assetFactory.getAssets()
                    .success(function (assets) {
                        $scope.assets = assets;
                    })
                    .error(function (error) {
                        $scope.statusMessage = 'Unable to load local assets: ' + error;
                    });

        }

        $scope.update = function(asset) {

            if (asset.assetId) {
                asset.lastUpdateDate = new Date();
                assetFactory.updateAsset(asset);
                ngNotify.set("Asset Updated");
            } else {
                asset.lastUpdateDate = new Date();
                assetFactory.updateAsset(asset).success(function() {
                    ngNotify.set("Asset Created");
                    $state.go('responder');
                });
            }
        };

        $scope.deleteAsset = function(asset) {

            assetFactory.deleteAsset(asset.assetId).success(function() {
                ngNotify.set("Asset Deleted");
                $state.go('responder');
            });
        };

        $scope.deleteAssetProperty = function(assetProperty) {

            assetFactory.deleteAssetProperty(assetProperty.assetPropertyId).success(function() {
                ngNotify.set("Asset Property Deleted");
                if (assetProperty.propertyName == 'mainSearchCriteria.v')
                {
                    assetFactory.expandAssetIndex(assetProperty.asset.assetId, assetProperty.codeSystem);
                    ngNotify.set("Asset property deleted, clearing expanded concepts, please refresh...");
                }
                $state.reload();
            });
        };


        $scope.copyAsset = function(asset) {

            assetFactory.copyAsset(asset.assetId).success(function() {
                $state.go('responder');
            });
        };
    }]);

oibAssetControllerModule.controller('AssetFormCtrl', ['$scope', '$state', '$stateParams', 'assetFactory', 'DTOptionsBuilder', 'editModal', function ($scope, $state, $stateParams, assetFactory, DTOptionsBuilder, editModal) {

        $scope.asset = {};
        $scope.assetProperties = [];
        $scope.currentPage = 1;
        $scope.pageSize = 10;
        $scope.dtOptions = DTOptionsBuilder.newOptions().withBootstrap();

        if ($stateParams.assetId != "") {

            loadAsset($stateParams.assetId);
        }

        function loadAsset(id) {

            assetFactory.getAsset(id)
                    .success(function (_asset) {
                        $scope.asset = _asset;
                    })
                    .error(function (error) {
                        $scope.statusMessage = 'Unable to load local asset(' + id + '): ' + error;
                    });

            assetFactory.getAssetPropertiesForAsset(id)
                    .success(function (_assetProperties) {
                        $scope.assetProperties = _assetProperties;
                    })
                    .error(function (error) {
                        $scope.statusMessage = 'Unable to load assetProperties(' + id + '): ' + error;
                    });
        }

        $scope.editProperty = function(selectedProperty) {

            editModal(selectedProperty, $stateParams.assetId, $state)
                .then(function () {
                    return $state.reload();
                });
        }

        $scope.copy = function(_asset, assetProps) {
            $scope.copyAsset(_asset, assetProps);
        }
    }]);

oibAssetControllerModule.controller('EditModalCtrl', ['$scope', '$state', 'selectedProperty', 'assetId', 'assetFactory', 'ngNotify', '$filter', function ($scope, $state, selectedProperty, assetId, assetFactory, ngNotify, $filter) {

    var selectedId;
    var newAsset = false;

    $scope.selected_items= [];

    $scope.clearSelectedCodes = function() {

        $scope.selected_items = [];
    }

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

    var mainSearchCodes = [{"name": "ICD9CM", "oid" : "2.16.840.1.113883.6.103"},
                        {"name": "ICD10CM", "oid" : "2.16.840.1.113883.6.90"},
                        {"name": "ICD10", "oid" : "2.16.840.1.113883.6.3"},
                        {"name": "SNOMEDCT_US", "oid" : "2.16.840.1.113883.6.96"},
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


    $scope.editProperty = function (assetProperty, selectedItems) {

        assetProperty.assetId = selectedId;
        var entities = [];

        if( selectedItems.length != 0) {
            for (var i = 0; i < selectedItems.length; i++)
            {
                var entity = {};
                entity.propertyName = assetProperty.propName;
                entity.code = selectedItems[i].code;
                entity.displayName = selectedItems[i].displayName;
                entity.codeSystem = assetProperty.codeSystem.oid;
                entity.propertyType = "CODE";
                entity.generatedByCode = "AUTHOR";
                entity.asset = {"assetId" : assetId}
                entities.push(entity);
            }
        }
        else {
            var entity = {};
            entity.propertyName = assetProperty.propName;
            entity.code = assetProperty.codes.code;
            entity.displayName = assetProperty.codes.displayName;
            entity.codeSystem = assetProperty.codeSystem.oid;
            entity.propertyType = "CODE";
            entity.generatedByCode = "AUTHOR";
            entity.asset = {"assetId" : assetId}
            entities.push(entity);
        }

        if (newAsset) {
            assetFactory.updateAssetProperty(entities)
                .success(function () {

                    if (assetProperty.propName == 'mainSearchCriteria.v')
                    {
                        assetFactory.expandAssetIndex(assetId, assetProperty.codeSystem.oid);
                        ngNotify.set("Updating asset index, refresh to see expanded concepts....");
                    }
                    $scope.$close(assetProperty)
                });
        } else {
            entities[0].assetPropertyId = assetProperty.assetId;
            assetFactory.updateAssetProperty(entities)
                .success(function () {

                    if (assetProperty.propName == 'mainSearchCriteria.v' )
                    {
                        assetFactory.expandAssetIndex(assetId, assetProperty.codeSystem.oid);
                        ngNotify.set("Updating asset index, refresh to see expanded concepts....");
                    }
                    else if (selectedProperty.propertyName == 'mainSearchCriteria.v')
                    {
                        assetFactory.expandAssetIndex(assetId, selectedProperty.codeSystem);
                        ngNotify.set("Updating asset index, refresh to see expanded concepts....");
                    }

                    $scope.$close(assetProperty);
                });
        }
    };

    var terms = [];
    var searchTerm = '';

    $scope.getTerms = function (search, codeSystem) {

        var truncatedSearch = $filter('limitTo')(search, 4);
        var searchedTermArray = $filter('filter')(terms, search);
        if (searchTerm != truncatedSearch || searchedTermArray.length == 0) {
            searchTerm = truncatedSearch;
            return assetFactory.searchUts(codeSystem, search)
                .then(function (result) {

                    terms = result.data.result.results;
                    return terms;
                });
        } else {
            return searchedTermArray;
        }
    }

}]);