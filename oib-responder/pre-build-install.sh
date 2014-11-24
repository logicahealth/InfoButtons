#! /bin/sh

this_dir=`pwd`

mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/oib-app-model-0.21.jar -DgroupId=org.openinfobutton -DartifactId=oib-app-model -Dversion=0.21 -Dpackaging=jar
mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/oib-app-service-0.21.jar -DgroupId=org.openinfobutton -DartifactId=oib-app-service -Dversion=0.21 -Dpackaging=jar
mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/rxnorm-rest-model-1.0.jar -DgroupId=gov.nih.nlm.rxnav -DartifactId=rxnorm-rest-model -Dversion=1.0 -Dpackaging=jar
mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/uts-ws-client-2.0.jar -DgroupId=uts.nlm.nih.gov -DartifactId=uts-ws-client -Dversion=2.0 -Dpackaging=jar
