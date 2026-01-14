FROM amazoncorretto:21
LABEL authors="eunyu"
WORKDIR /app
EXPOSE 8080
COPY ./build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]