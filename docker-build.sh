#!/bin/bash

date

# stop running container
docker container stop infobutton/infobuttonapp

# remove the container anticpating rebuild
docker container rm infobuttonapp

# Remove image of the container
docker image rm infobutton/infobuttonapp

# Rebuild the image of the container using Dockerfile
docker build -t infobutton/infobuttonapp ./
