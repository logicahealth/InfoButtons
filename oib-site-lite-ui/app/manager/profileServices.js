'use strict';

var oibManagerServiceModule = angular.module('oibManagerServiceModule', []);

oibManagerServiceModule.factory('profileFactory', ['$http', function($http) {

    var urlBase = 'http://localhost:3000/';
//    var urlBase = 'http://service.oib.utah.edu:8080/infobutton-service-dev/manager/';
    var profileFactory = {};

    profileFactory.getProfiles = function () {
        return $http.get(urlBase + 'profiles');
    };

    profileFactory.getProfile = function (id) {
        return $http.get(urlBase + 'profile/' + id);
    };

    profileFactory.insertProfile = function (profile) {
        return $http.put(urlBase + 'profile/create', profile);
    };

    profileFactory.updateProfile = function (profile) {
        return $http.put(urlBase + 'profile/update', profile);
    };

    profileFactory.deleteProfile = function (id) {
        return $http.delete(urlBase + 'profile/delete/' + id);
    };

    return profileFactory;
}]);

var uuidGenerator = angular.module('uuidGenerator', []);
uuidGenerator.factory("idGenerator", function () {
    return {
        getNewUuid: function () {
            // http://www.ietf.org/rfc/rfc4122.txt
            var s = [];
            var hexDigits = "0123456789abcdef";
            for (var i = 0; i < 36; i++) {
                s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
            }
            s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
            s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
            s[8] = s[13] = s[18] = s[23] = "-";
            return s.join("");
        }
    }
});
