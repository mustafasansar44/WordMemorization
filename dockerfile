FROM openjdk:17-oracle
COPY target/wordmemorization-0.0.1-SNAPSHOT.jar wordmemorization.jar
ENTRYPOINT ["java", "-jar", "wordmemorization.jar"]