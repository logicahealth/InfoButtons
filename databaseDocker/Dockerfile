## MySQL Server configuration for the Pubmed Citation Summary Pipeline (CSP)
FROM mysql/mysql-server:5.7

MAINTAINER Emerson Borsato <emerson.borsato@utah.edu>

ENV MYSQL_ROOT_PASSWORD 'password'
ENV MYSQL_DATABASE resource_profile
ENV MYSQL_USER root
ENV MYSQL_PASSWORD password

## to run an sql script
## COPY ./create-fact-schema.sql /docker-entrypoint-initdb.d/
COPY ./data/a_resource_profile.sql /docker-entrypoint-initdb.d
COPY ./data/b_profile_black_list.sql /docker-entrypoint-initdb.d
COPY ./data/c_userAuthentication.sql /docker-entrypoint-initdb.d
COPY ./data/d_oib_app_property.sql /docker-entrypoint-initdb.d
COPY ./data/a_valueset_and_log.sql /docker-entrypoint-initdb.d

EXPOSE 3306
