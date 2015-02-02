'use strict';

var oibAssetControllerModule = angular.module('oibAssetControllerModule', ['ui.router']);

oibAssetControllerModule.controller('AssetsCtrl', ['$scope', '$stateParams', 'assetFactory', function ($scope, $stateParams, assetFactory) {

        $scope.currentPage = 1;
        $scope.pageSize = 10;
        $scope.assets = [];

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

    }]);

oibAssetControllerModule.controller('AssetFormCtrl', ['$scope', '$stateParams', 'assetFactory', function ($scope, $stateParams, assetFactory) {

        $scope.asset = {};
        $scope.assetProperties = [];
        $scope.statusMessage = 'Messages/alerts go here ... and disappear ideally';

        loadAsset($stateParams.assetId);

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

    }]);