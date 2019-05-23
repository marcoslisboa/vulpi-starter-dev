# Alpine because it's lighter
FROM openjdk:8-jdk-alpine
VOLUME /tmp
MAINTAINER Marcos Lisboa <marcoslisboadev@gmail.com>
RUN apk add --no-cache tzdata

# Set ENV variables
ENV TZ America/Sao_Paulo
ENV PORT=8080

# Add JAR file and run it as entrypoint
ADD target/vulpi-starter-dev-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "-Dfile.encoding=UTF-8", "/app.jar"]

# Expose the port
EXPOSE 8080
