#/bin/bash

# Create and run new container from the image - this is for local testing.
docker run -d \
       --network infobuttonNetwork \
       --network-alias infobuttondb \
       -e MYSQL_ROOT_PASSWORD=password \
       -e MYSQL_USER=root \
       -e MYSQL_PASSWORD=password \
       -e MYSQL_DATABASE=resource_profile \
       -p 3306:3306 --name infobuttondb -d infobutton/infobuttondb
