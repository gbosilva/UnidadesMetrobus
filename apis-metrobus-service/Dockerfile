FROM openjdk:8
ADD target/apis-metrobus-service-0.0.1-SNAPSHOT.jar apis-metrobus-service.jar
EXPOSE 8091
RUN ["apt-get", "update"]
RUN ["apt-get", "install", "-y", "nano"]
ENTRYPOINT ["java", "-jar","/apis-metrobus-service.jar"]