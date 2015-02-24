InfoButtons
===========

Repository for VHA Innovation 182 - Context Sensitive InfoButtons

This project is a part of the Veterans Health Administration (VHA) Grassroots initiative. Infobuttons are context-sensitive links embedded in the electronic medical record. They use context such as patient demographics, user role, or clinical setting to help anticipate the needs of the clinician. This project will insert Infobuttons into CPRS at several different points and use an Infobutton Manager to customize the way resources are delivered to clinicians.

1.7 RELEASE NOTES
=================

The new version of OpenInfobutton introduces the first public release of the LITE web application, which allows configuration of the Infobutton Resource Profiles to be managed by a librarian, without help from the service administrator. This release also includes bug fixes for the Infobutton Service

Building
---------

There have been a number of changes to both the naming and structure of the OIB databases. The build instructions and database scripts have been updated to reflect them. For new installations, refer to the BUILDGUIDE inside each respective module. For migration, refer to the MIGRATIONGUIDE<version> for the version you are coming from. For now, we only have migration guide for version 1.6. 

Change Log
----------

-Optimized UMLS services so they timeout and fail silently when a terminology request hangs for too long. Previous behavior would block the entire Infobutton Service request and potentially return server errors to the client.

-Added an additional web service for use by the LITE tool for configuring the service. This is still in the experimental stages and not fully functional. The current version of LITE does not use this, instead using a separate javascript web service with CRUD functions for the Infobutton database.

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
