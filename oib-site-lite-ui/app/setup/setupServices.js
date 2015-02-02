var oibSetupServices = angular.module('oibSetupServices', ['ui.bootstrap']);

oibSetupServices.service('loginModal', function ($modal) {

    function assignGitUser (user) {
        localStorage.setItem("gitUser", JSON.stringify(user));
        return user;
    }

    return function() {
        var instance = $modal.open({
            templateUrl: 'setup/loginModal.html',
            controller: 'LoginModalCtrl',
            controllerAs: 'LoginModalCtrl'
        });

        return instance.result.then(assignGitUser);
    };

});