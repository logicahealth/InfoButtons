#/bin/bash

# create a network for the infobutton project
docker network create infobuttonNetwork

# stop running container
docker container stop infobuttondb

# remove the container
docker container rm infobuttondb

# Remove image of the container
docker image rm infobutton/infobuttondb

# Rebuild the image of the container using Dockerfile
docker build -t infobutton/infobuttondb .
