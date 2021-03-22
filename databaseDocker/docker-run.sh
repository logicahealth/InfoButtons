#/bin/bash

# Create and run new container from the image - this is for local testing.
docker run -d \
       --network infobuttonNetwork \
       --network-alias infobuttondb \
       -p 3306:3306 --name infobuttondb -d infobutton/infobuttondb
