Innovation-182
==============

Please note that this code is a collaboration among many different Universities. This is the current master branch and contains the most stable version of the application. The changes for the master branch include,

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



Repository for Innovation 182 - Context Sensitive InfoButtons

Last Modified July 17, 2014 by Andrew Iskander
