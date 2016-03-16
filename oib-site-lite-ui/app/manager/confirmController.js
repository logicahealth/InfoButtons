/**
 * Created by andrew on 12/18/14.
 */
var oibConfirmModule = angular.module('oibConfirmModule', ['ui.bootstrap']);

oibConfirmModule.controller('ConfirmController', ['$scope', '$uibModalInstance', function ($scope, $uibModalInstance) {

    $scope.ok = function () {
        $uibModalInstance.close();
    };
}])
