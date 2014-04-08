project(OIB_REQUEST)
cmake_minimum_required(VERSION 2.6)
enable_testing()
include(CTest)
find_package(Java)

find_program(MYSQL_EXECUTABLE NAMES mysql mysql.exe HINTS /usr/bin/local/ DOC "Path to the MySQL executable file")
set(MYSQL_USER "root" CACHE STRING "Username for the MySQL instance")
set(MYSQL_PASS "password" CACHE STRING "Password for the user in the MySQL instance")

# if the variable has no value (not found), clear the advanced marking to have it show in the normal values for 
if(NOT MYSQL_EXECUTABLE)
  Message(fatal_error "MySQL is required to utilize the OpenInfoButton submission")
endif()

# For more information:  http://www.cmake.org/cmake/help/v2.8.12/cmake.html#command:execute_process

add_test(NAME OIB_DROPDB
	WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} 
	COMMAND "${MYSQL_EXECUTABLE}" -uroot -ppassword -e "drop database prodoib;drop database profilesdbprod")
set_property(TEST OIB_DROPDB PROPERTY DEPENDS OIB_REQUEST)

execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -ppassword -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlDump/prodoib_logs.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -ppassword -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_concept.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -ppassword -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_subset.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -ppassword -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/prodoib_subsetmember.sql")
execute_process(COMMAND ${MYSQL_EXECUTABLE} -u ${MYSQL_USER} -ppassword -e "source ${CMAKE_CURRENT_SOURCE_DIR}/../DeploymentPackage/sqlWithInsert/profilesdbprod_resource_profiles.sql")
 
add_custom_target(LicenseCheck
                  COMMAND mvn license:check
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIB ALL
                  COMMAND mvn -Dmaven.test.skip=true clean install
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
find_program(MAVEN_EXECUTABLE mvn )

add_test(NAME OIB_REQUEST
	 WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/oib-request-service
         COMMAND "${MAVEN_EXECUTABLE}" -Dtest=ContextMatcherTest test)
