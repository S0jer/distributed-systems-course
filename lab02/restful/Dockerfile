FROM maven:3.9.4 AS build

WORKDIR /app
COPY pom.xml /app
COPY src /app/src

RUN mvn package -DskipTests

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]