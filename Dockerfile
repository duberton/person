FROM openjdk:11-jre-slim

EXPOSE 7000

ADD target/person*.jar /usr/share/app.jar

ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]