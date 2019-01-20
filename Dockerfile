FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/urlShrink-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
