FROM maven:3.6.3-jdk-11 as MAVEN_BUILD
COPY ./ ./
RUN mvn clean package

FROM openjdk:11-jdk-slim-buster
COPY --from=MAVEN_BUILD target/polski-punish-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar polski-punish-0.0.1-SNAPSHOT.jar

