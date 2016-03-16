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

oibSetupServices.service('loginService', function ($http, base64) {

    var loginService = {};

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