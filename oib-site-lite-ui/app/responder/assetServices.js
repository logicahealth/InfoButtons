'use strict';

var oibAssetServiceModule = angular.module('oibAssetServiceModule', ['ui.bootstrap']);

oibAssetServiceModule.factory('assetFactory', ['$http', function($http) {

    var urlBase = 'http://' + localStorage.getItem('hostName') + ':3000/';
//    var urlBase = 'http://service.oib.utah.edu:8080/infobutton-service-dev/manager/';
    var assetFactory = {};

    assetFactory.getAssets = function () {
        $http.defaults.headers.common.Authorization = undefined;
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

    assetFactory.updateAssetProperty = function (assetProperty) {
        return $http.put(urlBase + 'assetProperty/update', assetProperty);
    };

    assetFactory.createAssetProperty = function (assetProperty) {
        return $http.put(urlBase + 'assetProperty/create', assetProperty);
    };

    return assetFactory;
}]);

oibAssetServiceModule.service('editModal', function ($modal) {

    return function(selectedProperty, assetId) {
        var instance = $modal.open({
            templateUrl: 'responder/editProperty.html',
            controller: 'EditModalCtrl',
            controllerAs: 'EditModalCtrl',
            resolve: {
                selectedProperty : function () {

                    return selectedProperty;
                },
                assetId : function () {

                    return assetId;
                }
            }
        });

        return instance.result;
    };

});




