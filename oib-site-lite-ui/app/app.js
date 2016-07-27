'use strict';

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

oibConfigurationApp.config(function($stateProvider, $urlRouterProvider, uiSelectConfig) {

  uiSelectConfig.theme = 'bootstrap';

  $urlRouterProvider.otherwise('/login');

  $stateProvider

      .state('login', {
          url: '/login',
          controller: 'LoginController',
          templateUrl: 'authentication/login.html',
          data: {
              requireGit: false
          }
      })

      .state('home', {
        url: '/home',
        controller: 'HomeCtrl',
        templateUrl: 'home/home.html',
          data: {
              requireGit: false
          }
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
      .state('logout', {
          url: '/logout',
          controller: function(liteAuthenticationService, $state) {

              liteAuthenticationService.ClearCredentials();
              $state.go('login');
          }
      })
});

oibConfigurationApp.run(function ($rootScope, $state, loginModal, $location, $cookieStore, $http) {

    if (!localStorage.getItem('init'))
    {
        localStorage.setItem("hostName", $location.host());
        localStorage.setItem("gitRepo", 'VHAINNOVATIONS/InfoButtons');
        localStorage.setItem("profileStorePath", 'profilestore');
        localStorage.setItem("gitUser", 'undefined');
        localStorage.setItem('init','yes');
        localStorage.setItem('oids', JSON.stringify([]));
    }

    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }

    $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
        var requireLogin = toState.data.requireGit;

        // redirect to login page if not logged in
        if (toState.name !== "login" && !$rootScope.globals.currentUser) {
           event.preventDefault();
           $state.go('login');
        } else {
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
        }

    });
});
