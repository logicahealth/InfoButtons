/**
 * Created by andrew on 12/18/14.
 */
var oibConfirmModule = angular.module('oibConfirmModule', ['ui.bootstrap']);

oibConfirmModule.controller('ConfirmController', ['$scope', '$modalInstance', function ($scope, $modalInstance) {

    $scope.ok = function () {
        $modalInstance.close();
    };
}])
