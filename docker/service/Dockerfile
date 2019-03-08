FROM centos/systemd

MAINTAINER "Andrew Iskander" 

RUN yum update -y && \
yum -y install java-1.8.0-openjdk-devel && \
yum -y install git && \
yum -y install wget && \
yum -y install unzip && \
yum -y install epel-release && \
yum -y install nodejs && \
yum clean all

ENV JAVA_HOME=/usr/lib/jvm/java

WORKDIR /opt

RUN wget https://www-us.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz -P /tmp && \
tar xf /tmp/apache-maven-3.6.0-bin.tar.gz -C . && \
ln -s apache-maven-3.6.0 maven

COPY tomcat.service /etc/systemd/system/tomcat.service

RUN useradd -m -U -d /opt/tomcat -s /bin/false tomcat && \
wget http://www-us.apache.org/dist/tomcat/tomcat-8/v8.5.37/bin/apache-tomcat-8.5.37.zip -P /tmp && \
unzip /tmp/apache-tomcat-8.5.37.zip -d tomcat && \
ln -s /opt/tomcat/apache-tomcat-8.5.37 /opt/tomcat/latest && \
chown -R tomcat: tomcat && \
chmod +x tomcat/latest/bin/*.sh

WORKDIR data

RUN git clone https://github.com/VHAINNOVATIONS/InfoButtons.git

WORKDIR InfoButtons/rest-terminology-services

RUN /opt/maven/bin/mvn clean install -Dmaven.test.skip=true

WORKDIR ../oib-request

COPY pom.xml pom.xml

RUN /opt/maven/bin/mvn clean install -Dmaven.test.skip=true && \
cp oib-request-service/target/infobutton-service.war /opt/tomcat/latest/webapps

WORKDIR ../oib-responder

COPY jdbc.properties src/main/webapp/WEB-INF/jdbc.properties

RUN /opt/maven/bin/mvn clean install -Dmaven.test.skip=true && \
cp target/openInfobutton.war /opt/tomcat/latest/webapps

WORKDIR ../oib-site-lite-ui

COPY package.json package.json

RUN npm install -g bower && \
npm install -g http-server && \
bower install --allow-root && \
npm install

RUN systemctl enable tomcat

EXPOSE 8080 8000

CMD ["/usr/sbin/init"]