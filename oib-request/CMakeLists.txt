project(OIB_REQUEST)
cmake_minimum_required(VERSION 2.6)
enable_testing()
include(CTest)
find_package(Java)

find_program(MYSQL_EXECUTABLE NAMES mysql mysql.exe HINTS /usr/bin/local/ DOC "Path to the MySQL executable file")
option(OIB_STYLE "Use Checkstyle to report on Java SAC errors" OFF)
option(OIB_COVERAGE "Check coverage for the testing using Jacoco" OFF)

set(MYSQL_USER "root" CACHE STRING "Username for the MySQL instance")

if(NOT "${MYSQL_USER}" STREQUAL "root")
  set(MYSQL_PASS "password" CACHE STRING "Password for the user in the MySQL instance")
  set(MYSQL_CONNECTION "-u${MYSQL_USER} -p${MYSQL_PASS}")
else()
  set(MYSQL_CONNECTION "-u${MYSQL_USER}")
endif()

# if the variable has no value (not found), clear the advanced marking to have it show in the normal values for 
if(NOT MYSQL_EXECUTABLE)
  Message(fatal_error "MySQL is required to utilize the OpenInfoButton submission")
endif()

# For more information:  http://www.cmake.org/cmake/help/v2.8.12/cmake.html#command:execute_process

execute_process(COMMAND ${MYSQL_EXECUTABLE} ${MYSQL_CONNECTION} -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlDump/prodoib_logs.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} ${MYSQL_CONNECTION} -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_concept.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} ${MYSQL_CONNECTION} -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_subset.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} ${MYSQL_CONNECTION} -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_subsetmember.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} ${MYSQL_CONNECTION} -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/profilesdbprod_resource_profiles.sql")
 
add_custom_target(LicenseCheck
                  COMMAND mvn license:check
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIB ALL
                  COMMAND mvn -Dmaven.test.skip=true clean install
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
find_program(MAVEN_EXECUTABLE mvn )


if(OIB_STYLE)

  configure_file(${CMAKE_CURRENT_SOURCE_DIR}/checkstyle-reporter.cmake.in ${CMAKE_CURRENT_BINARY_DIR}/checkstyle.cmake @ONLY)
  set(check_dirs "./oib-ext-resources/\;./oib-request-db/\;./oib-request-service\;./oib-request-inference-rxnorm\;./oib-request-schema"
      CACHE STRING "Semicolon (;) separated list of directories to report Checkstyle Errors for")
  add_test(NAME Checkstyle COMMAND ${CMAKE_COMMAND} -DSearchDirs=${check_dirs} -P ${CMAKE_CURRENT_BINARY_DIR}/checkstyle.cmake
         WORKING_DIRECTORY ${OIB_REQUEST_SOURCE_DIR})
  set_tests_properties(Checkstyle PROPERTIES FAIL_REGULAR_EXPRESSION "Line [0-9]+:") 

else()
  add_test(NAME OIB_DROPDB
	WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} 
	COMMAND "${MYSQL_EXECUTABLE}" ${MYSQL_CONNECTION} -e "drop database prodoib;drop database profilesdbprod")
  set_property(TEST OIB_DROPDB PROPERTY DEPENDS OIB_REQUEST;Coverage)
  if(OIB_COVERAGE)
    add_test(NAME Coverage COMMAND ${MAVEN_EXECUTABLE} test
         WORKING_DIRECTORY ${OIB_REQUEST_SOURCE_DIR})
  else()
    add_test(NAME OIB_REQUEST
	 WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/oib-request-service
         COMMAND "${MAVEN_EXECUTABLE}" -Dtest=ContextMatcherTest -Djacoco.skip=true test)
  endif()
endif()
