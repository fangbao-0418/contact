FROM openjdk:8-jdk-alpine

WORKDIR /app
RUN apk add curl

COPY target/*.jar app.jar

RUN apk add --no-cache tzdata

ENV TZ="Asia/Shanghai"

EXPOSE 7002

CMD ["java", "-jar", "app.jar"]

