FROM gradle:7.3.3-jdk11
COPY build/libs/usuarios-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
