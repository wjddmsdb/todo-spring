FROM amazoncorretto:21
LABEL authors="eunyu"
WORKDIR /app
COPY ./build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]