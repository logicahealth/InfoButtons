#/bin/bash

# Create and run new container from the image - this is for local testing.
docker run -d \
       --network infobuttonNetwork \
       --network-alias infobuttonresponderdb \
       -p 3307:3306 --name infobuttonresponderdb -d infobutton/infobuttonresponderdb
