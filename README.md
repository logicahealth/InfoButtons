InfoButtons
===========

Repository for VHA Innovation 182 - Context Sensitive InfoButtons

This project is a part of the Veterans Health Administration (VHA) Grassroots initiative. Infobuttons are context-sensitive links embedded in the electronic health record (EHR). They use clinical context information from the EHR such as patient demographics, medications, diagnoses, lab results, user role, and clinical setting to help find answers to clinicians' and patients' clinical questions. This project will insert Infobuttons into eHMP and other VHA systems at several different points and use an Infobutton Manager to customize the way resources are delivered to clinicians. OpenInfobutton software has been certified through the Open Source EHR Alliance (OSEHRA) and is available through Apache 2.0 license.

Built with:

[![IntelliJ IDEA](https://www.jetbrains.com/idea/docs/logo_intellij_idea.png)](https://www.jetbrains.com/idea/)

2.0 RELEASE NOTES
=================

OpenInfobutton 2.0 includes many major feature updates as well as optimizations and bug fixes to existing features. The biggest improvement is a fully featured custom profile editor that allows librarians to edit and author profiles without any knowledge of XML or usage of database tools. This will make it easier for organizations to tailor OpenInfobutton for their specific needs. Along with this feature, this release also includes the following:

- A typeahead style search for Main Search Criteria in the Responder asset property editor
- An additional database table that allows organizations to "blacklist" a profile based on the userId request parameter
- Simple authentication to manage/restrict users of LITE 
- Optimizations to profile loading code which should speed up requests
- An optional unit test that can be used as a monitoring script for OpenInfobutton installations
- Various other bug fixes and optimizations that are logged in our github repository

Building and redeploying
------------------------

While this release does not make any changes to any existing OIB databases or tables, it does require the creation of two new tables for the profile black list and LITE user authentication. I've updated the BUILDGUIDE for oib-request and added the additions SQL scripts under the DeploymentPackage/dbScripts directory. There has also been an additional module added called rest-terminology-services that must be built and installed into your local maven repository before building oib-request. This module includes a java client for calling UMLS REST API.

1.9 RELEASE NOTES
=================

This update improves the LITE backend by moving the web service endpoints to the main OIB Manager and Responder web applications. This means that in order for LITE to function, you must have a running instance of both the OIB Manager and Responder to connect to. It eliminates the need for the oib-site-lite-rest-server module, which has been removed from the repository. It also adds some additional features to LITE, including asset copying and multi-select for asset properties.

Building and redeploying
------------------------

This release does not require any database changes, however v_* views in the resource_profile database are no longer needed and can be safely dropped. It does require a rebuild and redeploy of all the following modules:
- Infobuton manager: oib-request
- Infobutton responder: oib-responder
- LITE client: oib-site-lite-ui

As mentioned, the oib-site-lite-rest-server module is no longer needed and can be removed.

1.8 RELEASE NOTES
=================

This version includes some bug fixes to the Manager, new LITE functionality for add/editing OpenInfobutton Responder assets, and an update to the Infobutton Responder to faciliate the new functionality. 

Building and redeploying
------------------------

This release only requires updates to the Responder database, the Manager database is unaltered. It does require a rebuild and redeploy of all the 
following modules:
- Infobuton manager: oib-request
- Infobutton responder: oib-responder
- LITE REST web server: oib-site-lite-rest-server
- LITE client: oib-site-lite-ui

There is a migration guide (oib-rest-responder/MIGRATION1011) for the responder that details the additional changes needed to enable the new LITE functionality. For those new to the responder, refer to the BUILDGUIDE (oib-rest-responder/BUILDGUIDE). 


1.7 RELEASE NOTES
=================

The new version of OpenInfobutton introduces the first public release of the LITE web application, which allows configuration of Infobutton Resource Profiles to be managed by domain experts with no IT background, such as medical librarian. This release also includes bug fixes for the Infobutton Manager service.

Building
---------

There have been several changes to both the naming and structure of the OpenInfobutton databases. This release includes 4 modules:
- Infobuton manager: oib-request
- Infobutton responder: oib-responder
- LITE REST web server: oib-site-lite-rest-server
- LITE client: oib-site-lite-ui

The build instructions and database scripts have been updated to reflect them. For new installations, please refer to the BUILDGUIDE inside each respective module. For migration from previous versions of the infobutton manager (oib-request module), please refer to the MIGRATIONGUIDE<version>. For now, we only have a migration guide for version 1.6, but this migration guide can be also used for versions prior to 1.6. 

User Guide
----------

As mentioned, this version includes the LITE web application for configuring OpenInfobutton. We've prepared a user's guide showing how to use most of it's functions,

http://www.openinfobutton.org/documentation/lite-users-guide

Change Log
----------

-Optimized UMLS services so they timeout and fail silently when a terminology request hangs for too long. Previous behavior would block the entire Infobutton Service request and potentially return server errors to the client.

-Added an additional web service for use by the LITE tool for configuring the service. This is still in the experimental stages and not fully functional. The current version of LITE does not use this web service, instead using a separate javascript web service with CRUD functions for the Infobutton database.

-Initial release of LITE Tool. Refer to the BUILDGUIDE in oib-site-lite-ui and oib-site-lite-server to install. The instructions in those files are for a development instance. For production, you are encouraged to minify the /app/ directories of both projects and deploy to a web server of your choice.



1.6 RELEASE NOTES
==================

-Refactored modules into a logical build hierarchy that can be compiled from a single POM
-Refactored individual classes so they are now organized into logical package names
-The entire application is instantiated via Spring configuration files
-Removed references to Duke in all Maven artifact Ids and package names
-Cleaned up unnecessary dependencies in POM files to speed up build times
-Created a testing framework where the necessary database tables are created  with the necessary table for execution of test scripts
-Unit tests for basic Profile matching
-Unit tests for transform execution
-Unit tests for response parsing
-Includes a CMake build file to quickly build and test the code
