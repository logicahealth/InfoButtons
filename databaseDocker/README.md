# Infobutton database

The Infobutton database is a MySql database that contains the tables necessary for the infobutton software to run. Some implementation may decide to use their own implementation.
In that case, this database is not necessary.

### Prerequisities


In order to run this container you'll need docker installed.

* [Windows](https://docs.docker.com/windows/started)
* [OS X](https://docs.docker.com/mac/started/)
* [Linux](https://docs.docker.com/linux/started/)

### Usage

* It is important to have the container running on a newtwork (same as the the container of the application, if they are both running on docker).
To create a network named "infobuttonNetwork" run

docker network create infobuttonNetwork

* To run the database container. 

docker run -d \
--network infobuttonNetwork \
--network-alias infobuttondb \
-p 3306:3306 --name infobuttondb -d infobutton/infobuttondb

* Note that the network alias for the containd is infobuttondb. This is how the web application container will reference the database container. 


## Built With

* MySql

## Find Us

* [GitHub](https://github.com/logicahealth/InfoButtons)
