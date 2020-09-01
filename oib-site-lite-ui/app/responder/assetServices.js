'use strict';

var oibAssetServiceModule = angular.module('oibAssetServiceModule', ['ui.bootstrap']);

oibAssetServiceModule.factory('assetFactory', ['$http', function($http) {

    var oibManagerUrl = 'https://' + localStorage.getItem('hostName') + '/infobutton-service/liteManager/'

    var responderManagerBase = 'https://' + localStorage.getItem('hostName') + '/openInfobutton/assetManager/';

    var responderExpander = 'https://' + localStorage.getItem('hostName') + '/openInfobutton/';
//    var urlBase = 'http://service.oib.utah.edu:8080/infobutton-service-dev/manager/';
    var assetFactory = {};

    assetFactory.getAssets = function () {

        return $http.get(responderManagerBase + 'assets', {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.getAsset = function (id) {
        return $http.get(responderManagerBase + 'asset/' + id, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.updateAsset = function (asset) {
        return $http.post(responderManagerBase + 'asset/update', asset, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.copyAsset = function (asset) {
        return $http.get(responderManagerBase + 'copyAsset/' + asset, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.deleteAsset = function (asset) {
        return $http.get(responderManagerBase + 'deleteAsset/' + asset, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.deleteAssetProperty = function (assetProperty) {
        return $http.get(responderManagerBase + 'deleteAssetProperty/' + assetProperty, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.getAssetPropertiesForAsset = function (assetId) {
        return $http.get(responderManagerBase + 'assetProperties/' + assetId, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.updateAssetProperty = function (assetProperty) {
        return $http.post(responderManagerBase + 'assetProperty/update', assetProperty, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    assetFactory.expandAssetIndex = function (assetId, codeSystem) {
        return $http.get(responderExpander + 'assetExpander/' + assetId + '/codeSystem/' + codeSystem +'/', {
            headers: {
                'Authorization' : undefined
            }
        });
    }

    assetFactory.searchUts = function (codeSystem, search) {

        return $http.get (oibManagerUrl+ 'searchUts/' + codeSystem + '/' + search, {
            headers: {
                'Authorization' : undefined
            }
        })
    }

    return assetFactory;
}]);

oibAssetServiceModule.service('editModal', function ($uibModal) {

    return function(selectedProperty, assetId) {
        var instance = $uibModal.open({
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




