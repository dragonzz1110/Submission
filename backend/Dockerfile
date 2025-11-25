# Stage 1: build
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace

COPY pom.xml .
RUN mvn -q dependency:go-offline

COPY src src
RUN mvn -q package -DskipTests

# Stage 2: run
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /workspace/target/*-runner.jar /app/app.jar

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
