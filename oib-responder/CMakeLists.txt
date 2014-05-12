cmake_minimum_required(VERSION 2.6)


project(OIB_RESPONDER Java)
include(CTest)
find_package(Java)
 

add_custom_target(LicenseCheck
                  COMMAND mvn license:check
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIB_RESPONDER ALL
                  COMMAND mvn clean compile
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
add_custom_target(OIB_RESPONDERPack
                  COMMAND mvn clean package
                  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

find_program(MAVEN_EXECUTABLE mvn )

file(GLOB_RECURSE oibAppModelTests ${OIB_RESPONDER_SOURCE_DIR}/oib-app-model/src/test/**/*.java)

foreach(test ${oibAppModelTests})
        get_filename_component(testname ${test} NAME_WE)
        add_test(NAME MVN${testname}_OIB_APP_MODEL WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR}/oib-app-model
                 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} test)
endforeach()

file(GLOB_RECURSE oibAppServiceTests ${OIB_RESPONDER_SOURCE_DIR}/oib-app-service/src/test/**/*.java)

foreach(test ${oibAppMServiceTests})
        get_filename_component(testname ${test} NAME_WE)
        add_test(NAME MVN${testname}_OIB_APP_SERVICE WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR}/oib-app-service
                 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} test)
endforeach()

file(GLOB_RECURSE oibIndexManagerTests ${OIB_RESPONDER_SOURCE_DIR}/oib-index-manager/src/test/**/*.java)

foreach(test ${oibIndexManagerTests})
        get_filename_component(testname ${test} NAME_WE)
        add_test(NAME MVN${testname}_OIB_INDEX_MANAGER WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR}/oib-index-manager
                 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} test)
endforeach()

file(GLOB_RECURSE oibRestResponderTests ${OIB_RESPONDER_SOURCE_DIR}/oib-rest-responder/src/test/**/*.java)

foreach(test ${oibRestResponderTests})
        get_filename_component(testname ${test} NAME_WE)
        add_test(NAME MVN${testname}_OIB_REST_RESPONDER WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR}/oib-rest-responder
                 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} test)
endforeach()

file(GLOB_RECURSE rxNormRestModelTests ${OIB_RESPONDER_SOURCE_DIR}/rxnorm-rest-model/src/test/**/*.java)

foreach(test ${rxNormRestModelTests})
        get_filename_component(testname ${test} NAME_WE)
        add_test(NAME MVN${testname}_RXNORM_REST_MODEL WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR}/rxnorm-rest-model
                 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} test)
endforeach()

file(GLOB_RECURSE utsWebClientTests ${OIB_RESPONDER_SOURCE_DIR}/uts-ws-client/src/test/**/*.java)

# foreach(test ${utsWebClientTests})
#        get_filename_component(testname ${test} NAME_WE)
#        add_test(NAME MVN${testname}_UTS_WEB_CLIENT WORKING_DIRECTORY ${OIB_RESPONDER_SOURCE_DIR}/uts-web-client
#                 COMMAND "${MAVEN_EXECUTABLE}" -Dtest=${testname} test)
#endforeach()
