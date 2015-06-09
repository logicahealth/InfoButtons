/**
 * Created by andrew on 12/18/14.
 */
var oibModalModule = angular.module('oibModalModule', ['ui.bootstrap', 'checklist-model']);

oibModalModule.controller('ModalController', ['$scope', '$modalInstance', 'items', 'edit', 'selectedOids', function ($scope, $modalInstance, items, edit, selectedOids) {

    $scope.items = items;

    $scope.selection = {items: selectedOids};

    $scope.edit = edit;

    $scope.ok = function () {
        $modalInstance.close($scope.selection);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);
