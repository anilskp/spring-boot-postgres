FROM openjdk:jre
ADD target/springpostgres.jar ./
ENTRYPOINT ["java","-jar","springpostgres.jar"]
