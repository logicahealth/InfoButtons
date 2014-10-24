'use strict';

var oibConfigurationApp = angular.module('oibConfigurationApp', [
  'ngRoute',
  'ngResource',
  'oibManagerModule',
  'oibManagerServiceModule',
  'oibAssetServiceModule',
  'oibAssetControllerModule',
  'oibHomeModule',
  'oibVersionModule',
  'uuidGenerator'
]);

oibConfigurationApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/home'});
}]);
