## 环境要求

Spring Boot 2.6.7 要求Java 8，兼容Java 17。
Spring Framework 5.3.19或更高版本也是必需的。
Maven	3.5+
Gradle	6.8.x, 6.9.x, and 7.x

## 启动服务
```
mvn spring-boot:run
```

## 安装依赖
```
mvn package
```

## 运行环境
java -jar app.jar --spring.profiles.active=dev

## docker
docker build --build-arg RUN_ENV=prod -t eiot6:latest .
docker run --rm --name eiot6 -p 7002:7002 eiot6:latest
