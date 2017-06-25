InfoButtons
===========

Repository for VHA Innovation 182 - Context Sensitive InfoButtons

This project is a part of the Veterans Health Administration (VHA) Grassroots initiative. Infobuttons are context-sensitive links embedded in the electronic health record (EHR). They use clinical context information from the EHR such as patient demographics, medications, diagnoses, lab results, user role, and clinical setting to help find answers to clinicians' and patients' clinical questions. This project will insert Infobuttons into eHMP and other VHA systems at several different points and use an Infobutton Manager to customize the way resources are delivered to clinicians. OpenInfobutton software has been certified through the Open Source EHR Alliance (OSEHRA) and is available through Apache 2.0 license.

Built with:

[![IntelliJ IDEA](https://www.jetbrains.com/idea/docs/logo_intellij_idea.png)](https://www.jetbrains.com/idea/)

2.1 RELEASE NOTES
=================

OpenInfobutton 2.1 is a major release that includes new features, bug fixes and a Vagrant/VirtualBox virtual machine that can be deployed with minimal configuration. Most importantly OIB now requires upgrading to JDK8, IT WILL NOT BUILD WITH OLDER VERSIONS OF JAVA. While I understand
this may be an inconvenience to some, JDK7 has been EOL by Oracle, meaning they are no longer releasing security updates for it. Given the nature
of OpenInfobutton as a facet of clinical information systems, it made sense to upgrade for this reason alone.


New features:

-We are now maintaining and distributing a preconfigured VM with instances of both OpenInfobutton and LITE already running. Users had been requesting
an easier way to deploying their own instance of OpenInfobutton and we believe this is the best route going forward.

-Value sets are now hosted in Github, similarily to the store profiles, and will now be centrally curated so they no longer need to managed for
individual installs. The LITE profile editor now includes a pick list for value sets that automatically populates from Github.

-Terminology translations and free text lookups now use the UTS REST API, rather than the now deprecated SOAP service. This both reduces the size
of the deployed WAR and increases the speed of requests that require terminology services.

-The InfoButton request log now includes the full response to make debugging easier. We are also now logging the request URL parameters rather than 
an XML representation of the request.

-LITE now includes a demo page and a request testing tool so users can more easily test their install.

-You can now change the admin username and password directly from LITE rather than editing the database.

Bug fixes and improvements:

-ICD9 to SNOMED-CT mappings have been deprectated and removed from OpenInfobutton

-Free text matching sometimes clashed with simultaneous requests, causing inconsistent results to be returned. This has been fixed.

-The Responder RXNorm translation functionality was no longer working due to an update to the RXNorm web service. The responder has been 
updated to account for that change.

-Various improvements to LITE's usability have been implemented.

Building and redeploying
------------------------

I've tried to streamline the building and deployment process as much as possible. To that end, many old or no longer needed dependencies have been removed. This has allowed me to remove our Nexus repository from all the Maven POM files, now all dependencies are retrieved directly from Maven
central. You will of course still need an unrestricted internet connection to build the application, but it should be much more reliable and faster now. As mentioned earlier, you MUST UPGRADE TO JDK8. I would also recommend upgrading to Tomcat 8 or later as well, but this is not currently required. There is a minor database migration script for the changes to the request log, and the value set database has been scrapped entirely in favor of a simpler schema that stores the value sets as XML files, exactly as they are in Github. You can configure your installation of OpenInfobutton to use either the Github value sets OR the database.

2.0 RELEASE NOTES
=================

OpenInfobutton 2.0 includes many major feature updates as well as optimizations and bug fixes to existing features. 

Major features:

- This is the first fully featured release of the LITE OpenInfobutton management tool. It includes the ability to download resource profiles from the OpenInfobutton cloud-based profile store, configure custom resource profiles, and index local resources for the infobutton responder. 
- Major improvements in the overall usability of LITE.
- LITE user authentication 

Other general improvements:
- A typeahead style search for Main Search Criteria in the Responder asset property editor
- An additional database table that allows organizations to "blacklist" a profile based on the userId request parameter
- Optimizations to profile loading code in the Infobutton Manager that speed up its response time
- An optional unit test that can be used as to monitor the status of an OpenInfobutton server 
- Various other bug fixes and optimizations that are logged in our github repository

Building and redeploying
------------------------

While this release does not make any changes to any existing OIB databases or tables, it does require the creation of two new tables for the profile black list and LITE user authentication. I've updated the BUILDGUIDE for oib-request and added the additional SQL scripts under the DeploymentPackage/dbScripts directory. There has also been an additional module added called rest-terminology-services that must be built and installed into your local maven repository before building oib-request. This module includes a java client for calling UMLS REST API.

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
