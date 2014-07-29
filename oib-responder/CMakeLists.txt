cmake_minimum_required(VERSION 2.6)


project(OIB_RESPONDER Java)
include(CTest)
find_package(Java)


option(OIB_STYLE "Use the Checkstyle Plugin to check for SAC errors" OFF)
option(OIB_COVERAGE "Use the Jacoco Plugin to calculate code coverage" OFF)

find_program(MAVEN_EXECUTABLE mvn )

add_custom_target(LicenseCheck
                  COMMAND mvn license:check
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIB_RESPONDER ALL
                  COMMAND mvn clean compile
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIB_RESPONDERPack
                  COMMAND mvn clean package
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
if(OIB_STYLE)
  configure_file(${OIB_RESPONDER_SOURCE_DIR}/checkstyle-reporter.cmake.in ${OIB_RESPONDER_BINARY_DIR}/checkstyle.cmake @ONLY)
  set(check_dirs "." CACHE STRING "semicolon (;) separated directories to report on for Checkstyle")
  add_test(NAME Checkstyle COMMAND ${CMAKE_COMMAND} -DSearchDirs=${check_dirs} -P ${OIB_RESPONDER_BINARY_DIR}/checkstyle.cmake
           WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR})
  set_tests_properties(Checkstyle PROPERTIES FAIL_REGULAR_EXPRESSION "Line [0-9]+:") 
elseif(OIB_COVERAGE)
  add_test(NAME Coverage 
           COMMAND "${MAVEN_EXECUTABLE}" test
           WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR})
else()

file(GLOB_RECURSE oibRestResponderTests ${OIB_RESPONDER_SOURCE_DIR}/src/test/**/*.java)

foreach(test ${oibRestResponderTests})
        get_filename_component(testname ${test} NAME_WE)
        add_test(NAME MVN${testname}_OIB_REST_RESPONDER WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR}/oib-responder
                 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} -Djacoco.skip=true test)
endforeach()

endif()
