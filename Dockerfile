FROM maven:3.6.3-jdk-11 as MAVEN_BUILD
WORKDIR /polski-punish
COPY pom.xml .

RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target/

COPY src ./src

RUN mvn clean package -Dmaven.test.skip

FROM openjdk:11.0-jre
COPY --from=MAVEN_BUILD /polski-punish/target/polski-punish-0.0.1-SNAPSHOT.jar .
#run the app
CMD ["java", "-jar", "polski-punish-0.0.1-SNAPSHOT.jar"]

