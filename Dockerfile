FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/restaurante-0.0.1-SNAPSHOT.jar restaurante.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "restaurante.jar"]
