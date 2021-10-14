FROM openjdk:8
ENV GOOGLE_APPLICATION_CREDENTIALS=/mnt/c/users/dgupta/dipayan-trials-f0276b805827.json
ENV SPRING_CLOUD_GCP_LOGGING_PROJECT_ID=dipayan-trials
VOLUME /tmp
RUN mkdir /application
COPY . /application
WORKDIR /application
RUN /application/mvnw install
RUN mv /application/target/*.jar /application/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/application/app.jar"]
