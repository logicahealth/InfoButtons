var setupControllers = angular.module('setupControllers', ['ui.bootstrap', 'ui.router']);

setupControllers.controller('setupController', function ($scope, $state, loginModal) {
    $scope.oids = JSON.parse(localStorage.getItem("oids"));

    $scope.gitUser = JSON.parse(localStorage.getItem("gitUser"));

    $scope.gitRepo = localStorage.getItem("gitRepo");

    $scope.hostName = localStorage.getItem("hostName");

    $scope.profilestore = localStorage.getItem("profileStorePath");

    $scope.oidRegex = /^\d+(\.\d+)*$/;

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
        if ($scope.oidForm.$valid && !$scope.oidForm.oidFormId.$error.pattern) {
            var oid = {orgOid: orgOid, orgName: orgName, selected: false};
            oids.push(oid);
        }
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
        if ($scope.gitForm.hostPath.$valid) {
            localStorage.setItem("hostName", hostName);
        }
    };

    $scope.setGitRepo = function(gitRepo) {

        if ($scope.gitForm.gitRepoPath.$valid) {
            localStorage.setItem("gitRepo", gitRepo);
        }
    };

    $scope.setProfileStorePath = function(profilestore) {
        if ($scope.gitForm.profilestorePath.$valid) {
            localStorage.setItem("profileStorePath", profilestore);
        }
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

setupControllers.controller('LoginModalCtrl', function ($scope, loginService) {

    $scope.submit = function (userName, password) {
        var gitUser = (userName != undefined) ? {user: userName, password: password} : undefined;
        loginService.checkValidUser(gitUser, this, $scope)
    }

});