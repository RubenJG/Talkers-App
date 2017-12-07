FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD build/libs/eureka-latest.jar /app.jar
ENTRYPOINT ["java","-Xmx128m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]