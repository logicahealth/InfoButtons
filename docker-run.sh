docker container run \
 -e datasource.url=jdbc:mysql://infobuttondb:3306/resource_profile \
 -e datasource.driver=com.mysql.jdbc.Driver \
 -e datasource.user=root \
 -e datasource.password=password \
 --network=infobuttonNetwork \
 --network-alias infobuttonapp \
 --name=infobuttonapp -it --publish 8080:8080 infobutton/infobuttonapp

