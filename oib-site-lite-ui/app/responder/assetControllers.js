'use strict';

var oibAssetControllerModule = angular.module('oibAssetControllerModule', ['ui.router', 'datatables', 'datatables.bootstrap', 'ui.bootstrap',]);

oibAssetControllerModule.controller('AssetsCtrl', ['$scope', '$stateParams', 'assetFactory', 'DTOptionsBuilder', function ($scope, $stateParams, assetFactory, DTOptionsBuilder) {

        $scope.currentPage = 1;
        $scope.pageSize = 10;
        $scope.assets = [];
        $scope.dtOptions = DTOptionsBuilder.newOptions().withBootstrap();
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

            if (asset.ASSET_ID) {
                assetFactory.updateAsset(asset);
            } else {
                assetFactory.insertAsset(asset)
            }
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

            editModal(selectedProperty, $stateParams.assetId)
                .then(function () {
                    return $state.reload();
                });
        }

    }]);

oibAssetControllerModule.controller('EditModalCtrl', ['$scope', 'selectedProperty', 'assetId', 'assetFactory', function ($scope, selectedProperty, assetId, assetFactory) {

    var selectedId;
    var newAsset = false;
    initialize();

    function initialize() {
        if (!(selectedProperty == null)) {
            $scope.selected = {
                "property": {
                    "propName": selectedProperty.PROP_NAME,
                    "codeSystem": {"name": selectedProperty.CODE_SYSTEM, "oid": selectedProperty.CODE_SYSTEM},
                    "codes": {"code": selectedProperty.CODE, "displayName": selectedProperty.DISPLAY_NAME}
                }
            };

            selectedId = selectedProperty.ASSET_PROPERTY_ID;
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

    var genderCodes= [{"displayName" : "Female", "code" : "F"},
                    {"displayName" : "Male", "code" : "M"},
                    {"displayName" : "Undifferentiated", "code" : "UN"}];

    var ageCodes= [{"displayName" : "infant, newborn; birth to 1 month", "code" : "D007231"},
        {"displayName" : "Infant; 1 to 23 months", "code" : "D007223"},
        {"displayName" : "child, preschool; 2 to 5 years", "code" : "D002675"},
        {"displayName" : "child; 6 to 12 years", "code" : "D002648"},
        {"displayName" : "adolescent; 13-18 years", "code" : "D000293"},
        {"displayName" : "young adult; 19-24 years", "code" : "D055815"},
        {"displayName" : "adult; 19-44 years", "code" : "D000293"},
        {"displayName" : "aged; 56-79 years", "code" : "D000368"},
        {"displayName" : "middle aged; 45-64 years", "code" : "D008875"},
        {"displayName" : "aged, 80 and older; a person 80 years of age and older", "code" : "D000369"}];

    var taskCodes = [{"displayName" : "order entry", "code" : "OE"},
                        {"displayName" : "laboratory test order entry", "code" : "LABOE"},
                        {"displayName" : "medication order entry", "code" : "MEDOE"},
                        {"displayName" : "patient documentation", "code" : "PATDOC"},
                        {"displayName" : "clinical note entry", "code" : "CLINNOTEE"},
                        {"displayName" : "diagnosis list entry", "code" : "DIAGLISTE"},
                        {"displayName" : "discharge summary entry", "code" : "DISCHSUME"},
                        {"displayName" : "Patient education entry", "code" : "PATEDUE"},
                        {"displayName" : "Discharge instruction entry", "code" : "DISCHINSTE"},
                        {"displayName" : "pathology report entry", "code" : "PATREPE"},
                        {"displayName" : "problem list entry", "code" : "PROBLISTE"},
                        {"displayName" : "reminder list entry", "code" : "REMLE"},
                        {"displayName" : "wellness reminder list entry", "code" : "WELLREMLE"},
                        {"displayName" : "patient information review", "code" : "PATINFO"},
                        {"displayName" : "allergy list entry", "code" : "ALLERLE"},
                        {"displayName" : "clinical note review", "code" : "CLINNOTEREV"},
                        {"displayName" : "discharge summary review", "code" : "DISCHSUMREV"},
                        {"displayName" : "diagnosis list review", "code" : "DIAGLISTREV"},
                        {"displayName" : "immunization list entry", "code" : "IMMLE"},
                        {"displayName" : "labratory results review", "code" : "LABRREV"},
                        {"displayName" : "microbiology results review", "code" : "MICRORREV"},
                        {"displayName" : "microbiology organisms results review", "code" : "MICROORGRREV"},
                        {"displayName" : "microbiology sensitivity test results review", "code" : "MICROSENSRREV"},
                        {"displayName" : "medication list review", "code" : "MLREV"},
                        {"displayName" : "medication administration record work list review", "code" : "MARWLREV"},
                        {"displayName" : "orders review", "code" : "OREV"},
                        {"displayName" : "pathology report review", "code" : "OREV"},
                        {"displayName" : "problem list review", "code" : "PROBLISTREV"},
                        {"displayName" : "radiology report review", "code" : "RADREPREV"},
                        {"displayName" : "immunization list review", "code" : "IMMLREV"},
                        {"displayName" : "reminder list review", "code": "REMLREV"},
                        {"displayName" : "wellness reminder list review", "code" : "WELLREMLREV"},
                        {"displayName" : "risk assessment instrument", "code" : "RISKASSESS"},
                        {"displayName" : "falls risk assessment instrument", "code" : "FALLRISK"}];

    var encounterCodes = [{"displayName" : "Ambulatory", "code" : "AMB"},
                        {"displayName" : "Emergency", "code" : "EMER"},
                        {"displayName" : "Field", "code" : "FLD"},
                        {"displayName" : "Home health", "code" : "HH"},
                        {"displayName" : "Inpatient encounter", "code" : "IMP"},
                        {"displayName" : "Inpatient acute", "code" : "ACUTE"},
                        {"displayName" : "Inpatient non-acute", "code" : "NONAC"},
                        {"displayName" : "short stay", "code" : "SS"},
                        {"displayName" : "virtual", "code" : "VR"}];

    var observationCodes = [{"displayName" : "Abnormal", "code" : "A"},
                        {"displayName" : "Abnormal alert", "code" : "AA"},
                        {"displayName" : "High", "code" : "H"},
                        {"displayName" : "High alert", "code" : "HH"},
                        {"displayName" : "Low", "code" : "L"},
                        {"displayName" : "Low alert", "code" : "LL"},
                        {"displayName" : "Normal", "code" : "N"}];

    var subtopicCodes = [{"displayName" : "administration & dosage", "code" : "Q000008"},
                        {"displayName" : "contraindications", "code" : "Q000744"},
                        {"displayName" : "adverse effects", "code" : "Q000009"},
                        {"displayName" : "drug interaction", "code" : "D004347"},
                        {"displayName" : "classification", "code" : "Q000145"},
                        {"displayName" : "etiology", "code" : "Q000209"},
                        {"displayName" : "diagnosis", "code" : "Q000175"},
                        {"displayName" : "therapy", "code" : "Q000628"},
                        {"displayName" : "prognosis", "code" : "D011379"},
                        {"displayName" : "therapeutic use", "code" : "Q000627"},
                        {"displayName" : "pharmacokinetics", "code" : "Q000493"},
                        {"displayName" : "pharmacology", "code" : "Q000494"},
                        {"displayName" : "toxicity", "code" : "Q000633"},
                        {"displayName" : "poisoning", "code" : "Q000506"},
                        {"displayName" : "Drug interaction", "code" : "79899007"},
                        {"displayName" : "Differential diagnosis", "code" : "47965005"},
                        {"displayName" : "Drug interaction with drug", "code" : "404204005"},
                        {"displayName" : "Drug interaction with food", "code" : "95907004"},
                        {"displayName" : "Drug interaction with alcohol", "code" : "95906008"}];

    $scope.properties = [{"name": "Task Context", "propName" : "taskContext.c", "codeSystem" : codeSystems[0], "codes": taskCodes},
                        {"name": "Gender", "propName" : "administrativeGenderCode.c", "codeSystem" : codeSystems[6], "codes": genderCodes},
                        {"name": "Age Groups", "propName" : "ageGroup.v", "codeSystem" : codeSystems[7], "codes": ageCodes},
                        {"name": "Encounter", "propName" : "encounter.c", "codeSystem" : codeSystems[0], "codes": encounterCodes},
                        {"name": "Performer Language", "propName" : "performer.languageCode.c", "codeSystem" : codeSystems[10], "codes": {"displayName" : "", "code" : ""}},
                        {"name": "Information Recipient Language", "propName" : "informationRecipient.languageCode.c", "codeSystem" : codeSystems[10], "codes": {"displayName" : "", "code" : ""}},
                        {"name": "Performer", "propName" : "performer", "codeSystem" : codeSystems[9], "codes": {"displayName" : "", "code" : ""}},
                        {"name": "Information Recipient", "propName" : "informationRecipient", "codeSystem" : codeSystems[9], "codes": {"displayName" : "", "code" : ""}},
                        {"name": "Severity Observation", "propName" : "severityObservation.interpretationCode.c", "codeSystem" : codeSystems[12], "codes": observationCodes},
                        {"name": "Sub Topic", "propName" : "subTopic.v", "codeSystem" : codeSystems[7], "codes": subtopicCodes},
                        {"name": "Country", "propName" : "locationOfInterest.c", "codeSystem" : codeSystems[13], "codes": {"displayName" : "", "code" : ""}},
                        {"name": "Main Search Criteria", "propName" : "mainSearchCriteria.v", "codeSystem" : codeSystems, "codes" : {"displayName" : "", "code" : ""}}];


    $scope.editProperty = function (assetProperty) {

        assetProperty.assetId = selectedId;
        if (newAsset) {
            assetFactory.createAssetProperty(assetProperty)
                .success(function (assetProperty) {

                    $scope.$close(assetProperty)
                });
        } else {
            assetFactory.updateAssetProperty(assetProperty)
                .success(function (assetProperty) {

                    $scope.$close(assetProperty)
                });
        }
    };

    $scope.addAssetProperty = function (assetProperty) {
        assetFactory.createAssetProperty(assetProperty);
    }

}]);