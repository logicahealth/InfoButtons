'use strict';

var oibAssetServiceModule = angular.module('oibAssetServiceModule', []);

oibAssetServiceModule.factory('assetFactory', ['$http', function($http) {

    var urlBase = 'http://localhost:3000/';
//    var urlBase = 'http://service.oib.utah.edu:8080/infobutton-service-dev/manager/';
    var assetFactory = {};

    assetFactory.getAssets = function () {
        return $http.get(urlBase + 'assets');
    };

    assetFactory.getAsset = function (id) {
        return $http.get(urlBase + 'asset/' + id);
    };

    assetFactory.insertAsset = function (asset) {
        return $http.put(urlBase + 'asset/create', asset);
    };

    assetFactory.updateAsset = function (asset) {
        return $http.put(urlBase + 'asset/update', asset);
    };

    assetFactory.deleteAsset = function (id) {
        return $http.delete(urlBase + 'asset/delete/' + id);
    };

    assetFactory.getAssetPropertiesForAsset = function (assetId) {
        return $http.get(urlBase + 'assetProperties/' + assetId);
    };

    assetFactory.getAssetProperty = function (id) {
        return $http.get(urlBase + 'assetProperty/' + id);
    };

    return assetFactory;
}]);


