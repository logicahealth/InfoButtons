# Open InfoButton Application

The Open Infobutton application image allows the creation of a container running the Open Infobutton Web Application.
The application can be launched utilizing the database image or using a database external to docker. The instructions below
describe the steps using the docker image for the info button database.  

## Prerequisities

In order to run this container you'll need docker installed.

* [Windows](https://docs.docker.com/windows/started)
* [OS X](https://docs.docker.com/mac/started/)
* [Linux](https://docs.docker.com/linux/started/)

## Usage

### Launching the application utilizing an infobutton docker database image
1. Create a network in docker by running the following command 
   
docker network create infobuttonNetwork
   
2. Get database images

* Get the infobutton/infobuttondb image database

docker pull infobutton/infobuttondb

* Get the infobutton/infobuttonresponderdb image database

docker pull infobutton/infobuttonresponderdb

3. Create an infobutton docker network

docker network create infobuttonNetwork

4. Run infobutton database container for both databases 

docker run -d \
--network infobuttonNetwork \
--network-alias infobuttondb \
-p 3306:3306 --name infobuttondb -d infobutton/infobuttondb


docker run -d \
--network infobuttonNetwork \
--network-alias infobuttonresponderdb \
-p 3307:3306 --name infobuttonresponderdb -d infobutton/infobuttonresponderdb


5. Get the infobutton/infobuttonapp image application

docker pull infobutton/infobuttonapp

6. Run the infobuttonapp image

docker container run \
--network infobuttonNetwork \
--network-alias infobuttonapp \
--name infobuttonapp -it -d --publish 8080:8080 infobutton/infobuttonapp

7. On the browser visit http://localhost:8080/app and login with root/password credentials

### Launching the application utilizing an external database 

1. Get the infobutton/infobuttonapp image application

docker pull infobutton/infobuttonapp

2. Run the infobuttonapp image

docker container run \
-e ibresponder.jdbc.driverClassName=com.mysql.jdbc.Driver \
-e ibresponder.jdbc.url=jdbc:mysql://<YOUR_INFOBUTTON_RESPONDER_DATABASE_HOST>:<YOUR_INFOBUTTON_RESPONDER_DATABASE_PORT>/OIB \
-e ibresponder.jdbc.username=<YOUR_INFOBUTTON_RESPONDER_DATABASE_USER> \
-e ibresponder.jdbc.password=<YOUR_INFOBUTTON_RESPONDER_DATABASE_PASSWORD> \
-e ibresponder.jdbc.dialect=org.hibernate.dialect.MySQLDialect \
-e datasource.url=jdbc:mysql://<YOUR_DATABASE_HOST>:<YOUR_DATABASE_PORT>/resource_profile \
-e datasource.driver=com.mysql.jdbc.Driver \
-e datasource.user=<YOUR_DATABASE_USER> \
-e datasource.password=<YOUR_DATABASE_PASSWORD> \
--name infobuttonapp -it -d --publish 8080:8080 infobutton/infobuttonapp

NOTE: you may need to add extra configuration on the app to make sure the app running in docker can 
reach the database. 

3. On the browser visit http://localhost:8080/app and login with root/password credentials



## Built With

* MySql

## Find Us

* [GitHub](https://github.com/logicahealth/InfoButtons)
