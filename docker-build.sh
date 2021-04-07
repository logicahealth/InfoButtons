#!/bin/bash


# stop running container
docker container stop infobuttonapp

# remove the container anticipating rebuild
docker container rm infobuttonapp

# Remove image of the container
docker image rm infobutton/infobuttonapp

# Rebuild the image of the container using Dockerfile
docker build -t infobutton/infobuttonapp ./
