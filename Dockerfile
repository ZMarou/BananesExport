FROM openjdk:20
COPY target/bananes-export-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
