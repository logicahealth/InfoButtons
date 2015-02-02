var setupControllers = angular.module('setupControllers', ['ui.bootstrap', 'ui.router']);

setupControllers.controller('setupController', function ($scope, $state, loginModal) {
    $scope.oids = JSON.parse(localStorage.getItem("oids"));

    $scope.gitUser = JSON.parse(localStorage.getItem("gitUser"));

    $scope.gitRepo = localStorage.getItem("gitRepo");

    $scope.hostName = localStorage.getItem("hostName");

    $scope.profilestore = localStorage.getItem("profileStorePath");

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
        $scope.oids = oids;
    };

    $scope.deleteOid = function(index) {

        var oids = JSON.parse(localStorage.getItem("oids"));
        oids.splice(index, 1);
        localStorage.setItem("oids", JSON.stringify(oids));
        $scope.oids = oids;
    };

    $scope.setHostName = function(hostName) {

        localStorage.setItem("hostName", hostName);
    };

    $scope.setGitRepo = function(gitRepo) {

        localStorage.setItem("gitRepo", gitRepo);
    };

    $scope.setProfileStorePath = function(profilestore) {

        localStorage.setItem("profileStorePath", profilestore);
    };

    $scope.changeGitUser = function() {

        loginModal()
            .then(function () {
                return $state.reload();
            })
            .catch(function () {
                return $state.go('systemConfiguration');
            });
    }
});

setupControllers.controller('LoginModalCtrl', function ($scope) {

    $scope.submit = function (userName, password) {
        var gitUser = (userName != undefined) ? {user: userName, password: password} : undefined;
        this.$close(gitUser);
    };

});