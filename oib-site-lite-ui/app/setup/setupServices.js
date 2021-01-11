var oibSetupServices = angular.module('oibSetupServices', ['ui.bootstrap', 'ngResource', 'ab-base64']);

oibSetupServices.service('loginModal', function ($uibModal, propertiesService) {

    function assignGitUser (user) {
        propertiesService.setGitUsername(user.user);
        propertiesService.setGitPassword(user.password);
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

oibSetupServices.service('umlsModal', function ($uibModal, propertiesService) {

    var oibPropertiesUrl = 'http://' + localStorage.getItem('hostName') + ':8080' + '/infobutton-service/propertiesManager/'

    function assignUmlsUser (user) {

        propertiesService.setUmlsUserName(user.user);
        propertiesService.setUmlsPassword(user.password);
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

    var oibPropertiesService = 'http://' + localStorage.getItem('hostName') + ':8080' + '/infobutton-service/propertiesManager/'

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

    propertiesService.setUmlsUserName = function(userName) {

        return $http.post (oibPropertiesService + 'updateProperty/umls.username/', userName, {
            headers: {
                'Authorization' : undefined
            }
        });
    };

    propertiesService.setUmlsPassword = function(password) {

        return $http.post (oibPropertiesService + 'updateProperty/umls.password/', password, {
            headers: {
                'Authorization' : undefined
            }
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

    propertiesService.setGitUsername = function(userName) {

        return $http.post (oibPropertiesService + 'updateProperty/github.username/', userName, {
            headers: {
                'Authorization' : undefined
            }
        });

    };

    propertiesService.setGitPassword = function(password) {

        return $http.post (oibPropertiesService + 'updateProperty/github.password/', password, {
            headers: {
                'Authorization' : undefined
            }
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

    propertiesService.deleteOid = function(id) {

        return $http.get (oibPropertiesService + 'deleteProperty/' + id, {
            headers: {
                'Authorization' : undefined
            }
        });
    }

    propertiesService.addOid = function(oidValue, oidName) {

        return $http.get (oibPropertiesService + 'addProperty/oid/' + oidValue + '/' + oidName, {
            headers: {
                'Authorization' : undefined
            }
        });
    }

    return propertiesService;
});

oibSetupServices.service('loginService', function ($rootScope, $http, base64) {

    var loginService = {};

    var oibManagerUrl = 'http://' + localStorage.getItem('hostName') + ':8080' + '/infobutton-service/liteManager/'

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