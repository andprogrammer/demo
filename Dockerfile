FROM openjdk:8u191-jdk-alpine3.9
ADD target/demo-0.0.1-SNAPSHOT.jar .
EXPOSE 8080:8080
CMD java -jar demo-0.0.1-SNAPSHOT.jar --envname=prod