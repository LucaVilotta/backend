FROM amazoncorretto:17-alpine-jdk

COPY out/artifacts/argpro_jar/argpro.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]

