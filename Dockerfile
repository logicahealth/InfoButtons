FROM tomcat:8.5.64-jdk8-corretto

MAINTAINER Emerson Borsato <emerson.borsato@utah.edu>

COPY oib-request/oib-request-service/target/infobutton-service.war /usr/local/tomcat/webapps/
COPY oib-responder/target/openInfobutton.war /usr/local/tomcat/webapps/


RUN mkdir -p /usr/local/tomcat/webapps/app
ADD oib-site-lite-ui/app /usr/local/tomcat/webapps/app/

ENV datasource.url jdbc:mysql://infobuttondb:3306/resource_profile
ENV datasource.driver com.mysql.jdbc.Driver
ENV datasource.user root
ENV datasource.password password
EXPOSE 8080
CMD ["catalina.sh", "run"]
