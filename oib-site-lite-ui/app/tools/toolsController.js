'use strict';

var oibToolModule = angular.module('oibToolModule', ['ui.router']);

oibToolModule.controller('ToolCtrl', ['$state', '$scope', function($state, $scope) {

    $scope.oids = JSON.parse(localStorage.getItem("oids"));

    $scope.selected = $scope.oids[0];

    $scope.callIM = function (gender, age, task, mainSearchCriteriaC, labAbnormalFlag){
        var baseUrl = 'http://' + localStorage.getItem("hostName") + ':8080/infobutton-service/infoRequest?';
        var organizationOID = document.getElementById("organizationId").value;
        var organization = 'representedOrganization.id.root=' + organizationOID;

        var genderParam = '';
        if (gender != null)
        {

            genderParam = '&patientPerson.administrativeGenderCode.c=' + gender + '' ;
        }
        var ageParam = '';
        if (age != null) {
            ageParam = '&age.v.v=' + age + '&age.v.u=a';
        }
        var taskParam = '&taskContext.c.c=' + task;

        var mainSearchCriteriaParam = '&mainSearchCriteria.v.c=' + mainSearchCriteriaC + '&mainSearchCriteria.v.cs=' + getCs(mainSearchCriteriaC) + '&mainSearchCriteria.v.dn=' + getDn(mainSearchCriteriaC);

        //var severityObservationParam;
        //if (labAbnormalFlag != null){
        //	severityObservationParam = '&interpretationCode.c.c=' + labAbnormalFlag;
        //}

        var performerParam = '&informationRecipient.languageCode.c=en&performer=PROV';

        var xslt = '';
        if (getXslt(organizationOID) != null)
        {
            xslt = '&xsltTransform=' + getXslt(organizationOID);
        }

        var url = baseUrl + organization + genderParam + ageParam
            + taskParam + mainSearchCriteriaParam + performerParam + xslt;
        var winRef = window.open(url, '', 'width=970, height=670, status=no, location=no, toolbar=no, scrollbars=no, resizable=yes');
        //document.getElementById('urlDisplay').value = url;
    }

    $scope.buildUrl = function(){
        var knowledgeRequest ;
        knowledgeRequest = 'http://' + localStorage.getItem("hostName") + ':8080/infobutton-service/infoRequest?' + 'representedOrganization.id.root=' + document.getElementById("organizationId").value;

        if (document.getElementById("taskContextC").value != '') {
            knowledgeRequest = knowledgeRequest + '&taskContext.c.c=' + document.getElementById("taskContextC").value;
        }

        if (document.getElementById("mainSearchCriteriaC").value != '') {
            knowledgeRequest = knowledgeRequest + '&mainSearchCriteria.v.c=' + document.getElementById("mainSearchCriteriaC").value;
        }
        if (document.getElementById("mainSearchCriteriaCs").value != '') {
            knowledgeRequest = knowledgeRequest + '&mainSearchCriteria.v.cs=' + document.getElementById("mainSearchCriteriaCs").value;
        }
        if (document.getElementById("mainSearchCriteriaDn").value != '') {
            knowledgeRequest = knowledgeRequest + '&mainSearchCriteria.v.dn=' + document.getElementById("mainSearchCriteriaDn").value;
        }

        if (document.getElementById("administrativeGenderCodeC").value != '') {
            knowledgeRequest = knowledgeRequest + '&patientPerson.administrativeGenderCode.c=' +
                document.getElementById("administrativeGenderCodeC").value +
                '&patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1';
        }

        if (document.getElementById("ageV").value != '') {
            knowledgeRequest = knowledgeRequest + '&age.v.v=' + document.getElementById("ageV").value +
                '&age.v.u=' + document.getElementById("ageU").value;
        }

        if (document.getElementById("ageGroupC").value != '') {
            knowledgeRequest = knowledgeRequest + '&ageGroup.v.c=' +
                document.getElementById("ageGroupC").value + '&ageGroup.v.cs=2.16.840.1.113883.6.177';
        }

        if (document.getElementById("encounterC").value != '') {
            knowledgeRequest = knowledgeRequest + '&encounter.c.c=' +
                document.getElementById("encounterC").value;
        }

        if (document.getElementById("informationRecipient").value != '') {
            knowledgeRequest = knowledgeRequest + '&informationRecipient=' +
                document.getElementById("informationRecipient").value;
        }

        if (document.getElementById("informationRecipientLanguageC").value != '') {
            knowledgeRequest = knowledgeRequest + '&informationRecipient.languageCode.c=' +
                document.getElementById("informationRecipientLanguageC").value;
        }

        if (document.getElementById("informationRecipientDisciplineC").value != '') {
            knowledgeRequest = knowledgeRequest + '&informationRecipient.healthCareProvider.c.c=' +
                document.getElementById("informationRecipientDisciplineC").value +
                '&informationRecipient.healthCareProvider.c.cs=2.16.840.1.113883.6.101';
        }

        if (document.getElementById("performer").value != '') {
            knowledgeRequest = knowledgeRequest + '&performer=' +
                document.getElementById("performer").value;
        }

        if (document.getElementById("performerLanguageC").value != '') {
            knowledgeRequest = knowledgeRequest + '&performer.languageCode.c=' +
                document.getElementById("performerLanguageC").value;
        }

        if (document.getElementById("performerDisciplineC").value != '') {
            knowledgeRequest = knowledgeRequest + '&performer.healthCareProvider.c.c=' +
                document.getElementById("performerDisciplineC").value +
                '&performer.healthCareProvider.c.cs=2.16.840.1.113883.6.101';
        }
        if (document.getElementById("executionMode").value != '') {
            knowledgeRequest = knowledgeRequest + '&executionMode=' +
                document.getElementById("executionMode").value;
        }

        knowledgeRequest = knowledgeRequest + document.getElementById("output").value;

        return knowledgeRequest;
    }

    $scope.launchUrl = function ()
    {
        var url = this.buildUrl();
        var textField = document.getElementById('urlOutput');
        textField.value = url;
        window.open(url,"Infobutton", 'scrollbars=yes, resizable=yes, toolbar=yes, status=yes, left=0, top=0, width=1200,height=800');
    }

}]);
