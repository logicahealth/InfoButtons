# CMake generated Testfile for 
# Source directory: /Users/lvr491/Development/Innovation-182/oib-request
# Build directory: /Users/lvr491/Development/Innovation-182/oib-request
# 
# This file includes the relevant testing commands required for 
# testing this directory and lists subdirectories to be tested as well.
add_test(OIB_DROPDB "/usr/local/bin/mysql" "-uroot" "-e" "drop database prodoib;drop database profilesdbprod")
set_tests_properties(OIB_DROPDB PROPERTIES  DEPENDS "OIB_REQUEST;Coverage" WORKING_DIRECTORY "/Users/lvr491/Development/Innovation-182/oib-request")
add_test(OIB_REQUEST "/usr/local/bin/mvn" "-Dtest=ContextMatcherTest" "-Djacoco.skip=true" "test")
set_tests_properties(OIB_REQUEST PROPERTIES  WORKING_DIRECTORY "/Users/lvr491/Development/Innovation-182/oib-request/oib-request-service")
