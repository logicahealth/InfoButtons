'use strict';

var env = {};

// Import variables if present (from env.js)
if(window){
  Object.assign(env, window.__env);
}

var oibConfigurationApp = angular.module('oibConfigurationApp', [
  'ui.router',
  'ngResource',
  'ngCookies',
  'ab-base64',
  'datatables',
  'datatables.bootstrap',
  'ngSanitize',
  'ui.bootstrap',
  'ui.select',
  'ngNotify',
  'schemaForm',
  'oibHomeModule',
  'oibToolModule',
  'liteAuthenticationServiceModule',
  'liteAuthenticationModule',
  'setupControllers',
  'oibSetupServices',
  'oibManagerModule',
  'oibManagerServiceModule',
  'oibAssetServiceModule',
  'oibAssetControllerModule',
  'oibVersionModule',
  'oibModalModule',
  'oibConfirmModule',
  'uuidGenerator'
]);

oibConfigurationApp.constant('_env', env);

oibConfigurationApp.config(function($stateProvider, $urlRouterProvider, uiSelectConfig) {

  uiSelectConfig.theme = 'bootstrap';

  $urlRouterProvider.otherwise('/login');

  $stateProvider

      .state('login', {
          url: '/login',
          controller: 'LoginController',
          templateUrl: 'authentication/login.html',
          data: {
              requireAdmin: false
          }
      })

      .state('home', {
        url: '/home',
        controller: 'HomeCtrl',
        templateUrl: 'home/home.html',
          data: {
              requireAdmin: false
          }
      })
      .state('editProfile', {
        url: '/editProfile/:id',
        templateUrl: 'manager/profileForm.html',
        controller: 'ProfileFormCtrl',
          data: {
              requireAdmin: false
          }
      })
      .state('manager', {
        url: '/manager',
        templateUrl: 'manager/profiles.html',
        controller: 'ProfileCtrl',
          data: {
              requireAdmin: false
          }
      })
      .state('cloudManager', {
        url: '/cloudManager',
        templateUrl: 'manager/cloudManager.html',
        controller: 'CloudProfileCtrl',
        data: {
            requireAdmin: false
        }
      })
      .state('responder', {
        url: '/responder',
        templateUrl: 'responder/assets.html',
        controller: 'AssetsCtrl',
          data: {
              requireAdmin: false
          }
      })
      .state('editAsset', {
        url: '/responder/editAsset/:assetId',
        templateUrl: 'responder/assetForm.html',
        controller: 'AssetsCtrl',
          data: {
              requireAdmin: false
          }
      })
      .state('testTool', {
          url: '/testTool',
          templateUrl: 'tools/InfobuttonQA.html',
          controller: 'ToolCtrl',
          data: {
              requireAdmin: false
          }
      })
      .state('ehrDemo', {
          url: '/ehrDemo',
          templateUrl: 'tools/OpenInfobuttonDemo.html',
          controller: 'ToolCtrl',
          data: {
              requireAdmin: false
          }
      })
      .state('systemConfiguration', {
        url: '/systemConfiguration',
        templateUrl: 'setup/systemConfiguration.html',
        controller: 'setupController',
        data: {
           requireAdmin: true
        }
      })
      .state('logout', {
          url: '/logout',
          controller: function(liteAuthenticationService, $state) {

              liteAuthenticationService.ClearCredentials();a
              $state.go('login');
          }
      })
});

oibConfigurationApp.run(function ($rootScope, $state, loginModal, $cookieStore, $http, $window) {


    // if (!localStorage.getItem('apiUrl'))
    // {
        localStorage.setItem("apiUrl", $window.location);
        localStorage.setItem("gitRepo", 'logicahealth/InfoButtons');
        localStorage.setItem("profileStorePath", 'profilestore');
        localStorage.setItem('init','yes');
    // }

    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }

    $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
        var requireAdmin = toState.data.requireAdmin;

        // redirect to login page if not logged in
        if (toState.name !== "login" && !$rootScope.globals.currentUser) {
            event.preventDefault();
            $state.go('login');
        } else if (requireAdmin && !$rootScope.globals.currentUser.admin) {
            event.preventDefault();
            return $state.reload();
        }

    });
});
