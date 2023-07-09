FROM eclipse-temurin:17-jdk-alpine

COPY target/SampleMicroService-*.jar SampleMicroService.jar

ENTRYPOINT ["java","-jar","SampleMicroService.jar"]