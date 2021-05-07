## MySQL Server configuration for the Pubmed Citation Summary Pipeline (CSP)
FROM mysql/mysql-server:5.7

MAINTAINER Emerson Borsato <emerson.borsato@utah.edu>

ENV MYSQL_ROOT_PASSWORD 'password'
ENV MYSQL_DATABASE OIB
ENV MYSQL_USER root
ENV MYSQL_PASSWORD password

## to run an sql script
## COPY ./create-fact-schema.sql /docker-entrypoint-initdb.d/
COPY ./data/a_create-oib-model-mysql.sql /docker-entrypoint-initdb.d
COPY ./data/b_oib-app-property-inserts.sql /docker-entrypoint-initdb.d
COPY ./data/c_oib-request-parameter-inserts.sql /docker-entrypoint-initdb.d
COPY ./data/d_oib-value-set-inserts.sql /docker-entrypoint-initdb.d
COPY ./data/e_oib-value-set-code-inserts.sql /docker-entrypoint-initdb.d

EXPOSE 3306
