FROM mariadb:latest

ENV MYSQL_ROOT_PASSWORD=password

ADD data /docker-entrypoint-initdb.d

EXPOSE 3306