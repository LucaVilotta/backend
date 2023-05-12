FROM amazoncorretto:17-alpine-jdk

COPY out/artifacts/argpro_jar/argpro.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

