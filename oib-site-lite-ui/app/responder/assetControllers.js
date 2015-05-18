'use strict';

var oibAssetControllerModule = angular.module('oibAssetControllerModule', ['ui.router', 'datatables', 'datatables.bootstrap']);

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

            assetFactory.updateAsset(asset);
        };

    }]);

oibAssetControllerModule.controller('AssetFormCtrl', ['$scope', '$stateParams', 'assetFactory', 'DTOptionsBuilder', function ($scope, $stateParams, assetFactory, DTOptionsBuilder) {

        $scope.asset = {};
        $scope.assetProperties = [];
        $scope.currentPage = 1;
        $scope.pageSize = 10;
        $scope.dtOptions = DTOptionsBuilder.newOptions().withBootstrap();

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