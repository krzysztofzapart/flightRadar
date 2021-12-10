FROM openjdk:17
ADD target/flightradar-0.0.1-SNAPSHOT.jar flightradar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","flightradar.jar"]
