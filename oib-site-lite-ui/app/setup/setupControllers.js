var setupControllers = angular.module('setupControllers', ['ui.bootstrap']);

setupControllers.controller('setupController', function ($scope) {
    $scope.alerts = JSON.parse(localStorage.getItem("oids"));

    $scope.addOids = function(orgOid, orgName) {

        var oids = localStorage.getItem("oids");
        if (oids != null)
        {
            oids = JSON.parse(oids);
        }
        else
        {
            oids = [];
        }
        var oid = {orgOid:orgOid, orgName:orgName, selected: false};
        oids.push(oid);
        localStorage.setItem("oids", JSON.stringify(oids));
        $scope.alerts = oids;
    };

    $scope.closeAlert = function(index) {

        var oids = JSON.parse(localStorage.getItem("oids"));
        oids.splice(index, 1);
        localStorage.setItem("oids", JSON.stringify(oids));
        $scope.alerts = oids;
    };
});

setupControllers.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/systemConfiguration', {
            templateUrl: 'setup/systemConfiguration.html',
            controller: 'setupController'
        });
}]);