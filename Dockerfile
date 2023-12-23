FROM unitfinance/jdk17-sbt-scala

WORKDIR /app

COPY target/ping-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]