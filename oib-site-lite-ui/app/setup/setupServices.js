var oibSetupServices = angular.module('oibSetupServices', ['ui.bootstrap', 'ngResource', 'ab-base64']);

oibSetupServices.service('loginModal', function ($uibModal, propertiesService) {

    function assignGitUser (user) {
        localStorage.setItem("gitUser", JSON.stringify(user));
        return user;
    }

    return function() {

        var instance = $uibModal.open({
            templateUrl: 'setup/loginModal.html',
            controller: 'LoginModalCtrl',
            controllerAs: 'LoginModalCtrl'
        });

        return instance.result.then(assignGitUser);
    };

});

oibSetupServices.service('umlsModal', function ($uibModal) {

    var oibPropertiesUrl = 'http://' + localStorage.getItem('hostName') + ':8080/infobutton-service/propertiesManager/'

    function assignUmlsUser (user) {
        localStorage.setItem("umlsUser", JSON.stringify(user));
        return user;
    }

    return function() {
        var instance = $uibModal.open({
            templateUrl: 'setup/umlsModal.html',
            controller: 'UmlsModalCtrl',
            controllerAs: 'UmlsModalCtrl'
        });

        return instance.result.then(assignUmlsUser);
    };

});

oibSetupServices.service('propertiesService', function ($rootScope, $http) {

    var propertiesService = {};

    var oibPropertiesService = 'http://' + localStorage.getItem('hostName') + ':8080/infobutton-service/propertiesManager/'

    propertiesService.getUmlsUserName = function() {

       return $http.get (oibPropertiesService + 'getProperty/umls.username/', {
            headers: {
                'Authorization' : undefined
            }
        }).then(function(response) {

            return response.data;
        });
    };

    propertiesService.getUmlsPassword = function() {

        return $http.get (oibPropertiesService + 'getProperty/umls.password/', {
            headers: {
                'Authorization' : undefined
            }
        }).then(function(response) {

            return response.data;
        });
    };

    propertiesService.getUmlsRelease = function() {

        return $http.get (oibPropertiesService + 'getProperty/umls.umlsRelease/', {
            headers: {
                'Authorization' : undefined
            }
        }).then(function(response) {

            return response.data;
        });
    };

    propertiesService.getGitUsername = function() {

        return $http.get (oibPropertiesService + 'getProperty/github.username/', {
            headers: {
                'Authorization' : undefined
            }
        }).then(function(response) {

            return response.data;
        });
    };

    propertiesService.getGitPassword = function() {

        return $http.get (oibPropertiesService + 'getProperty/github.password/', {
            headers: {
                'Authorization' : undefined
            }
        }).then(function(response) {

            return response.data;
        });
    };

    propertiesService.getOids = function() {

        return $http.get (oibPropertiesService + 'getProperties/oid/', {
            headers: {
                'Authorization' : undefined
            }
        }).then(function(response) {

            return response.data;
        });
    };

    return propertiesService;
});

oibSetupServices.service('loginService', function ($rootScope, $http, base64) {

    var loginService = {};

    var oibManagerUrl = 'http://' + localStorage.getItem('hostName') + ':8080/infobutton-service/liteManager/'

    loginService.getUsers = function(setupScope) {

        $http.get(oibManagerUrl + 'getUsers',
            {
                headers: {
                    'Authorization': undefined
                }
            }).success(function(response) {

            setupScope.users=response;
        });
    };

    loginService.deleteUser = function (user, setupState) {

        $http.post(oibManagerUrl + 'deleteUser', user,
            {
                headers: {
                    'Authorization': undefined
                }}).success(function() {

                setupState.reload();
        });
    };

    loginService.updateUser = function (username, password, setupState) {

        $http.post(oibManagerUrl + 'updateUser', {username: username, password: password, role: "USER"},
            {
                headers: {
                    'Authorization': undefined
                }}).success(function() {

            setupState.reload();
        });
    };

    loginService.updateAdminUser = function (username, password, setupState) {

        $http.post(oibManagerUrl + 'updateAdminUser', {username: username, password: password, role: "ADMIN"},
            {
                headers: {
                    'Authorization': undefined
                }}).success(function() {

            setupState.go('logout');
        });
    };

    loginService.checkValidUser = function (gitUser, loginModal, $loginScope) {
        $http.get(
            'https://api.github.com/repos/' + localStorage.getItem('gitRepo'),
            {
                headers: {
                    'Authorization' : 'Basic ' + base64.encode(gitUser.user + ':' + gitUser.password)
                }
            }).
            success(function () {
                loginModal.$close(gitUser);
            }).
            error(function () {
                $loginScope.invalidUser = true;
            })
        };

    return loginService;

});