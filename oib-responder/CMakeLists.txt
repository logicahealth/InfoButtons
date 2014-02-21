cmake_minimum_required(VERSION 2.6)


project(OIBRESPONDER Java)
include(CTest)
find_package(Java)
 

add_custom_target(LicenseCheck
                  COMMAND mvn license:check
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIBRESPONDER ALL
                  COMMAND mvn clean compile
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIBRESPONDERPack
                  COMMAND mvn clean package
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

find_program(MAVEN_EXECUTABLE mvn )
file(GLOB_RECURSE testfiles ${OIBRESPONDER_SOURCE_DIR}/src/test/*.java)

foreach(test ${testfiles})
	get_filename_component(testname ${test} NAME_WE)
	add_test(NAME MVN${testname} WORKING_DIRECTORY ${OIBRESPONDER_SOURCE_DIR}
		 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} test)
endforeach()
 
endif()
