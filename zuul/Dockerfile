FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD build/libs/zuul-latest.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]