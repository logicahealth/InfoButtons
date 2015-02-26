'use strict';

var oibConfigurationApp = angular.module('oibConfigurationApp', [
  'ui.router',
  'ngResource',
  'ab-base64',
  'setupControllers',
  'oibSetupServices',
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

oibConfigurationApp.config(function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.otherwise('/home');

  $stateProvider

      .state('home', {
        url: '/home',
        templateUrl: 'home/home.html'
      })
      .state('editProfile', {
        url: '/editProfile/:id',
        templateUrl: 'manager/profileForm.html',
        controller: 'ProfileFormCtrl',
          data: {
              requireGit: false
          }
      })
      .state('manager', {
        url: '/manager',
        templateUrl: 'manager/profiles.html',
        controller: 'ProfileCtrl',
          data: {
              requireGit: false
          }
      })
      .state('cloudManager', {
        url: '/cloudManager',
        templateUrl: 'manager/cloudManager.html',
        controller: 'CloudProfileCtrl',
        data: {
            requireGit: true
        }
      })
      .state('responder', {
        url: '/responder',
        templateUrl: 'responder/assets.html',
        controller: 'AssetsCtrl',
          data: {
              requireGit: false
          }
      })
      .state('editAsset', {
        url: '/responder/editAsset/:assetId',
        templateUrl: 'responder/assetForm.html',
        controller: 'AssetsCtrl',
          data: {
              requireGit: false
          }
      })
      .state('systemConfiguration', {
        url: '/systemConfiguration',
        templateUrl: 'setup/systemConfiguration.html',
        controller: 'setupController',
        data: {
           requireGit: true
        }
      })
});

oibConfigurationApp.run(function ($rootScope, $state, loginModal, $location) {

    if (!localStorage.getItem('init'))
    {
        localStorage.setItem("hostName", $location.host());
        localStorage.setItem("gitRepo", 'VHAINNOVATIONS/InfoButtons');
        localStorage.setItem("profileStorePath", 'profilestore');
        localStorage.setItem("gitUser", 'undefined');
        localStorage.setItem('init','yes');
    }

    $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
        var requireLogin = toState.data.requireGit;

        if (requireLogin && localStorage.getItem('gitUser') == 'undefined') {
            event.preventDefault();

            loginModal()
                .then(function () {
                    return $state.go(toState.name, toParams);
                })
                .catch(function () {
                    return $state.go('home');
                });
        }
    });
});
