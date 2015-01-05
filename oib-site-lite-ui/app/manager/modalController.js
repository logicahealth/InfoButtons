/**
 * Created by andrew on 12/18/14.
 */
var oibModalModule = angular.module('oibModalModule', ['ui.bootstrap', 'checklist-model']);

oibModalModule.controller('ModalController', ['$scope', '$modalInstance', 'items', function ($scope, $modalInstance, items) {

    $scope.items = items;

    $scope.selection = {items: []};

    $scope.ok = function () {
        $modalInstance.close($scope.selection);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}])
