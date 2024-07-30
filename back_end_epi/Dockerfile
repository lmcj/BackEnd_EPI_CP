FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/back_end-0.0.1.jar
COPY ${JAR_FILE} app_back_end_epi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_back_end_epi.jar"]