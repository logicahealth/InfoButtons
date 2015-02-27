InfoButtons
===========

Repository for VHA Innovation 182 - Context Sensitive InfoButtons

This project is a part of the Veterans Health Administration (VHA) Grassroots initiative. Infobuttons are context-sensitive links embedded in the electronic health record (EHR). They use clinical context information from the EHR such as patient demographics, medications, diagnoses, lab results, user role, and clinical setting to help find answers to clinicians' and patients' clinical questions. This project will insert Infobuttons into eHMP and other VHA systems at several different points and use an Infobutton Manager to customize the way resources are delivered to clinicians. OpenInfobutton software has been certified through the Open Source EHR Alliance (OSEHRA) and is available through Apache 2.0 license.

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
