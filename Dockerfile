#
# Build stage
#
FROM maven:3.5-jdk-8 AS build  
COPY . .
RUN mvn install 

#
# Package stage

FROM openjdk:8-jdk-alpine
#VOLUME /tmp
COPY target/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--host.env=docker"]
