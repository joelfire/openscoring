FROM tomcat:jre8

WORKDIR /usr/local/tomcat

# Add the custom configuration file we made
RUN rm -rf webapps logs work temp
RUN mv conf conf.orig
RUN ln -s /data/webapps webapps
RUN ln -s /data/logs logs
RUN ln -s /data/work work
RUN ln -s /data/temp temp
RUN ln -s /data/conf conf
