'use strict';

var liteAuthenticationModule = angular.module('liteAuthenticationModule', ['liteAuthenticationServiceModule', 'ui.router']);

liteAuthenticationModule.controller('LoginController', ['$scope', '$rootScope', '$state', 'liteAuthenticationService',
            function ($scope, $rootScope, $state, liteAuthenticationService) {
                // reset login status
                liteAuthenticationService.ClearCredentials();

                $scope.login = function () {
                    $scope.dataLoading = true;
                    liteAuthenticationService.Login($scope.username, $scope.password, function(response) {
                        if(response !== '') {
                            liteAuthenticationService.SetCredentials($scope.username, $scope.password);
                            $state.go('home');
                        } else {
                            $scope.error = 'Username or password is incorrect';
                            $scope.dataLoading = false;
                        }
                    });
                };
            }]);
