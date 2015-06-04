/**
 * A basic app that parses JSON and turns it into a website.
 * Created by Joe Narus on 6/2/15.
 */

(function() {

    var app = angular.module("myApp",[]);

    var json = [
        {"feed":[{"title":{"value":["  Veterans Health Library"],"type":"text"},"subtitle":{"value":["Diabetes Mellitus Type 2"],
            "type":"text"},"updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,
            "orig_fracSeconds":0.764,"orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,
            "fractionalSecond":0.764}},"category":[{"term":"PROBLISTREV","scheme":"taskContext.c.c"},{"term":"PROV","scheme":"informationRecipient"},
            {"term":"210.00","scheme":"mainSearchCriteria.v.c"},{"term":"2.16.840.1.113883.6.103","scheme":"mainSearchCriteria.v.cs"},
            {"term":"Diabetes Mellitus Type 2","scheme":"mainSearchCriteria.v.dn"}],"id":{"value":"urn:uuid:d6fc7bf6-7fc5-44b7-8231-c679f44121ab"},
            "entry":[{"title":{"value":["Patient education"],"type":"text"},"link":[{"href":"http://clinical35.staywellsolutionsonline.com/infobutton/search.pg?informationRecipient\u003dPROV\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2",
                "rel":"alternate","type":"html","hreflang":"","title":"Patient education"}],"id":{"value":"urn:uuid:9dd69a99-2ede-4965-8c57-3750604732a3"},
                "updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,
                    "orig_fracSeconds":0.765,"orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,
                    "fractionalSecond":0.765}},"lang":""}],"lang":""},{"title":{"value":[" UpToDate"],"type":"text"},"subtitle":{"value":
            ["Diabetes Mellitus Type 2"],"type":"text"},"updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,
            "orig_second":4,"orig_fracSeconds":0.765,"orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,
            "fractionalSecond":0.765}},"category":[{"term":"PROBLISTREV","scheme":"taskContext.c.c"},{"term":"PROV","scheme":"performer"},{"term":"210.00",
            "scheme":"mainSearchCriteria.v.c"},{"term":"2.16.840.1.113883.6.103","scheme":"mainSearchCriteria.v.cs"},{"term":"Diabetes Mellitus Type 2",
            "scheme":"mainSearchCriteria.v.dn"}],"id":{"value":"urn:uuid:8b9f2136-3611-40a7-ba56-95f197511a6f"},
            "entry":[{"title":{"value":["Diagnosis"],"type":"text"},"link":[{"href":"http://www.uptodate.com/online/content/search.do?searchType\u003dHL7\u0026taskContext.c.c\u003dPROBLISTREV\u0026taskContext.c.cs\u003d2.16.840.1.113883.5.4\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2\u0026subTopic.v.c\u003dQ000175\u0026subTopic.v.cs\u003d2.16.840.1.113883.6.177\u0026subTopic.v.dn\u003dDiagnosis",
                "rel":"alternate","type":"html","hreflang":"en","title":"Diagnosis"}],"id":{"value":"urn:uuid:f7e28e7c-19c5-41e6-8a81-8b3105028df2"},
                "updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,
                    "orig_fracSeconds":0.765,"orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,
                    "fractionalSecond":0.765}},"category":[{"term":"Q000175","scheme":"subTopic.v.c"},{"term":"2.16.840.1.113883.6.177",
                    "scheme":"subTopic.v.cs"},{"term":"Diagnosis","scheme":"subTopic.v.dn"}],"lang":"en"},{"title":{"value":["Treatment"],
                "type":"text"},"link":[{"href":"http://www.uptodate.com/online/content/search.do?searchType\u003dHL7\u0026taskContext.c.c\u003dPROBLISTREV\u0026taskContext.c.cs\u003d2.16.840.1.113883.5.4\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2\u0026subTopic.v.c\u003dQ000628\u0026subTopic.v.cs\u003d2.16.840.1.113883.6.177\u0026subTopic.v.dn\u003dTreatment",
                "rel":"alternate","type":"html","hreflang":"en","title":"Treatment"}],"id":{"value":"urn:uuid:97d3212f-0774-4aec-a419-03782b7070b6"},
                "updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,"orig_fracSeconds":0.765,
                    "orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,"fractionalSecond":0.765}},
                "category":[{"term":"Q000628","scheme":"subTopic.v.c"},{"term":"2.16.840.1.113883.6.177","scheme":"subTopic.v.cs"},{"term":"Treatment",
                    "scheme":"subTopic.v.dn"}],"lang":"en"},{"title":{"value":["Etiology"],"type":"text"},"link":[{"href":"http://www.uptodate.com/online/content/search.do?searchType\u003dHL7\u0026taskContext.c.c\u003dPROBLISTREV\u0026taskContext.c.cs\u003d2.16.840.1.113883.5.4\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2\u0026subTopic.v.c\u003dQ000209\u0026subTopic.v.cs\u003d2.16.840.1.113883.6.177\u0026subTopic.v.dn\u003dEtiology",
                "rel":"alternate","type":"html","hreflang":"en","title":"Etiology"}],"id":{"value":"urn:uuid:798eaf10-d6e8-43fb-a5d6-e23f3f84e4d9"},
                "updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,"orig_fracSeconds":0.765,
                    "orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,"fractionalSecond":0.765}},
                "category":[{"term":"Q000209","scheme":"subTopic.v.c"},{"term":"2.16.840.1.113883.6.177","scheme":"subTopic.v.cs"},{"term":"Etiology",
                    "scheme":"subTopic.v.dn"}],"lang":"en"},{"title":{"value":["Prognosis"],"type":"text"},"link":[{"href":"http://www.uptodate.com/online/content/search.do?searchType\u003dHL7\u0026taskContext.c.c\u003dPROBLISTREV\u0026taskContext.c.cs\u003d2.16.840.1.113883.5.4\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2\u0026subTopic.v.c\u003dD011379\u0026subTopic.v.cs\u003d2.16.840.1.113883.6.177\u0026subTopic.v.dn\u003dPrognosis",
                "rel":"alternate","type":"html","hreflang":"en","title":"Prognosis"}],"id":{"value":"urn:uuid:539f1928-2154-4361-a066-27819d6bc3a5"},
                "updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,"orig_fracSeconds":0.765,
                    "orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,"fractionalSecond":0.765}},
                "category":[{"term":"D011379","scheme":"subTopic.v.c"},{"term":"2.16.840.1.113883.6.177","scheme":"subTopic.v.cs"},{"term":"Prognosis",
                    "scheme":"subTopic.v.dn"}],"lang":"en"},{"title":{"value":["Symptoms and Signs"],"type":"text"},"link":[{"href":"http://www.uptodate.com/online/content/search.do?searchType\u003dHL7\u0026taskContext.c.c\u003dPROBLISTREV\u0026taskContext.c.cs\u003d2.16.840.1.113883.5.4\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2\u0026subTopic.v.c\u003dQ000175\u0026subTopic.v.cs\u003d2.16.840.1.113883.6.177\u0026subTopic.v.dn\u003dSymptoms and Signs",
                "rel":"alternate","type":"html","hreflang":"en","title":"Symptoms and Signs"}],"id":{"value":"urn:uuid:3f9bcbd0-5722-4878-a590-aca6b6a2b16f"},
                "updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,"orig_fracSeconds":0.765,
                    "orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,"fractionalSecond":0.765}},
                "category":[{"term":"Q000175","scheme":"subTopic.v.c"},{"term":"2.16.840.1.113883.6.177","scheme":"subTopic.v.cs"},{"term":"Symptoms and Signs",
                    "scheme":"subTopic.v.dn"}],"lang":"en"}],"lang":"en"},{"title":{"value":["Mosby\u0027s Skills"],"type":"text"},"subtitle":{"value":["Diabetes Mellitus Type 2"],
            "type":"text"},"updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,"orig_fracSeconds":0.963,
            "orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,"fractionalSecond":0.963}},"category":[{"term":"PROBLISTREV",
            "scheme":"taskContext.c.c"},{"term":"PROV","scheme":"performer"},{"term":"210.00","scheme":"mainSearchCriteria.v.c"},{"term":"2.16.840.1.113883.6.103",
            "scheme":"mainSearchCriteria.v.cs"},{"term":"Diabetes Mellitus Type 2","scheme":"mainSearchCriteria.v.dn"}],"id":{"value":"urn:uuid:9f208046-4784-4293-ad07-5efe7c829719"},
            "entry":[{"title":{"value":["Topic summary"],"type":"text"},"link":[{"href":"http://www.elsinfobutton.com/info/1030?taskContext.c.c\u003dPROBLISTREV\u0026taskContext.c.cs\u003d2.16.840.1.113883.5.4\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2",
                "rel":"alternate","type":"html","hreflang":"en","title":"Topic summary"}],"id":{"value":"urn:uuid:2da803a5-ee71-47d9-bcb0-ee6db9d1ddab"},
                "updated":{"value":{"orig_year":2015,"orig_month":6,"orig_day":2,"orig_hour":13,"orig_minute":56,"orig_second":4,"orig_fracSeconds":0.964,
                    "orig_timezone":-360,"year":2015,"month":6,"day":2,"timezone":-360,"hour":13,"minute":56,"second":4,"fractionalSecond":0.964}},"lang":"en"}],
            "lang":"en"}],"lang":"en"}
    ];
    var initialLink = "http://clinical35.staywellsolutionsonline.com/infobutton/search.pg?informationRecipient\u003dPROV\u0026mainSearchCriteria.v.c\u003d210.00\u0026mainSearchCriteria.v.cs\u003d2.16.840.1.113883.6.103\u0026mainSearchCriteria.v.dn\u003dDiabetes Mellitus Type 2";
    var json1 = [];
//Creates a controller for the app and sets an instance variable equal to the json that will be parsed in the html
    app.controller("HomeController", ['$http', '$sce', function($http, $sce)
    {
        this.text = json;
        this.currentLink = $sce.trustAsResourceUrl(initialLink);


        this.setContent = function(url, linkId) {
            this.currentLink = $sce.trustAsResourceUrl(url);
            //Runs through and checks which links aren't selected and makes sure they don't have a check mark next to them.
            var selectedLinks = document.getElementsByClassName('selected');
            for (var i = 0; i < selectedLinks.length; i ++) {
                selectedLinks[i].style.display = 'none';
            }
            document.getElementById(linkId).style.display = 'inline'; //adds the check mark to the currently selected link.
        };
    }]);

    app.controller("MainController",['$http', function($http) {

        this.text = [];
        var information = this;
        $http.get("http://service.oib.utah.edu:8080/infobutton-service/" +
            "infoRequest?representedOrganization.id.root=1.3.6.1.4.1.3768&xsltTransform=Infobutton_UI_VA&taskContext.c.c=" +
            "PROBLISTREV&mainSearchCriteria.v.c=210.00&mainSearchCriteria.v.cs=2.16.840.1.113883.6.103&mainSearchCriteria.v.dn=Diabetes%" +
            "20Mellitus%20Type%202&informationRecipient=PROV&performer=PROV&knowledgeResponseType=application/json").success((function (data) {
            information.text = data;
            json1 = information.text;

            alert(json1.feed[0].title.value[0]);
            alert(json1.feed[1].title.value[0]);
            alert(information.text.feed[2].title.value[0]);

        }));
    }]);
})();