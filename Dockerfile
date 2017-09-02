FROM openjdk:jre
ADD springpostgres.jar ./
ENTRYPOINT ["java","-jar","springpostgres.jar"]
