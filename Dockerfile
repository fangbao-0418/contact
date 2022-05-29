FROM openjdk:8-jdk-debian

ARG RUN_ENV

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 7002

CMD java -jar app.jar --spring.profiles.active=${RUN_ENV}

ENV spring_datasource_username="root"
ENV spring_datasource_password="root"
ENV RUN_ENV=${RUN_ENV}

