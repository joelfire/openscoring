#!/bin/bash
# Builds the container that allows override of conf
sudo docker build -t openscoring .

# now copy all original conf files in case we need them
. ./env.sh
CONTAINER_NAME=${CONTAINER_NAME}_TEMP

sudo docker run \
    -d \
    -v ${TOMCAT_DATA_DIR}:/data \
    --name=${CONTAINER_NAME} \
    openscoring bash -c 'cd /data && mkdir -pv conf.orig && cp /usr/local/tomcat/conf.orig/* conf.orig'

sudo docker stop ${CONTAINER_NAME}
sudo docker rm ${CONTAINER_NAME}


