FROM openjdk:11-jdk-slim-buster
ADD target/polski-punish-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar polski-punish-0.0.1-SNAPSHOT.jar

