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
            "*"
        ];

        $scope.model = {};
    }]);