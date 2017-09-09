var setupControllers = angular.module('setupControllers', ['ui.bootstrap', 'ui.router']);

setupControllers.controller('setupController', function ($scope, $state, loginModal, umlsModal, loginService, propertiesService) {

    $scope.gitRepo = localStorage.getItem("gitRepo");

    $scope.hostName = localStorage.getItem("hostName");

    $scope.profilestore = localStorage.getItem("profileStorePath");

    $scope.oidRegex = /^\d+(\.\d+)*$/;

    loginService.getUsers($scope);

    getProperties();

    function getProperties() {

        propertiesService.getUmlsUserName().then(function(data) {

            $scope.umlsUser=data.propValue;
        })

        propertiesService.getUmlsRelease().then(function(data) {

            $scope.umlsRelease=data.propValue;
        })

        propertiesService.getGitUsername().then(function(data) {

            $scope.gitUser = data.propValue;
        })

        propertiesService.getOids().then(function(data){

            $scope.oids = data;
        })

    }

    $scope.deleteUser = function(user)
    {

        loginService.deleteUser(user, $state);
    }

    $scope.addUser = function (username, password)
    {

        loginService.updateUser(username, password, $state)
    }

    $scope.updateAdminUser = function (username, password)
    {

        loginService.updateAdminUser(username, password, $state)
    }

    $scope.addOids = function(orgOid, orgName) {

        if ($scope.oidForm.$valid && !$scope.oidForm.orgOid.$error.pattern) {

            propertiesService.addOid(orgOid, orgName).then(function()
            {
                return propertiesService.getOids();
            }).then(function(data) {

                $scope.oids = data;
                $scope.oidForm.$setPristine();
                $scope.orgOid = '';
                $scope.orgName= '';
            })
        }
    };

    $scope.deleteOid = function(index) {

        propertiesService.deleteOid(index).then(function()
        {
            return propertiesService.getOids();
        }).then(function(data) {

            $scope.oids = data;
        })
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

    $scope.changeUmlsUser = function() {

        umlsModal()
            .then(function () {
                return $state.reload();
            })
            .catch(function () {
                return $state.go('systemConfiguration');
            });
    }

    $scope.changeUmlsRelease = function (umlsRelease) {

        propertiesService.setUmlsRelease(umlsRelease).then(function() {

            return $state.reload();
        });

    }
});

setupControllers.controller('LoginModalCtrl', function ($scope, loginService, propertiesService) {

    getGitUser();

    function getGitUser() {

        propertiesService.getGitUsername().then(function(data) {

            $scope.gitUser=data.propValue;
        })

        propertiesService.getGitPassword().then(function(data) {

            $scope.gitPassword=data.propValue;
        })
    }

    $scope.submit = function (userName, password) {
        var gitUser = (userName != undefined) ? {user: userName, password: password} : undefined;
        loginService.checkValidUser(gitUser, this, $scope)
    }

});

setupControllers.controller('UmlsModalCtrl', function ($scope, loginService, propertiesService) {

    getUmlsUser();

    function getUmlsUser() {

        propertiesService.getUmlsUserName().then(function(data) {

            $scope.umlsUser=data.propValue;
        })

        propertiesService.getUmlsPassword().then(function(data) {

            $scope.umlsPassword=data.propValue;
        })
    }

    $scope.submit = function (userName, password) {
        var umlsUser = (userName != undefined) ? {user: userName, password: password} : undefined;
        this.$close(umlsUser);

    }

});