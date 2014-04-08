cmake_minimum_required(VERSION 2.6)

#  A sample CmakeLists.txt to find and use the mysql executable
#  to run a sql script to populate a database and then drop the database
#  afterwards to clean the environment

# This code can be put into either the request or responder subproject, just be sure to change the path in the first exceute_process command.

# find_program( variable_name NAMES names of executable HINTS Guesses where the executable could reside DOC "descriptive string"
# more info:  http://www.cmake.org/cmake/help/v2.8.12/cmake.html#command:find_program
enable_testing()
include(CTest)
project(OIB Request)
find_package(Java)

find_program(MYSQL_EXECUTABLE NAMES mysql mysql.exe HINTS /usr/bin/local/ DOC "Path to the MySQL executable file")
set(MYSQL_USER "root" CACHE STRING "Username for the MySQL instance")
set(MYSQL_PASS "" CACHE STRING "Password for the user in the MySQL instance")

# if the variable has no value (not found), clear the advanced marking to have it show in the normal values for 
if(NOT MYSQL_EXECUTABLE)
  Message(fatal_error "MySQL is required to utilize the OpenInfoButton submission")
endif()

# For more information:  http://www.cmake.org/cmake/help/v2.8.12/cmake.html#command:execute_process

#These commands could also be made into tests.  Playing with test dependencies, you can make the first command be run during configuration, and
# have the teardown be a final test that depends on all the others to have run.  Or you can make them both tests with a dependency listling like below

add_test(OIB_SETUP ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -e "drop DATABASE prodoib")
set_property(TEST OIB_SETUP PROPERTY DEPENDS oib_request)

# This second command adds a dependency for a test onto another, in this case oibrequest_test_blah depends on OIB_SETUP

execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -e "source ${oibrequest_SOURCE_DIR}/../DeploymentPackage/sqlDump/prodoib_logs.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -e "source ${oibrequest_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_concept.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -e "source ${oibrequest_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_subset.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -e "source ${oibrequest_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_subsetmember.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -e "source ${oibrequest_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/profilesdbprod_resource_profiles.sql")
 
add_custom_target(LicenseCheck
                  COMMAND mvn license:check
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIB ALL
                  COMMAND mvn -Dmaven.test.skip=true clean install
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
find_program(MAVEN_EXECUTABLE mvn )
file(GLOB_RECURSE testfiles ${OIB_SOURCE_DIR}/src/test/*.java)

add_test(NAME MVN${testname} WORKING_DIRECTORY ${OIB_SOURCE_DIR} COMMAND "${MAVEN_EXECUTABLE}" -Dtest=ContextMatcherTest test)
