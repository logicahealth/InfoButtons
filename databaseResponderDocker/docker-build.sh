#/bin/bash

# create a network for the infobutton project
docker network create infobuttonNetwork

# stop running container
docker container stop infobuttonresponderdb

# remove the container
docker container rm infobuttonresponderdb

# Remove image of the container
docker image rm infobutton/infobuttonresponderdb

# Rebuild the image of the container using Dockerfile
docker build -t infobutton/infobuttonresponderdb .
