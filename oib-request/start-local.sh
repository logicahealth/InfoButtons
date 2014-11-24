#!/bin/bash
/usr/local/Cellar/tomcat/7.0.42/libexec/bin/shutdown.sh
rm -rf /usr/local/Cellar/tomcat/7.0.42/libexec/webapps/infobutton-service
cp /Users/lvr491/Development/Innovation-182/oib-request/oib-request-service/target/infobutton-service.war /usr/local/Cellar/tomcat/7.0.42/libexec/webapps
/usr/local/Cellar/tomcat/7.0.42/libexec/bin/startup.sh 

