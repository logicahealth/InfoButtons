'use strict';

var oibHomeModule = angular.module('oibHomeModule', [])

oibHomeModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

oibHomeModule.controller('HomeCtrl', [function() {

}]);

