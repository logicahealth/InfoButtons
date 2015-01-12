'use strict';

var oibConfigurationApp = angular.module('oibConfigurationApp', [
  'ngRoute',
  'ngResource',
  'ab-base64',
  'oibManagerModule',
  'oibManagerServiceModule',
  'oibAssetServiceModule',
  'oibAssetControllerModule',
  'oibHomeModule',
  'oibVersionModule',
  'ui.bootstrap',
  'oibModalModule',
  'oibConfirmModule',
  'uuidGenerator'
]);

oibConfigurationApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/home'});
}]);
