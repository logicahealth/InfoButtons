var oibSetupServices = angular.module('oibSetupServices', ['ui.bootstrap', 'ngResource', 'ab-base64']);

oibSetupServices.service('loginModal', function ($uibModal) {

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