OPENSCORING_DATA="../../data"
TOMCAT_DATA_DIR=$(cd ${OPENSCORING_DATA} && pwd)
CONTAINER_NAME=openscoring

if [ -z "$TOMCAT_PORT" ]; then
  TOMCAT_PORT=8080
fi
