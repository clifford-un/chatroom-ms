#Java execution Environment
FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/chatroom-ms-0.1.jar

ADD ${JAR_FILE} chatroom-ms.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/chatroom-ms.jar"]
