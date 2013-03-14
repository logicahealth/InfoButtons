/* Sets up test data for core-data unit tests */
INSERT INTO subset (subsetid, description, internalconceptid, name) VALUES (1, 'Diabetes mellitus type 2 codes', 1, 'DIABETES_MELLITUS');
INSERT INTO concept (conceptid, code, codesystem, codesystemname, displayname) VALUES (1, '44054006','2.16.840.1.113883.6.96', 'SNOMED-CT', 'Diabetes mellitus type 2');
INSERT INTO concept (conceptid, code, codesystem, codesystemname, displayname) VALUES (2, '250.00', '2.16.840.1.113883.6.2', 'ICD9-CM', 'Diabetes mellitus without complication type ii or unspecified type not stated as uncontrolled');
INSERT INTO concept (conceptid, code, codesystem, codesystemname, displayname) VALUES (3, '250.01', '2.16.840.1.113883.6.2', 'ICD9-CM', 'Diabetes mellitus without complication type i not stated as uncontrolled');
INSERT INTO concept (conceptid, code, codesystem, codesystemname, displayname) VALUES (4, '250.02', '2.16.840.1.113883.6.2', 'ICD9-CM', 'Diabetes mellitus without complication type ii or unspecified type uncontrolled');
INSERT INTO concept (conceptid, code, codesystem, codesystemname, displayname) VALUES (5, '250.03', '2.16.840.1.113883.6.2', 'ICD9-CM', 'Diabetes mellitus without complication type i uncontrolled');
INSERT INTO subsetmember (conceptid, subsetid) VALUES (2,1);
INSERT INTO subsetmember (conceptid, subsetid) VALUES (3,1);
INSERT INTO subsetmember (conceptid, subsetid) VALUES (4,1);
INSERT INTO subsetmember (conceptid, subsetid) VALUES (5,1);