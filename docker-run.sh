docker container run --network=infobuttonNetwork \
 --network-alias infobuttonapp \
 --name=infobuttonapp -it --publish 8080:8080 infobutton/infobuttonapp