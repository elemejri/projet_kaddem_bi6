FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8089
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kaddem-0.0.1.jar
ENTRYPOINT ["java","-jar","/kaddem-0.0.1.jar"]