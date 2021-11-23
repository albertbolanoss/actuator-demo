FROM openjdk:11
RUN mkdir -p /usr/opt/service
COPY target/*.jar /usr/opt/service/service.jar
EXPOSE 8080
ENTRYPOINT exec java -jar /usr/opt/service/service.jar
