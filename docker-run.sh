docker container run \
 -e ibresponder.jdbc.driverClassName=com.mysql.jdbc.Driver \
 -e ibresponder.jdbc.url=jdbc:mysql://infobuttonresponderdb:3306/OIB \
 -e ibresponder.jdbc.username=root \
 -e ibresponder.jdbc.password=password \
 -e ibresponder.jdbc.dialect=org.hibernate.dialect.MySQLDialect \
 -e datasource.url=jdbc:mysql://infobuttondb:3306/resource_profile \
 -e datasource.driver=com.mysql.jdbc.Driver \
 -e datasource.user=root \
 -e datasource.password=password \
 --network=infobuttonNetwork \
 --network-alias infobuttonapp \
 --name=infobuttonapp -it --publish 8080:8080 infobutton/infobuttonapp

