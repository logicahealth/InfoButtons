'use strict';

var oibProfileFormModule = angular.module('oibProfileFormModule', ['schemaForm']);

oibProfileFormModule.controller('ProfileFormController', ['$scope', function ($scope) {
        $scope.schema = {
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

        $scope.form = [
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
                                                "title" : "Service",
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
                                        "title" : "Context Definition",
                                        "items" : [
                                            {
                                                "key" : "profileDefinition.contexts.context[].contextDefinition.task",
                                                "title" : "Task Context",
                                                "items" : [
                                                    {
                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain",
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.task.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.conceptOfInterest.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                                                "title" : "Code",
                                                                                "items" : [
                                                                                    {
                                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.subTopics.subTopic[].searchParameter.valueSource.searchCode.code",
                                                                                        "title" : "",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.patientGender.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.patientAgeGroup.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.encounterType.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.performerLanguage.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.performerDiscipline.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.performerKnowledgeUserType.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientLanguage.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientDiscipline.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
                                                        "title" : "Matching Domain",
                                                        "items" : [
                                                            {
                                                                "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration",
                                                                "title" : "Codes",
                                                                "items" : [
                                                                    {
                                                                        "key" : "profileDefinition.contexts.context[].contextDefinition.informationRecipientUserType.matchingDomain.enumeration.code",
                                                                        "title" : "Code",
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
            }
        ];

        $scope.model = {"header":{"title":"Medical Home Portal","profileDescription":"Information for children with special healthcare needs. Developed and maintained by the University of Utah.","versionControl":{"publicationDate":1420614000000},"id":1},"profileDefinition":{"authorizedOrganizations":{"authorizedOrganization":[]},"supportedTerminologies":{"supportedTerminology":[{"id":"2.16.840.1.113883.6.103","name":"ICD9-CM","namespace":null}]},"contexts":{"context":[{"contextDescription":null,"contextDefinition":{"patientGender":null,"patientAgeGroup":{"matchingDomain":{"enumeration":{"code":[{"code":"D007231","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D007223","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D002675","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D002648","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null},{"code":"D000293","codeSystem":"2.16.840.1.113883.6.177","codeSystemName":null,"displayName":null}],"includeDescendants":false},"externalValueSet":[]},"searchParameter":null,"outputCodeTransformation":null,"outputDisplayNameTransformation":null,"match":true,"search":false},"task":{"matchingDomain":{"enumeration":{"code":[{"code":"PROBLISTREV","codeSystem":"2.16.840.1.113883.5.4","codeSystemName":null,"displayName":"problem list review task"},{"code":"PROBLISTE","codeSystem":"2.16.840.1.113883.5.4","codeSystemName":null,"displayName":"problem list entry task"}],"includeDescendants":false},"externalValueSet":[]},"searchParameter":null,"outputCodeTransformation":null,"outputDisplayNameTransformation":null,"match":true,"search":false},"serviceDeliveryLocation":[],"encounterType":null,"performerLanguage":null,"performerDiscipline":null,"performerKnowledgeUserType":null,"informationRecipientLanguage":null,"informationRecipientDiscipline":null,"informationRecipientUserType":null,"conceptOfInterest":{"matchingDomain":{"enumeration":{"code":[{"code":"317","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mild mental retardation "},{"code":"318","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Other specified mental retardation "},{"code":"277.5","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mucopolysaccharidosis (all types)"},{"code":"759.89","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Angelman syndrome "},{"code":"307.23","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Tourette syndrome "},{"code":"758.0","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Down syndrome"},{"code":"277.85","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Disorders of fatty acid oxidation "},{"code":"359.1","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"hereditary progressive muscular dystrophy (Duchenne and Becker Muscular Dystrophy)"},{"code":"741","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Spina bifida (Neural Tube Defects)"},{"code":"343","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Cerebral palsy "},{"code":"579.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"celiac disease "},{"code":"952","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"spinal cord injury "},{"code":"907.0","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Late effect of intracranial injury"},{"code":"330.8","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Rett syndrome"},{"code":"759.83","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Fragile X syndrome "},{"code":"237.7","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Neurofibromatosis"},{"code":"345.6","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Infantile spasms "},{"code":"555","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Regional Enteritis (IBD)"},{"code":"556","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Ulcerative Enterocolitis (IBD)"},{"code":"359.21","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"myotonic muscular dystrophy type 1"},{"code":"359.22","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"myotonic muscular dystrophy type 2"},{"code":"317","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mental Retardation (MR), mild "},{"code":"318.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, moderate"},{"code":"318.1","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, severe "},{"code":"318.2","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, profound "},{"code":"319","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"MR, NOS "},{"code":"299.0","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Autistic disorder, Infantile autism, Primary autism "},{"code":"299.9","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Pervasive developmental disorder NOS"},{"code":"299.8","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Other pervasive developmental disorders (Asperger disorder) "},{"code":"296","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Major Depressive Disorder. Fourth and fifth digits required, see explanation below"},{"code":"300.4","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Dysthymic Disorder "},{"code":"311","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Depressive Disorder NOS "},{"code":"296.90 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Mood Disorder NOS "},{"code":"309.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Adjustment Disorder with Depressed Mood "},{"code":"309.28","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Adjustment Disorder with Mixed Anxious and Depressed Mood "},{"code":"758.9","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Conditions due to anomaly of unspecified chromosome (Cornelia de Lange Syndrome"},{"code":"759.81","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Prader-Willi syndrome"},{"code":"335","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Spinal muscular atrophy, unspecified "},{"code":"493","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Asthma "},{"code":"314.0 ","codeSystem":"2.16.840.1.113883.6.103","codeSystemName":null,"displayName":"Attention deficit disorder "}],"includeDescendants":false},"externalValueSet":[]},"searchParameter":{"syntaxOnResource":{"valuePrefix":null,"nonHl7CompliantName":"q","valueSuffix":"+site:www.medicalhomeportal.org/diagnoses-and-conditions/"},"source":"displayName"},"outputCodeTransformation":null,"outputDisplayNameTransformation":null,"match":false,"search":true},"subTopics":{"subTopic":[{"searchParameter":null,"linkName":"Disease Module"}]}},"knowledgeRequestService":{"knowledgeRequestServiceLocation":{"url":"http://www.google.com/search?hl=en&btnI=Im+Feeling+Lucky&"},"attributes":null},"id":"1","name":"Access to disease modules from problem list review and entry. Pediatric population."}]},"hl7URLCompliant":false,"hl7KnowledgeResponseCompliant":false,"urlStyle":"DIRTY"}};
    }]);