#
# Build stage
#
#FROM maven:3.5-jdk-8 AS build  
# copy the project files
#COPY ./ ./
# build all dependencies for offline use
#RUN mvn dependency:go-offline -B
#RUN mvn package

#
# Package stage

FROM openjdk:8-jdk-alpine
#VOLUME /tmp
COPY target/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--host.env=docker"]
