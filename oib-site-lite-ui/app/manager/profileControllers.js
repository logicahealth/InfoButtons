    'use strict';

var oibManagerModule = angular.module('oibManagerModule', ['ui.router','ngResource', 'ab-base64', 'ui.bootstrap', 'directives', 'schemaForm']);

oibManagerModule.controller('ProfileCtrl', ['$scope', '$uibModal', 'profileFactory', '$state', function ($scope, $uibModal, profileFactory, $state) {

        $scope.localProfiles = [];
        $scope.cloudProfiles = [];
        $scope.status;
        $scope.items = JSON.parse(localStorage.getItem("oids"));

        getLocalProfiles();

        function getLocalProfiles() {
            profileFactory.getProfiles()
                    .success(function (profiles) {
                        var xmlDoc;
                        profiles.forEach (function (profile) {
                            if (window.DOMParser)
                            {
                                var parser=new DOMParser();
                                xmlDoc=parser.parseFromString(profile.content,"text/xml");
                            }
                            else // code for IE
                            {
                                xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
                                xmlDoc.async=false;
                                xmlDoc.loadXML(profile.content);
                            }
                            var $xml = $(xmlDoc);
                            var $profileD = $xml.find("profileDescription");
                            profile.profileDescription = $profileD.text();
                        });
                        $scope.localProfiles = profiles;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load local profiles: ' + error;
                    });
        }

        $scope.updateStatus = function (profile, status) {
            profile.status = status;
            profileFactory.insertProfile(profile)
                .success(function (msg) {
                    $scope.statusMessage = msg.object + ' ' + msg.event;
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to save profile:' + error;
                });
        };

    $scope.editOids = function(profile) {

        var selectedOids = profileFactory.getOids(profile);
        var profileOids = angular.copy(selectedOids);
        var items = $scope.items;
        var uniqueItems = [];
        for (var i = 0; i < items.length; i++)
        {
            for (var c = 0; c < profileOids.length; c++)
            {
                if ((profileOids[c].orgOid != items[i].orgOid))
                {
                    if ((c + 1) == profileOids.length)
                    {
                        uniqueItems.push(items[i]);
                    }
                }
                else
                {
                    break;
                }
            }
        }
        if (profileOids.length  == 0) {

            profileOids = $scope.items;
        }
        else
        {
            for (var x = 0; x < uniqueItems.length; x++)
            {
                profileOids.push(uniqueItems[x]);
            }
        }
        var modalInstance = $uibModal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalController',
            resolve: {
                items: function () {
                    return profileOids;
                },
                selectedOids : function () {
                    return selectedOids;
                },
                edit: function () {

                    return true;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            changeOids(profile,selectedItem);
        }, function () {
            $scope.status ='Modal dismissed at: ' + new Date();
        });
    };

    function changeOids (profile, oids) {
        profileFactory.changeOids(profile, oids)
            .success(function (msg) {
                $scope.statusMessage = msg.object + ' ' + msg.event;
                $state.reload();
            })
            .error(function (error) {
                $scope.statusMessage = 'Unable to update profile oids:' + error;
                $state.reload();
            });
    }

    return $scope;
    }]);

oibManagerModule.controller('ProfileFormCtrl', ['$scope', '$stateParams', 'profileFactory', '$state', function ($scope, $stateParams, profileFactory, $state) {

     var jsonProfileSchema = {
        "type" : "object",
        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeResourceProfile",
        "properties" : {
            "header" : {
                "type" : "object",
                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeResourceProfile:Header",
                "properties" : {
                    "title" : {
                        "type" : "string"
                    },
                    "profileDescription" : {
                        "type" : "string"
                    },
                    "versionControl" : {
                        "type" : "object",
                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeResourceProfile:Header:VersionControl",
                        "properties" : {
                            "publicationDate" : {
                                "type" : "integer",
                                "format" : "UTC_MILLISEC"
                            }
                        }
                    },
                    "id" : {
                        "type" : "integer"
                    }
                }
            },
            "profileDefinition" : {
                "type" : "object",
                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition",
                "properties" : {
                    "authorizedOrganizations" : {
                        "type" : "object",
                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition:AuthorizedOrganizations",
                        "properties" : {
                            "authorizedOrganization" : {
                                "type" : "array",
                                "items" : {
                                    "type" : "object",
                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition:AuthorizedOrganizations:AuthorizedOrganization",
                                    "properties" : {
                                        "id" : {
                                            "type" : "string"
                                        },
                                        "name" : {
                                            "type" : "string"
                                        },
                                        "namespace" : {
                                            "type" : "string"
                                        },
                                        "knowledgeRequestServiceLocation" : {
                                            "type" : "object",
                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeRequestServiceLocation",
                                            "properties" : {
                                                "url" : {
                                                    "type" : "string"
                                                }
                                            }
                                        },
                                        "accessMethod" : {
                                            "type" : "array",
                                            "items" : {
                                                "type" : "object",
                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition:AuthorizedOrganizations:AuthorizedOrganization:AccessMethod",
                                                "properties" : {
                                                    "networkAccessMethod" : {
                                                        "type" : "object",
                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CD",
                                                        "properties" : {
                                                            "code" : {
                                                                "type" : "object",
                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                "properties" : {
                                                                    "code" : {
                                                                        "type" : "string"
                                                                    },
                                                                    "codeSystem" : {
                                                                        "type" : "string"
                                                                    },
                                                                    "codeSystemName" : {
                                                                        "type" : "string"
                                                                    },
                                                                    "displayName" : {
                                                                        "type" : "string"
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    },
                                                    "authenticationMethod" : {
                                                        "type" : "object",
                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition:AuthorizedOrganizations:AuthorizedOrganization:AccessMethod:AuthenticationMethod",
                                                        "properties" : {
                                                            "usrPwd" : {
                                                                "type" : "object",
                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition:AuthorizedOrganizations:AuthorizedOrganization:AccessMethod:AuthenticationMethod:UsrPwd",
                                                                "properties" : {
                                                                    "name" : {
                                                                        "type" : "string"
                                                                    },
                                                                    "certificateText" : {
                                                                        "type" : "string"
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        },
                                        "usesAssignedAuthorizedPerson" : {
                                            "type" : "boolean"
                                        }
                                    }
                                }
                            }
                        }
                    },
                    "supportedTerminologies" : {
                        "type" : "object",
                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition:SupportedTerminologies",
                        "properties" : {
                            "supportedTerminology" : {
                                "type" : "array",
                                "items" : {
                                    "type" : "object",
                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                    "properties" : {
                                        "id" : {
                                            "type" : "string"
                                        },
                                        "name" : {
                                            "type" : "string"
                                        },
                                        "namespace" : {
                                            "type" : "string"
                                        }
                                    }
                                }
                            }
                        }
                    },
                    "contexts" : {
                        "type" : "object",
                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:ProfileDefinition:Contexts",
                        "properties" : {
                            "context" : {
                                "type" : "array",
                                "items" : {
                                    "type" : "object",
                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Context",
                                    "properties" : {
                                        "contextDescription" : {
                                            "type" : "string"
                                        },
                                        "contextDefinition" : {
                                            "type" : "object",
                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Context:ContextDefinition",
                                            "properties" : {
                                                "patientGender" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "patientAgeGroup" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "task" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "serviceDeliveryLocation" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "encounterType" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "performerLanguage" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "performerDiscipline" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "performerKnowledgeUserType" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "informationRecipientLanguage" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "informationRecipientDiscipline" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "informationRecipientUserType" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "conceptOfInterest" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement",
                                                    "properties" : {
                                                        "matchingDomain" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain",
                                                            "properties" : {
                                                                "enumeration" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:MatchingDomain:Enumeration",
                                                                    "properties" : {
                                                                        "code" : {
                                                                            "type" : "array",
                                                                            "items" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                "properties" : {
                                                                                    "code" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystem" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "codeSystemName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "displayName" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            }
                                                                        },
                                                                        "includeDescendants" : {
                                                                            "type" : "boolean"
                                                                        }
                                                                    }
                                                                },
                                                                "externalValueSet" : {
                                                                    "type" : "array",
                                                                    "items" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                                        "properties" : {
                                                                            "id" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "name" : {
                                                                                "type" : "string"
                                                                            },
                                                                            "namespace" : {
                                                                                "type" : "string"
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        "searchParameter" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CodedContextElement:SearchParameter",
                                                            "properties" : {
                                                                "syntaxOnResource" : {
                                                                    "type" : "object",
                                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                    "properties" : {
                                                                        "valuePrefix" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "nonHl7CompliantName" : {
                                                                            "type" : "string"
                                                                        },
                                                                        "valueSuffix" : {
                                                                            "type" : "string"
                                                                        }
                                                                    }
                                                                },
                                                                "source" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputCodeTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "outputDisplayNameTransformation" : {
                                                            "type" : "object",
                                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Id",
                                                            "properties" : {
                                                                "id" : {
                                                                    "type" : "string"
                                                                },
                                                                "name" : {
                                                                    "type" : "string"
                                                                },
                                                                "namespace" : {
                                                                    "type" : "string"
                                                                }
                                                            }
                                                        },
                                                        "match" : {
                                                            "type" : "boolean"
                                                        },
                                                        "search" : {
                                                            "type" : "boolean"
                                                        }
                                                    }
                                                },
                                                "subTopics" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SubTopics",
                                                    "properties" : {
                                                        "subTopic" : {
                                                            "type" : "array",
                                                            "items" : {
                                                                "type" : "object",
                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SubTopic",
                                                                "properties" : {
                                                                    "searchParameter" : {
                                                                        "type" : "object",
                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SubTopic:SearchParameter",
                                                                        "properties" : {
                                                                            "valueSource" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SubTopic:SearchParameter:ValueSource",
                                                                                "properties" : {
                                                                                    "searchCode" : {
                                                                                        "type" : "object",
                                                                                        "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:CD",
                                                                                        "properties" : {
                                                                                            "code" : {
                                                                                                "type" : "object",
                                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:Code",
                                                                                                "properties" : {
                                                                                                    "code" : {
                                                                                                        "type" : "string"
                                                                                                    },
                                                                                                    "codeSystem" : {
                                                                                                        "type" : "string"
                                                                                                    },
                                                                                                    "codeSystemName" : {
                                                                                                        "type" : "string"
                                                                                                    },
                                                                                                    "displayName" : {
                                                                                                        "type" : "string"
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    },
                                                                                    "searchTerm" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                }
                                                                            },
                                                                            "syntaxOnResource" : {
                                                                                "type" : "object",
                                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:SyntaxOnResource",
                                                                                "properties" : {
                                                                                    "valuePrefix" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "nonHl7CompliantName" : {
                                                                                        "type" : "string"
                                                                                    },
                                                                                    "valueSuffix" : {
                                                                                        "type" : "string"
                                                                                    }
                                                                                },
                                                                                "source" : {
                                                                                    "type" : "string"
                                                                                }
                                                                            }
                                                                        }
                                                                    },
                                                                    "linkName" : {
                                                                        "type" : "string"
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        },
                                        "knowledgeRequestService" : {
                                            "type" : "object",
                                            "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeRequestService",
                                            "properties" : {
                                                "knowledgeRequestServiceLocation" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeRequestServiceLocation",
                                                    "properties" : {
                                                        "url" : {
                                                            "type" : "string"
                                                        }
                                                    }
                                                },
                                                "attributes" : {
                                                    "type" : "object",
                                                    "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeRequestService:Attributes",
                                                    "properties" : {
                                                        "attribute" : {
                                                            "type" : "array",
                                                            "items" : {
                                                                "type" : "object",
                                                                "id" : "urn:jsonschema:org:openinfobutton:schemas:kb:KnowledgeRequestService:Attributes:Attribute",
                                                                "properties" : {
                                                                    "name" : {
                                                                        "type" : "string"
                                                                    },
                                                                    "value" : {
                                                                        "type" : "string"
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        },
                                        "id" : {
                                            "type" : "string"
                                        },
                                        "name" : {
                                            "type" : "string"
                                        }
                                    }
                                }
                            }
                        }
                    },
                    "hl7URLCompliant" : {
                        "type" : "boolean"
                    },
                    "hl7KnowledgeResponseCompliant" : {
                        "type" : "boolean"
                    },
                    "urlStyle" : {
                        "type" : "string"
                    }
                }
            }
        }
    };

    var jsonProfileForm = [
        {
            "key" : "header",
            "title" : "Header",
            "items" : [
                {
                    "key" : "header.title",
                    "title" : "Title"
                },
                {
                    "key" : "header.profileDescription",
                    "title" : "Profile Description"
                }
            ]
        },
        {
            "key" : "profileDefinition",
            "title" : "Profile Definition",
            "items" : [
                {
                    "key" : "profileDefinition.supportedTerminologies",
                    "title" : "Supported Terminologies",
                    "items" : [
                        {
                            "type": "fieldset",
                            "items" : [
                                {
                                    "key": "supportedTerminology",
                                    "type"  : "select",
                                    "description" : "Select terminology to add to profile",
                                    "titleMap": [{"name": "HL7 ActCode", "value" : {"id" : "2.16.840.1.113883.5.4", "name": "HL7 ActCode", "namespace" : ""}},
                                        {"name": "ICD9-CM", "value" : {"id" : "2.16.840.1.113883.6.103", "name": "ICD9-CM", "namespace" : ""}},
                                        {"name": "ICD10-CM", "value" : {"id" : "2.16.840.1.113883.6.103", "name": "ICD10-CM", "namespace" : ""}},
                                        {"name": "ICD10", "value" : {"id" : "2.16.840.1.113883.6.3", "name" : "ICD10", "namespace" : ""}},
                                        {"name": "SNOMED-CT", "value" : {"id" : "2.16.840.1.113883.6.96", "name" : "SNOMED-CT", "namespace" : ""}},
                                        {"name": "RxNorm", "value" : {"id" : "2.16.840.1.113883.6.88", "name" : "RxNorm"}},
                                        {"name": "HL7 AdminstrativeGender", "value": {"id" : "2.16.840.1.113883.5.1", "name" : "HL7 AdministrativeGender", "namespace" : ""}},
                                        {"name" : "MeSH" , "value" : {"id" : "2.16.840.1.113883.6.177", "name" : "MeSH", "namespace" : ""}},
                                        {"name" : "NDC", "value" : {"id" : "2.16.840.1.113883.6.69", "name" : "NDC", "namespace" : ""}},
                                        {"name" : "NUCC Health Care provider taxonomy", "value" : {"id" : "2.16.840.1.113883.6.101", "name" : "NUCC Health Care provider taxonomy", "namespace" : ""}},
                                        {"name" : "ietf3066", "value" : {"id" : "2.16.840.1.113883.6.121", "name" : "ietf3066", "namespace" : ""}},
                                        {"name" : "LOINC", "value" : {"id" : "2.16.840.1.113883.6.1", "name" : "LOINC", "namespace" : ""}},
                                        {"name" : "ObservationInterpretation", "value" : {"id" : "2.16.840.1.113883.5.83", "name" : "ObservationInterpretation", "namespace" : ""}},
                                        {"name" : "ISO 3166 Part 1 Country Codes, 2nd Edition, Alpha-3", "value" : {"id" : "1.0.3166.1.2.3", "name" : "ISO 3166 Part 1 Country Codes, 2nd Edition, Alpha-3", "namespace" : ""}}],
                                    "onChange" : function(modelValue,form) {

                                        $scope.jsonProfileModel.profileDefinition.supportedTerminologies.supportedTerminology.unshift(modelValue);
                                    }
                                }
                            ]
                        },
                        {
                            "key" : "profileDefinition.supportedTerminologies.supportedTerminology",
                            "add" : "Add Terminology",
                            "title" : "Terminology",
                            "items" : [
                                {
                                    "key" : "profileDefinition.supportedTerminologies.supportedTerminology[].id",
                                    "title" : "ID"
                                },
                                {
                                    "key": "profileDefinition.supportedTerminologies.supportedTerminology[].name",
                                    "title" : "Name"
                                },
                                {
                                    "key" : "profileDefinition.supportedTerminologies.supportedTerminology[].namespace",
                                    "title" : "Namespace"
                                }
                            ]
                        }
                    ]
                },
                {
                    "key" : "profileDefinition.contexts",
                    "title" : "Contexts",
                    "items" : [
                        {
                            "key" : "profileDefinition.contexts.context",
                            "title" : "Context",
                            "items" : [
                                {
                                    "key" : "profileDefinition.contexts.context[].contextDescription",
                                    "title" : "Context Description"
                                },
                                {
                                    "key" : "profileDefinition.contexts.context[].id",
                                    "title" : "ID"
                                },
                                {
                                    "key" : "profileDefinition.contexts.context[].knowledgeRequestService",
                                    "title" : "Resource Service Configuration",
                                    "items" : [
                                        {
                                            "key" : "profileDefinition.contexts.context[].knowledgeRequestService.knowledgeRequestServiceLocation",
                                            "title" : "",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].knowledgeRequestService.knowledgeRequestServiceLocation.url",
                                                    "title" : "URL"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].knowledgeRequestService.attributes",
                                            "title" : "URL Parameters",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].knowledgeRequestService.attributes.attribute",
                                                    "title" : "Parameter",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].knowledgeRequestService.attributes.attribute[].name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].knowledgeRequestService.attributes.attribute[].value",
                                                            "title" : "Value"
                                                        }
                                                    ]
                                                }
                                            ]
                                        }
                                    ]
                                },
                                {
                                    "key" : "profileDefinition.contexts.context[].contextDefinition",
                                    "title" : "Matching Context Definitions",
                                    "items" : [
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task",
                                            "title" : "Task Context",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.task.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.task.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.task.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.task.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest",
                                            "title" : "Concept of Interest",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics",
                                            "title" : "Sub Topics",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic",
                                                    "title" : "Sub Topic",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource",
                                                                    "title" : "",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource.searchCode",
                                                                            "title" : "",
                                                                            "items" : [
                                                                                {
                                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource.searchCode.code",
                                                                                    "title" : "Coded Concepts",
                                                                                    "items" : [
                                                                                        {
                                                                                            "key": "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource.searchCode.code.code",
                                                                                            "title": "Code"
                                                                                        },
                                                                                        {
                                                                                            "key": "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource.searchCode.code.codeSystem",
                                                                                            "title": "Code System"
                                                                                        },
                                                                                        {
                                                                                            "key": "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource.searchCode.code.codeSystemName",
                                                                                            "title": "Code System Name"
                                                                                        },
                                                                                        {
                                                                                            "key": "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource.searchCode.code.displayName",
                                                                                            "title": "Display Name"
                                                                                        }
                                                                                    ]
                                                                                }
                                                                            ]
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.syntaxOnResource",
                                                                    "title" : "Syntax On Resource",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.syntaxOnResource.valuePrefix",
                                                                            "title" : "Prefix"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                            "title" : "non-HL7 Compliant Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.syntaxOnResource.valueSuffix",
                                                                            "title" : "Suffix"
                                                                        }
                                                                    ]
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].linkName",
                                                            "title" : "Link Name"
                                                        }
                                                    ]
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender",
                                            "title" : "Gender",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.patientGender.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.patientGender.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup",
                                            "title" : "Age",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType",
                                            "title" : "Encounter",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.encounterType.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.encounterType.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage",
                                            "title" : "Performer Language",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline",
                                            "title" : "Performer Discipline",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType",
                                            "title" : "Performer Type",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage",
                                            "title" : "Information Recipient Language",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline",
                                            "title" : "Information Recipient Discipline",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        },
                                        {
                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType",
                                            "title" : "Information Recipient Type",
                                            "items" : [
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration",
                                                            "title" : "",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration.code",
                                                                    "title" : "Coded Concepts",
                                                                    "items" : [
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration.code[].code",
                                                                            "title" : "Code"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration.code[].codeSystem",
                                                                            "title" : "Code System"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration.code[].codeSystemName",
                                                                            "title" : "Code System Name"
                                                                        },
                                                                        {
                                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration.code[].displayName",
                                                                            "title" : "Display Name"
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration.includeDescendants",
                                                                    "title" : "Include Descendants"
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.externalValueSet",
                                                            "title" : "External Value Set",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.externalValueSet[].id",
                                                                    "title" : "ID"
                                                                },
                                                                {
                                                                    "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.externalValueSet[].name",
                                                                    "title" : "Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.externalValueSet[].namespace",
                                                                    "title" : "Namespace"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.searchParameter",
                                                    "title" : "",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.searchParameter.syntaxOnResource",
                                                            "title" : "Syntax On Resource",
                                                            "items" : [
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.searchParameter.syntaxOnResource.valuePrefix",
                                                                    "title" : "Prefix"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.searchParameter.syntaxOnResource.nonHl7CompliantName",
                                                                    "title" : "non-HL7 Compliant Name"
                                                                },
                                                                {
                                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.searchParameter.syntaxOnResource.valueSuffix",
                                                                    "title" : "Suffix"
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputCodeTransformation",
                                                    "title" : "Output Code Transformation",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputCodeTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputCodeTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputCodeTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputDisplayNameTransformation",
                                                    "title" : "Output Code Display Name",
                                                    "items" : [
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputDisplayNameTransformation.id",
                                                            "title" : "ID"
                                                        },
                                                        {
                                                            "key": "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputDisplayNameTransformation.name",
                                                            "title" : "Name"
                                                        },
                                                        {
                                                            "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.outputDisplayNameTransformation.namespace",
                                                            "title" : "Namespace"
                                                        }
                                                    ]
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.match",
                                                    "title" : "Use For Matching"
                                                },
                                                {
                                                    "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.search",
                                                    "title" : "Use For Searching"
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "key" : "profileDefinition.hl7URLCompliant",
                    "title" : "HL7 URL Compliant"
                },
                {
                    "key" : "profileDefinition.hl7KnowledgeResponseCompliant",
                    "title" : "HL7 Knowledge Response Compliant"
                },
                {
                    "key" : "profileDefinition.urlStyle",
                    "title" : "URL Style"
                }
            ]
        },
        {
            type: "submit",
            title: "Save"
        }
    ];

    var codeSystems = [{"name": "HL7 ActCode", "oid" : "2.16.840.1.113883.5.4"},
        {"name": "ICD9-CM", "oid" : "2.16.840.1.113883.6.103"},
        {"name": "ICD10-CM", "oid" : "2.16.840.1.113883.6.90"},
        {"name": "ICD10", "oid" : "2.16.840.1.113883.6.3"},
        {"name": "SNOMED-CT", "oid" : "2.16.840.1.113883.6.96"},
        {"name": "RxNorm", "oid" : "2.16.840.1.113883.6.88"},
        {"name": "HL7 AdminstrativeGender", "oid": "2.16.840.1.113883.5.1"},
        {"name" : "MeSH" , "oid" : "2.16.840.1.113883.6.177"},
        {"name" : "NDC", "oid" : "2.16.840.1.113883.6.69"},
        {"name" : "NUCC Health Care provider taxonomy", "oid" : "2.16.840.1.113883.6.101"},
        {"name" : "ietf3066", "oid" : "2.16.840.1.113883.6.121"},
        {"name" : "LOINC", "oid" : "2.16.840.1.113883.6.1"},
        {"name" : "ObservationInterpretation", "oid" : "2.16.840.1.113883.5.83"},
        {"name" : "ISO 3166 Part 1 Country Codes, 2nd Edition, Alpha-3 ", "oid" : "1.0.3166.1.2.3"}];

    var mainSearchCodes = [{"name": "ICD9-CM", "oid" : "2.16.840.1.113883.6.103"},
        {"name": "ICD10-CM", "oid" : "2.16.840.1.113883.6.90"},
        {"name": "ICD10", "oid" : "2.16.840.1.113883.6.3"},
        {"name": "SNOMED-CT", "oid" : "2.16.840.1.113883.6.96"},
        {"name": "RxNorm", "oid" : "2.16.840.1.113883.6.88"},
        {"name" : "MeSH" , "oid" : "2.16.840.1.113883.6.177"},
        {"name" : "LOINC", "oid" : "2.16.840.1.113883.6.1"},
        {"name" : "CPT", "oid": "2.16.840.1.113883.6.12"},
        {"name" : "CDS Rules", "oid": "http://socraticgrid.org/cds/ka/ecarule"}]

    var genderCodes= [{"displayName" : "Female", "code" : "F", "id": "1a"},
        {"displayName" : "Male", "code" : "M", "id": "2a"},
        {"displayName" : "Undifferentiated", "code" : "UN", "id": "3a"}];

    var ageCodes= [{"displayName" : "infant, newborn; birth to 1 month", "code" : "D007231", "id": '1b'},
        {"displayName" : "Infant; 1 to 23 months", "code" : "D007223", "id": "2b"},
        {"displayName" : "child, preschool; 2 to 5 years", "code" : "D002675", "id": "3b"},
        {"displayName" : "child; 6 to 12 years", "code" : "D002648", "id": "4b"},
        {"displayName" : "adolescent; 13-18 years", "code" : "D000293", "id": "5b"},
        {"displayName" : "young adult; 19-24 years", "code" : "D055815", "id": "6b"},
        {"displayName" : "adult; 19-44 years", "code" : "D000293", "id": "7b"},
        {"displayName" : "aged; 56-79 years", "code" : "D000368", "id": "8b"},
        {"displayName" : "middle aged; 45-64 years", "code" : "D008875", "id": "9b"},
        {"displayName" : "aged, 80 and older; a person 80 years of age and older", "code" : "D000369", "id": "10b"}];

    var taskCodes = [{"displayName" : "order entry", "code" : "OE", "id": "1c"},
        {"displayName" : "laboratory test order entry", "code" : "LABOE", "id": "2c"},
        {"displayName" : "medication order entry", "code" : "MEDOE", "id": "3c"},
        {"displayName" : "patient documentation", "code" : "PATDOC", "id": "4c"},
        {"displayName" : "clinical note entry", "code" : "CLINNOTEE", "id": "5c"},
        {"displayName" : "diagnosis list entry", "code" : "DIAGLISTE", "id": "6c"},
        {"displayName" : "discharge summary entry", "code" : "DISCHSUME", "id": "7c"},
        {"displayName" : "Patient education entry", "code" : "PATEDUE", "id": "8c"},
        {"displayName" : "Discharge instruction entry", "code" : "DISCHINSTE", "id": "9c"},
        {"displayName" : "pathology report entry", "code" : "PATREPE", "id": "10c"},
        {"displayName" : "problem list entry", "code" : "PROBLISTE", "id": "11c"},
        {"displayName" : "reminder list entry", "code" : "REMLE", "id": "12c"},
        {"displayName" : "wellness reminder list entry", "code" : "WELLREMLE", "id": "13c"},
        {"displayName" : "patient information review", "code" : "PATINFO", "id": "14c"},
        {"displayName" : "allergy list entry", "code" : "ALLERLE", "id": "15c"},
        {"displayName" : "clinical note review", "code" : "CLINNOTEREV", "id": "16c"},
        {"displayName" : "discharge summary review", "code" : "DISCHSUMREV", "id": "17c"},
        {"displayName" : "diagnosis list review", "code" : "DIAGLISTREV", "id": "18c"},
        {"displayName" : "immunization list entry", "code" : "IMMLE", "id": "19c"},
        {"displayName" : "labratory results review", "code" : "LABRREV", "id": "20c"},
        {"displayName" : "microbiology results review", "code" : "MICRORREV", "id": "21c"},
        {"displayName" : "microbiology organisms results review", "code" : "MICROORGRREV", "id": "22c"},
        {"displayName" : "microbiology sensitivity test results review", "code" : "MICROSENSRREV", "id": "23c"},
        {"displayName" : "medication list review", "code" : "MLREV", "id": "24c"},
        {"displayName" : "medication administration record work list review", "code" : "MARWLREV", "id": "25c"},
        {"displayName" : "orders review", "code" : "OREV", "id": "26c"},
        {"displayName" : "pathology report review", "code" : "OREV", "id": "27c"},
        {"displayName" : "problem list review", "code" : "PROBLISTREV", "id": "28c"},
        {"displayName" : "radiology report review", "code" : "RADREPREV", "id": "29c"},
        {"displayName" : "immunization list review", "code" : "IMMLREV", "id": "30c"},
        {"displayName" : "reminder list review", "code": "REMLREV", "id": "31c"},
        {"displayName" : "wellness reminder list review", "code" : "WELLREMLREV", "id": "32c"},
        {"displayName" : "risk assessment instrument", "code" : "RISKASSESS", "id": "33c"},
        {"displayName" : "falls risk assessment instrument", "code" : "FALLRISK", "id": "34c"},
        {"displayName" : "CDS Review" , "code" : "CDSREV", "id" : "35c"}];

    var encounterCodes = [{"displayName" : "Ambulatory", "code" : "AMB", "id": "1d"},
        {"displayName" : "Emergency", "code" : "EMER", "id": "2d"},
        {"displayName" : "Field", "code" : "FLD", "id": "3d"},
        {"displayName" : "Home health", "code" : "HH", "id": "4d"},
        {"displayName" : "Inpatient encounter", "code" : "IMP", "id": "5d"},
        {"displayName" : "Inpatient acute", "code" : "ACUTE", "id": "6d"},
        {"displayName" : "Inpatient non-acute", "code" : "NONAC", "id": "7d"},
        {"displayName" : "short stay", "code" : "SS", "id": "8d"},
        {"displayName" : "virtual", "code" : "VR", "id": "9d"}];

    var observationCodes = [{"displayName" : "Abnormal", "code" : "A", "id": "1e"},
        {"displayName" : "Abnormal alert", "code" : "AA", "id": "2e"},
        {"displayName" : "High", "code" : "H", "id": "3e"},
        {"displayName" : "High alert", "code" : "HH", "id": "4e"},
        {"displayName" : "Low", "code" : "L", "id": "5e"},
        {"displayName" : "Low alert", "code" : "LL", "id": "6e"},
        {"displayName" : "Normal", "code" : "N", "id": "7e"}];

    var subtopicCodes = [{"displayName" : "administration & dosage", "code" : "Q000008", "id": "1f"},
        {"displayName" : "contraindications", "code" : "Q000744", "id": "2f"},
        {"displayName" : "adverse effects", "code" : "Q000009", "id": "3f"},
        {"displayName" : "drug interaction", "code" : "D004347", "id": "4f"},
        {"displayName" : "classification", "code" : "Q000145", "id": "5f"},
        {"displayName" : "etiology", "code" : "Q000209", "id": "6f"},
        {"displayName" : "diagnosis", "code" : "Q000175", "id": "7f"},
        {"displayName" : "therapy", "code" : "Q000628", "id": "8f"},
        {"displayName" : "prognosis", "code" : "D011379", "id": "9f"},
        {"displayName" : "therapeutic use", "code" : "Q000627", "id": "10f"},
        {"displayName" : "pharmacokinetics", "code" : "Q000493", "id": "11f"},
        {"displayName" : "pharmacology", "code" : "Q000494", "id": "12f"},
        {"displayName" : "toxicity", "code" : "Q000633", "id": "13f"},
        {"displayName" : "poisoning", "code" : "Q000506", "id": "14f"},
        {"displayName" : "Drug interaction", "code" : "79899007", "id": "15f"},
        {"displayName" : "Differential diagnosis", "code" : "47965005", "id": "16f"},
        {"displayName" : "Drug interaction with drug", "code" : "404204005", "id": "17f"},
        {"displayName" : "Drug interaction with food", "code" : "95907004", "id": "18f"},
        {"displayName" : "Drug interaction with alcohol", "code" : "95906008", "id": "19f"}];

    var performerAndInfoRecipCodes = [{"displayName" : "Healthcare Provider", "code" : "PROV", "id": "1g"},
        {"displayName" : "Patient", "code" : "PAT", "id": "2g"}];

    $scope.properties = [{"name": "Task Context", "propName" : "taskContext.c", "codeSystem" : codeSystems[0], "codes": taskCodes},
        {"name": "Gender", "propName" : "administrativeGenderCode.c", "codeSystem" : codeSystems[6], "codes": genderCodes},
        {"name": "Age Groups", "propName" : "ageGroup.v", "codeSystem" : codeSystems[7], "codes": ageCodes},
        {"name": "Encounter", "propName" : "encounter.c", "codeSystem" : codeSystems[0], "codes": encounterCodes},
        {"name": "Performer Language", "propName" : "performer.languageCode.c", "codeSystem" : codeSystems[10], "codes": {"displayName" : "", "code" : ""}},
        {"name": "Information Recipient Language", "propName" : "informationRecipient.languageCode.c", "codeSystem" : codeSystems[10], "codes": {"displayName" : "", "code" : ""}},
        {"name": "Performer", "propName" : "performer", "codeSystem" : codeSystems[9], "codes": performerAndInfoRecipCodes},
        {"name": "Information Recipient", "propName" : "informationRecipient", "codeSystem" : codeSystems[9], "codes": performerAndInfoRecipCodes},
        {"name": "Severity Observation", "propName" : "severityObservation.interpretationCode.c", "codeSystem" : codeSystems[12], "codes": observationCodes},
        {"name": "Sub Topic", "propName" : "subTopic.v", "codeSystem" : [codeSystems[7]], "codes": subtopicCodes},
        {"name": "Main Search Criteria", "propName" : "mainSearchCriteria.v", "codeSystem" : mainSearchCodes, "codes" : {"displayName" : "", "code" : ""}}];

        loadProfile();

        //$scope.jsonProfileModel = {"header":{"title":"Medical Home Portal","profileDescription":"Information for children with special healthcare needs. Developed and maintained by the University of Utah.","versionControl":{"publicationDate":1420614000000},"id":1},"profileDefinition":{"authorizedOrganizations":{"authorizedOrganization":[]},"supportedTerminologies":{"supportedTerminology":[{"id":"2.16.840.1.113883.6.103","name":"ICD9-CM","namespace":null}]},"contexts":{"context":[{"contextDescription":null,"contextDefinition":{"patientGender":null,"patientAgeGroup":{"matchingDomain":{"enumeration":{"code":[{"code":"D007231","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D007223","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D002675","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D002648","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D000293","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null}],"includeDescendants":false},"externalValueSet":[]},"searchParameter":null,"outputCodeTransformation":null,"outputDisplayNameTransformation":null,"match":true,"search":false},"task":{"matchingDomain":{"enumeration":{"code":[{"code":"PROBLISTREV","codeSystem":"2.16.840.1.113883.5.4","codeSystemName":null,"displayName":"problem list review task"},{"code":"PROBLISTE","codeSystem":"2.16.840.1.113883.5.4","codeSystemName":null,"displayName":"problem list entry task"}],"includeDescendants":false},"externalValueSet":[]},"searchParameter":null,"outputCodeTransformation":null,"outputDisplayNameTransformation":null,"match":true,"search":false},"serviceDeliveryLocation":[],"encounterType":null,"performerLanguage":null,"performerDiscipline":null,"performerKnowledgeUserType":null,"informationRecipientLanguage":null,"informationRecipientDiscipline":null,"informationRecipientUserType":null,"conceptOfInterest":{"matchingDomain":{"enumeration":{"code":[{"code":"317","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mild mental retardation "},{"code":"318","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Other specified mental retardation "},{"code":"277.5","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mucopolysaccharidosis (all types)"},{"code":"759.89","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Angelman syndrome "},{"code":"307.23","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Tourette syndrome "},{"code":"758.0","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Down syndrome"},{"code":"277.85","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Disorders of fatty acid oxidation "},{"code":"359.1","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"hereditary progressive muscular dystrophy (Duchenne and Becker Muscular Dystrophy)"},{"code":"741","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Spina bifida (Neural Tube Defects)"},{"code":"343","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Cerebral palsy "},{"code":"579.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"celiac disease "},{"code":"952","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"spinal cord injury "},{"code":"907.0","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Late effect of intracranial injury"},{"code":"330.8","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Rett syndrome"},{"code":"759.83","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Fragile X syndrome "},{"code":"237.7","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Neurofibromatosis"},{"code":"345.6","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Infantile spasms "},{"code":"555","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Regional Enteritis (IBD)"},{"code":"556","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Ulcerative Enterocolitis (IBD)"},{"code":"359.21","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"myotonic muscular dystrophy type 1"},{"code":"359.22","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"myotonic muscular dystrophy type 2"},{"code":"317","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mental Retardation (MR), mild "},{"code":"318.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, moderate"},{"code":"318.1","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, severe "},{"code":"318.2","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, profound "},{"code":"319","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, NOS "},{"code":"299.0","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Autistic disorder, Infantile autism, Primary autism "},{"code":"299.9","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Pervasive developmental disorder NOS"},{"code":"299.8","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Other pervasive developmental disorders (Asperger disorder) "},{"code":"296","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Major Depressive Disorder. Fourth and fifth digits required, see explanation below"},{"code":"300.4","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Dysthymic Disorder "},{"code":"311","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Depressive Disorder NOS "},{"code":"296.90 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mood Disorder NOS "},{"code":"309.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Adjustment Disorder with Depressed Mood "},{"code":"309.28","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Adjustment Disorder with Mixed Anxious and Depressed Mood "},{"code":"758.9","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Conditions due to anomaly of unspecified chromosome (Cornelia de Lange Syndrome"},{"code":"759.81","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Prader-Willi syndrome"},{"code":"335","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Spinal muscular atrophy, unspecified "},{"code":"493","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Asthma "},{"code":"314.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Attention deficit disorder "}],"includeDescendants":false},"externalValueSet":[]},"searchParameter":{"syntaxOnResource":{"valuePrefix":null,"nonHl7CompliantName":"q","valueSuffix":"+site:www.medicalhomeportal.org/diagnoses-and-conditions/"},"source":"displayName"},"outputCodeTransformation":null,"outputDisplayNameTransformation":null,"match":false,"search":true},"subTopics":{"subTopic":[{"searchParameter":null,"linkName":"Disease Module"}]}},"knowledgeRequestService":{"knowledgeRequestServiceLocation":{"url":"http://www.google.com/search?hl=en&btnI=Im+Feeling+Lucky&"},"attributes":null},"id":"1","name":"Access to disease modules from problem list review and entry. Pediatric population."}]},"hl7URLCompliant":false,"hl7KnowledgeResponseCompliant":false,"urlStyle":"DIRTY"}};

        function loadProfile () {
            if ($stateParams.id) {
                profileFactory.getProfile($stateParams.id)
                    .success(function (profile) {
                        profile.status = profile.status.toString();
                        $scope.profile = profile;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load local profile ' + $stateParams.id + ': ' + error;
                    });
                profileFactory.getJSONProfile($stateParams.id)
                    .success(function (jsonProfile) {
                        $scope.jsonProfileSchema = jsonProfileSchema;
                        $scope.jsonProfileForm = jsonProfileForm;
                        $scope.jsonProfileModel = jsonProfile;
                    });
            }
            else {

                $scope.new = true;
                $scope.profile = {id: null, name: null, version: "1", published: null, status: 3, content: "", imageUrl: null}
                $scope.jsonProfileSchema = {};
                $scope.jsonProfileForm = [];
                $scope.jsonProfileModel = {};
            }
        }

        $scope.clearDb = function () {

        };

        $scope.clearForm = function (profile) {
            $scope.profile = {};
        
        };

        $scope.create = function (profile) {
            
            profileFactory.insertProfile(profile)
                    .success(function (msg) {                        
                        $scope.statusMessage = msg.object + ' ' + msg.event;
                    })
                    .error(function (error) {
                        $scope.statusMessage = 'Unable to save profile:' + error;
                    });
            
        };

        $scope.update = function (profile) {

            profile.published = new Date();
            profileFactory.insertProfile(profile)
                .success(function (msg) {
                    $scope.statusMessage = 'Profile Successfully Updated';
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to save profile:' + error;
                });
        };

        $scope.insert = function (profile) {
            profileFactory.insertProfile(profile)
                .success(function (profile) {
                    $scope.statusMessage = 'Profile Successfully Created';
                    $stateParams.id = profile;
                    $state.reload();
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to create profile:' + error;
                });
        };

        $scope.delete = function (profile) {
            alert("delete profile!");
        };

    $scope.onJSONProfileSubmit = function(form) {

            profileFactory.updateProfileContent($scope.jsonProfileModel, $stateParams.id)
                .success(function (response) {
                    $scope.statusMessage = 'Profile Successfully Updated';
                    $scope.profile.content = response;
                })
                .error(function (error) {
                    $scope.statusMessage = 'Unable to update profile:' + error;
                });
    }

    return $scope;
    }]);

oibManagerModule.controller('CloudProfileCtrl', ['$scope', '$uibModal','$http', '$state', 'base64', 'cloudProfileFactory', function ($scope, $uibModal, $http, $state, base64, cloudProfileFactory) {

    $scope.repoUrl = 'https://github.com/' + 'VHAINNOVATIONS/InfoButtons' + '/blob/development/' + 'profilestore' + '/';

    var cloudProfileLinks = [];

    cloudProfileLinks = cloudProfileFactory.getCloudProfiles(base64);

    getLocalCloudProfiles();

    function getLocalCloudProfiles() {
        cloudProfileFactory.getLocalCloudProfiles()
            .success(function (profiles) {
                profiles.forEach (function (profile) {

                    var xmlDoc = $.parseXML(profile.content);
                    var $xml = $(xmlDoc);
                    var $profileD = $xml.find("profileDescription");
                    profile.profileDescription = $profileD.text();
                });
                $scope.localCloudProfiles = profiles;
            })
            .error(function (error) {
                $scope.status = 'Unable to load local profiles: ' + error;
            });
    }

    $scope.cloudProfileLinks = cloudProfileLinks;

   function downloadProfile (profile, oids) {
        cloudProfileFactory.downloadProfile(profile, oids)
            .success(function (msg) {
                $scope.statusMessage = msg.object + ' ' + msg.event;
                $state.reload();
            })
            .error(function (error) {
                $scope.statusMessage = 'Unable to download profile:' + error;
                $state.reload();
            });
    }

    function changeOids (profile, oids) {
        cloudProfileFactory.changeOids(profile, oids)
            .success(function (msg) {
                $scope.statusMessage = msg.object + ' ' + msg.event;
                $state.reload();
            })
            .error(function (error) {
                $scope.statusMessage = 'Unable to update profile oids:' + error;
                $state.reload();
            });
    }

    $scope.update = function (profile) {
        cloudProfileFactory.updateProfile(profile, $scope.cloudProfileLinks);
        confirm();
    };

    $scope.updateStatus = function (profile, status) {

        profile.status = status;
        cloudProfileFactory.updateStatus(profile);
    };

    $scope.notInstalled = function (localCloudProfiles) {

        return function (cloudProfileLink) {
            var x = true;
            localCloudProfiles.forEach(function (localProfile) {

                if (localProfile.name === cloudProfileLink.title) {
                    x = false;
                }
            });
            return x;
        }
    };

    $scope.isUpdated = function () {

        return function (localCloudProfile) {
            var x = true;
            cloudProfileLinks.forEach(function (cloudProfileLink) {

                if (localCloudProfile.name === cloudProfileLink.title) {
                    if (localCloudProfile.version != cloudProfileLink.sha || localCloudProfile.imageUrl != cloudProfileLink.imgUrl)
                    x = false;
                }
            });
            return x;
        }
    };

    $scope.needsUpdate = function () {

        return function (localCloudProfile) {
            var x = false;
            cloudProfileLinks.forEach(function (cloudProfileLink) {

                if (localCloudProfile.name === cloudProfileLink.title) {
                    if (localCloudProfile.version != cloudProfileLink.sha || localCloudProfile.imageUrl != cloudProfileLink.imgUrl)
                        x = true;
                }
            });
            return x;
        }
    };

    var oids = [];
    oids.push({});

    $scope.items = JSON.parse(localStorage.getItem("oids"));

    $scope.openModal = function(profile) {

        var modalInstance = $uibModal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalController',
            resolve: {
                items: function () {
                    return $scope.items;
                },
                selectedOids : function () {
                    return [];
                },
                edit: function () {

                    return false;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            downloadProfile(profile,selectedItem);
        }, function () {
            $scope.status ='Modal dismissed at: ' + new Date();
        });
    };

    $scope.editOids = function(profile) {

        var selectedOids = cloudProfileFactory.getOids(profile);
        var profileOids = angular.copy(selectedOids);
        var items = $scope.items;
        var uniqueItems = [];
        for (var i = 0; i < items.length; i++)
        {
            for (var c = 0; c < profileOids.length; c++)
            {
                if ((profileOids[c].orgOid != items[i].orgOid))
                {
                    if ((c + 1) == profileOids.length)
                    {
                        uniqueItems.push(items[i]);
                    }
                }
                else
                {
                    break;
                }
            }
        }
        if (profileOids.length  == 0) {

            profileOids = $scope.items;
        }
        else
        {
            for (var x = 0; x < uniqueItems.length; x++)
            {
                profileOids.push(uniqueItems[x]);
            }
        }
        var modalInstance = $uibModal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalController',
            resolve: {
                items: function () {
                    return profileOids;
                },
                selectedOids : function () {
                    return selectedOids;
                },
                edit: function () {

                    return true;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            changeOids(profile,selectedItem);
        }, function () {
            $scope.status ='Modal dismissed at: ' + new Date();
        });
    };

    function confirm() {

        var modalInstance = $uibModal.open({
            templateUrl: 'confirm.html',
            controller: 'ConfirmController'
        });

        modalInstance.result.then(
            function () {
                $state.reload();
        });
    }
}]);

    /**
     * Checklist-model
     * AngularJS directive for list of checkboxes
     */

    angular.module('checklist-model', [])
        .directive('checklistModel', ['$parse', '$compile', function($parse, $compile) {
            // contains
            function contains(arr, item, comparator) {
                if (angular.isArray(arr)) {
                    for (var i = arr.length; i--;) {
                        if (comparator(arr[i], item)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            // add
            function add(arr, item, comparator) {
                arr = angular.isArray(arr) ? arr : [];
                if(!contains(arr, item, comparator)) {
                    arr.push(item);
                }
                return arr;
            }

            // remove
            function remove(arr, item, comparator) {
                if (angular.isArray(arr)) {
                    for (var i = arr.length; i--;) {
                        if (comparator(arr[i], item)) {
                            arr.splice(i, 1);
                            break;
                        }
                    }
                }
                return arr;
            }

            // http://stackoverflow.com/a/19228302/1458162
            function postLinkFn(scope, elem, attrs) {
                // compile with `ng-model` pointing to `checked`
                $compile(elem)(scope);

                // getter / setter for original model
                var getter = $parse(attrs.checklistModel);
                var setter = getter.assign;
                var checklistChange = $parse(attrs.checklistChange);

                // value added to list
                var value = $parse(attrs.checklistValue)(scope.$parent);


                var comparator = angular.equals;

                if (attrs.hasOwnProperty('checklistComparator')){
                    comparator = $parse(attrs.checklistComparator)(scope.$parent);
                }

                // watch UI checked change
                scope.$watch('checked', function(newValue, oldValue) {
                    if (newValue === oldValue) {
                        return;
                    }
                    var current = getter(scope.$parent);
                    if (newValue === true) {
                        setter(scope.$parent, add(current, value, comparator));
                    } else {
                        setter(scope.$parent, remove(current, value, comparator));
                    }

                    if (checklistChange) {
                        checklistChange(scope);
                    }
                });

                // declare one function to be used for both $watch functions
                function setChecked(newArr, oldArr) {
                    scope.checked = contains(newArr, value, comparator);
                }

                // watch original model change
                // use the faster $watchCollection method if it's available
                if (angular.isFunction(scope.$parent.$watchCollection)) {
                    scope.$parent.$watchCollection(attrs.checklistModel, setChecked);
                } else {
                    scope.$parent.$watch(attrs.checklistModel, setChecked, true);
                }
            }

            return {
                restrict: 'A',
                priority: 1000,
                terminal: true,
                scope: true,
                compile: function(tElement, tAttrs) {
                    if (tElement[0].tagName !== 'INPUT' || tAttrs.type !== 'checkbox') {
                        throw 'checklist-model should be applied to `input[type="checkbox"]`.';
                    }

                    if (!tAttrs.checklistValue) {
                        throw 'You should provide `checklist-value`.';
                    }

                    // exclude recursion
                    tElement.removeAttr('checklist-model');

                    // local scope var storing individual checkbox model
                    tElement.attr('ng-model', 'checked');

                    return postLinkFn;
                }
            };
        }]);
