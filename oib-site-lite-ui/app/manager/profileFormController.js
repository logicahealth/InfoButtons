'use strict';

var oibProfileFormModule = angular.module('oibProfileFormModule', ['schemaForm']);

oibProfileFormModule.controller('ProfileFormController', ['$scope', function ($scope) {
        $scope.schema = {
            "id": "profile",
            "type": "object",
            "properties": {
                "header": {
                    "id": "header",
                    "type": "object",
                    "properties": {
                        "title": {
                            "id": "title",
                            "type": "string"
                        },
                        "profileDescription": {
                            "id": "profileDescription",
                            "type": "string"
                        },
                        "versionControl": {
                            "id": "versionControl",
                            "type": "object",
                            "properties": {
                                "publicationDate": {
                                    "id": "publicationDate",
                                    "type": "integer"
                                }
                            }
                        },
                        "id": {
                            "id": "id",
                            "type": "integer"
                        }
                    },
                    "required": [
                        "title",
                        "profileDescription",
                        "versionControl",
                        "id"
                    ]
                },
                "profileDefinition": {
                    "id": "profileDefinition",
                    "type": "object",
                    "properties": {
                        "authorizedOrganizations": {
                            "id": "authorizedOrganizations",
                            "type": "object",
                            "properties": {
                                "authorizedOrganization": {
                                    "id": "authorizedOrganization",
                                    "type": "string"
                                }
                            }
                        },
                        "supportedTerminologies": {
                            "id": "supportedTerminologies",
                            "type": "object",
                            "properties": {
                                "supportedTerminology": {
                                    "id": "supportedTerminology",
                                    "type": "string"
                                }
                            }
                        },
                        "contexts": {
                            "id": "contexts",
                            "type": "object",
                            "properties": {
                                "context": {
                                    "id": "context",
                                    "type": "string"
                                }
                            }
                        },
                        "hl7URLCompliant": {
                            "id": "hl7URLCompliant",
                            "type": "boolean"
                        },
                        "hl7KnowledgeResponseCompliant": {
                            "id": "hl7KnowledgeResponseCompliant",
                            "type": "boolean"
                        },
                        "urlStyle": {
                            "id": "urlStyle",
                            "type": "string"
                        }
                    }
                }
            },
            "required": [
                "header",
                "profileDefinition"
            ]
        };

        $scope.form = [
            "*"
        ];

        $scope.model = {};
    }]);