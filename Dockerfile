FROM openjdk:8
EXPOSE 8080
ADD target/starred-git-repositories-service.jar starred-git-repositories-service.jar
ENTRYPOINT ["java", "-jar", "/starred-git-repositories-service.jar"]