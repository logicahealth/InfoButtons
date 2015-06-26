'use strict';

/**
 * Created by Joe Narus on 6/2/15.
 * A basic app that has controllers for a website that:
 * 1) Users enter search parameters into the request page.
 * 2) Those parameters are turned into a URL and sent off to the oib server.
 * 3) The server sends back a JSON response that the app then parses and creates a webpage from.
 */

(function() {

  var app = angular.module("myApp",['ui.router', 'ui.bootstrap']);

  app.config(function($stateProvider, $urlRouterProvider,$provide) {

    $urlRouterProvider.otherwise('/Request');

    /*
     * Allows the app to change states (making controller and page switches easier)
     */
    $stateProvider
        .state('request', {
          url:'/Request',
          templateUrl: 'request.html',
          controller: 'RequestController'
        })
        .state('information', {
          url:'/SearchResults',
          templateUrl: 'info-display.html',
          controller: 'LinkController'
        });


    //Causes the page to auto-scroll to the top upon refresh (Fixed a bug where the page was anchored to the bottom).
    $provide.decorator('$uiViewScroll', function () {
      return function (uiViewElement) {
      };
    });
  });

  //Controls the "main" functionality of the app. Namely any functionality that all states need access to.
  app.controller("MainController",['$rootScope','$scope', '$http', '$sce','$state', function($rootScope, $scope, $http, $sce, $state) {
    $rootScope.knowledgeRequest = "";
    $rootScope.parameters = {}; //Create an empty object
    $rootScope.parameters.list=[]; //Create an empty array
    $rootScope.parameters.list.push({}); //push an empty object into the array

    $rootScope.info = false; //If the proper fields are filled out.
    $rootScope.displayInfo = false; //Display the page if it has loaded
    $rootScope.progress = 0; //Used for progress bar

    $scope.text = []; //Holds the JSON response from the server
    $scope.currentLink = ""; //

    /////////// FUNCTIONS ///////////////

    //A function that will fill out the request form with the data from the previous request during the same session.
    $scope.fillForm = function() {
      if(($rootScope.parameters.list.keys != undefined || $rootScope.parameters.list.keys.length != 0)) {
        angular.forEach($rootScope.parameters.list[0], function(value) {
          console.log(value.documentElement);
          document.getElementById(value.documentElement).value = value.value;
        });
      }
    };


    //A function called at the initialization of the page.
    $rootScope.sendInfo = function(){
      $rootScope.progress = 60;
      //Information + json request -> sent off to server to get info back
      $http.get($rootScope.knowledgeRequest+"&knowledgeResponseType=application/json"
      ).then(function(result) {
            $rootScope.info = true; //activates the "information" button on the navbar.
            $scope.text = result.data;
            $scope.currentLink = $sce.trustAsResourceUrl($scope.text.feed[0].entry[0].link[0].href);
            $rootScope.progress = 100;
            $rootScope.displayInfo = true;
            $state.go('information');

          }
      );
    };
  }]);

  //Creates a controller for the app and sets an instance variable equal to the json that will be parsed in the html
  app.controller("LinkController", ['$scope','$http', '$sce', function($scope, $http, $sce)
  {
    $scope.setContent = function(url, linkId) {
      $scope.currentLink = $sce.trustAsResourceUrl(url);
      //Runs through and checks which links aren't selected and makes sure they don't have a check mark next to them.
      var selectedLinks = document.getElementsByClassName('selected');
      for (var i = 0; i < selectedLinks.length; i ++) {
        selectedLinks[i].style.display = 'none';
      }
      document.getElementById(linkId).style.display = 'inline'; //adds the check mark to the currently selected link.
    };
  }]);

  //Controller for the request sheet. Handles building the URL and the saving of the form (in case a user wants to come back and edit the form after search results have been entered).
  app.controller("RequestController",['$rootScope','$scope', function($rootScope,$scope) {

    $scope.knowledgeRequest = ""; //holds the knowledge request at the "RequestController" level. Will eventually be sent to rootScope.

    $scope.saveRequest = function(parameterType, docElementName, parameterSubType ,parameter) {

      $rootScope.parameters.list[0][parameterType] = {'documentElement': docElementName,'subType':parameterSubType, 'value':parameter};
    };

    /*
     * A function that builds the URL to be sent to the server based on all the values the user places into the request form.
     * Also saves every value to a JSON array for future reference.
     */
    $scope.buildUrl = function() {

      $scope.knowledgeRequest = document.getElementById("server").value + 'representedOrganization.id.root=' + document.getElementById("organizationId").value;

      if (document.getElementById("taskContextC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&taskContext.c.c=' + document.getElementById("taskContextC").value;

        $scope.saveRequest('taskContext','taskContextC','taskContext.c.c', document.getElementById("taskContextC").value);
      }

      if (document.getElementById("mainSearchCriteriaC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&mainSearchCriteria.v.c=' + document.getElementById("mainSearchCriteriaC").value;

        $scope.saveRequest('mainSearchCriteriaC','mainSearchCriteriaC','mainSearchCriteria.v.c', document.getElementById("mainSearchCriteriaC").value);
      }
      if (document.getElementById("mainSearchCriteriaCs").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&mainSearchCriteria.v.cs=' + document.getElementById("mainSearchCriteriaCs").value;

        $scope.saveRequest('mainSearchCriteriaCs','mainSearchCriteriaCs','mainSearchCriteria.v.cs', document.getElementById("mainSearchCriteriaCs").value);
      }
      if (document.getElementById("mainSearchCriteriaDn").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&mainSearchCriteria.v.dn=' + document.getElementById("mainSearchCriteriaDn").value;

        $scope.saveRequest('mainSearchCriteriaDn','mainSearchCriteriaDn','mainSearchCriteria.v.dn', document.getElementById("mainSearchCriteriaDn").value);
      }

      if (document.getElementById("administrativeGenderCodeC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&patientPerson.administrativeGenderCode.c=' +
            document.getElementById("administrativeGenderCodeC").value +
            '&patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1';

        $scope.saveRequest('genderCode','administrativeGenderCodeC','patientPerson.administrativeGenderCode.cs',
            document.getElementById("administrativeGenderCodeC").value + '&patientPerson.administrativeGenderCode.c=');
      }

      if (document.getElementById("ageV").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&age.v.v=' + document.getElementById("ageV").value +
            '&age.v.u=' + document.getElementById("ageU").value;

        $scope.saveRequest('ageV','ageV','age.v.v', document.getElementById("ageV").value);
        $scope.saveRequest('ageU','ageU','age.v.u', document.getElementById("ageU").value);
      }

      if (document.getElementById("ageGroupC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&ageGroup.v.c=' +
            document.getElementById("ageGroupC").value + '&ageGroup.v.cs=2.16.840.1.113883.6.177';

        $scope.saveRequest('ageGroup','ageGroupC','age.v.c', document.getElementById("ageV").value + '&ageGroup.v.cs=2.16.840.1.113883.6.177');
      }

      if (document.getElementById("encounterC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&encounter.c.c=' +
            document.getElementById("encounterC").value;

        $scope.saveRequest('encounter','encounterC','encounter.c.c', document.getElementById("encounterC").value);
      }

      if (document.getElementById("informationRecipient").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&informationRecipient=' +
            document.getElementById("informationRecipient").value;

        $scope.saveRequest('infoRecipient','informationRecipient','informationRecipient', document.getElementById("informationRecipient").value);
      }

      if (document.getElementById("informationRecipientLanguageC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&informationRecipient.languageCode.c=' +
            document.getElementById("informationRecipientLanguageC").value;

        $scope.saveRequest('language','informationRecipientLanguageC','informationRecipient.languageCode.c',
            document.getElementById("informationRecipientLanguageC").value);
      }

      if (document.getElementById("informationRecipientDisciplineC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&informationRecipient.healthCareProvider.c.c=' +
            document.getElementById("informationRecipientDisciplineC").value +
            '&informationRecipient.healthCareProvider.c.cs=2.16.840.1.113883.6.101';

        $scope.saveRequest('infoDiscipline','informationRecipientDisciplineC','informationRecipient.healthCareProvider.c.c',
            document.getElementById("informationRecipientDisciplineC").value + '&informationRecipient.healthCareProvider.c.cs=2.16.840.1.113883.6.101');
      }

      if (document.getElementById("performer").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&performer=' +
            document.getElementById("performer").value;

        $scope.saveRequest('performer','performer','performer',
            document.getElementById("performer").value);
      }

      if (document.getElementById("performerLanguageC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&performer.languageCode.c=' +
            document.getElementById("performerLanguageC").value;

        $scope.saveRequest('performerLanguage','performerLanguageC','performer.languageCode.c',
            document.getElementById("performerLanguageC").value);
      }

      if (document.getElementById("performerDisciplineC").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&performer.healthCareProvider.c.c=' +
            document.getElementById("performerDisciplineC").value +
            '&performer.healthCareProvider.c.cs=2.16.840.1.113883.6.101';

        $scope.saveRequest('performerDiscipline','performerDisciplineC','performer.healthCareProvider.c.c',
            document.getElementById("performerDisciplineC").value + '&performer.healthCareProvider.c.cs=2.16.840.1.113883.6.101');
      }

      if (document.getElementById("executionMode").value != '') {
        $scope.knowledgeRequest = $scope.knowledgeRequest + '&executionMode=' +
            document.getElementById("executionMode").value;
      }


      $rootScope.knowledgeRequest = $scope.knowledgeRequest; //Saves the scope value to rootScope for MainController
      $rootScope.progress=25;
      $rootScope.sendInfo();
    };
  }]);

})();