#! /bin/sh

if [ -z "$1"]
then
  echo "Usage: install-db.sh <dbUser> <pwd>"
  exit 1
fi

if [ -z "$2" ]
then
	pwd=''
else
	pwd="$2"
fi

echo "Executing mysql script as USER: $1 PWD: $2"

echo "Executing create-oib-model-mysql.sql ..."
mysql --user=$1 --password=$pwd < create-oib-model-mysql.sql
echo "Executing oib-app-property-inserts.sql ..."
mysql --user=$1 --password=$pwd < oib-app-property-inserts.sql
echo "Executing oib-asset-inserts.sql ..."
mysql --user=$1 --password=$pwd < oib-asset-inserts.sql
echo "Executing oib-asset-property-inserts.sql ..."
mysql --user=$1 --password=$pwd < oib-asset-property-inserts.sql
echo "Executing oib-request-parameter-inserts ..."
mysql --user=$1 --password=$pwd < oib-request-parameter-inserts.sql
echo "Executing oib-value-set-inserts.sql ..."
mysql --user=$1 --password=$pwd < oib-value-set-inserts.sql
echo "Executing oib-value-set-code-inserts.sql ..."
mysql --user=$1 --password=$pwd < oib-value-set-code-inserts.sql
