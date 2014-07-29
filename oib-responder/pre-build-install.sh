#! /bin/sh

# if [ "$#" -ne 2 ] || ! [ -d "$1" ]; then
#   echo "Usage: <username> <password>" > &2
#   exit 1
# fi

this_dir=`pwd`

mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/oib-app-model-0.2.jar -DgroupId=org.openinfobutton -DartifactId=oib-app-model -Dversion=0.2 -Dpackaging=jar
mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/oib-app-service-0.2.jar -DgroupId=org.openinfobutton -DartifactId=oib-app-service -Dversion=0.2 -Dpackaging=jar
mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/rxnorm-rest-model-1.0.jar -DgroupId=gov.nih.nlm.rxnav -DartifactId=rxnorm-rest-model -Dversion=1.0 -Dpackaging=jar
mvn deploy:deploy-file -Durl=file:///"$this_dir"/mvn-proj-repo -Dfile=lib/uts-ws-client-2.0.jar -DgroupId=uts.nlm.nih.gov -DartifactId=uts-ws-client -Dversion=2.0 -Dpackaging=jar

# mysql --user=$1 --password=$2 < oib-rdbms-model/create-oib-model-mysql.sql
# mysql --user=$1 --password=$2 < oib-rdbms-model/oib-app-property-inserts.sql
# mysql --user=$1 --password=$2 < oib-rdbms-model/oib-asset-inserts.sql
# mysql --user=$1 --password=$2 < oib-rdbms-model/oib-asset-property-inserts.sql
# mysql --user=$1 --password=$2 < oib-rdbms-model/oib-request-parameter_inserts.sql
# mysql --user=$1 --password=$2 < oib-rdbms-model/oib-value-set-code-inserts.sql
# mysql --user=$1 --password=$2 < oib-rdbms-model/oib-value-set-inserts.sql

