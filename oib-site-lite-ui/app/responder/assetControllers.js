'use strict';

var oibAssetControllerModule = angular.module('oibAssetControllerModule', ['ngRoute']);

oibAssetControllerModule.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
                .when('/responder/assets', {
                    templateUrl: 'responder/assets.html',
                    controller: 'AssetsCtrl'
                })
                .when('/responder/editAsset/:assetId', {
                    templateUrl: 'responder/assetForm.html',
                    controller: 'AssetsCtrl'
                });
    }])

oibAssetControllerModule.controller('AssetsCtrl', ['$scope', '$routeParams', 'assetFactory', function ($scope, $routeParams, assetFactory) {

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

oibAssetControllerModule.controller('AssetFormCtrl', ['$scope', '$routeParams', 'assetFactory', function ($scope, $routeParams, assetFactory) {

        $scope.asset = {};
        $scope.assetProperties = [];
        $scope.statusMessage = 'Messages/alerts go here ... and disappear ideally';

        loadAsset($routeParams.assetId);

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