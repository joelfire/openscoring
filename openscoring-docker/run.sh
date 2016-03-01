. ./env.sh

sudo docker stop ${CONTAINER_NAME}
sudo docker rm ${CONTAINER_NAME}

mkdir -pv ${TOMCAT_DATA_DIR}
cd ${TOMCAT_DATA_DIR}
mkdir -pv webapps logs work temp conf
cd -

sudo docker run \
    -d \
    -p ${TOMCAT_PORT}:8080  \
    -v ${TOMCAT_DATA_DIR}:/data \
    --name=${CONTAINER_NAME} \
    openscoring /usr/local/tomcat/bin/catalina.sh run

