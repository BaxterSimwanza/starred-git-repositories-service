# STARRED GITHUB REPOSITORIES SERVICE

Starred GitHub Repositories Service is a Spring Boot web applictation which consumes filtered data from the publicly available GitHub API and reformats it before serving it to the client.

## Application Features
* The application requests the GitHub API for the top starred GitHub repositories in a given period.
* The default period of the said request is the last 30 days from the current date.
* The client must specify in the URL upon calling this service the number of top repositories to get from the GitHub API prior to data treatment.
* Once the application recieves the top starred repositories data from the GitHub public API, it restructures it by the programming-language.
* It returns a list of programming-laguages, the number of starred-repositories using this language and a list of their names.

## Getting Started
There are two recommended ways to run this project: With Docker or as a Spring Boot App in your Java IDE. But first, clone the GitHub repository.
### Method 1: Docker
* Install Docker on your computer. If you are on linux, make sure to install docker-compose aswell.
* First run Docker, and in your terminal go to the root folder of the application.
To build the application for the first time simply run this command
```
docker-compose up --build
```
The application should now be running on localhost port 9090. In order to access the **starred-git-repositories-service**  go to this link on your browser
```
(http://localhost:9090/top-github/languages/repositories=75)
```
You can change the number of repositories in the URL from 75 to 95 for example by simply putting repositories=95 in the URL. Numbers below 1 will return 100 repositories by default. In order to stop the service, run this command
```
docker-compose down
```
To re-run the service without re-building the image, use
```
docker-compose up -d
```
### Method 2: Java IDE (Eclipse JEE or Spring Tool Suite)
* Download and install a Java Virtual Machine and a Java Development Kit on your computer
* Import the project as a maven project inside your IDE and it will automatically download your web dependancies from the maven repository
* Right click on the project folder, go to **Run as -> Spring Boot App**
The application should now be running on localhost port 8080. In order to access the **starred-git-repositories-service**  go to this link on your browser
```
(http://localhost:8080/top-github/languages/repositories=75)
```
You can change the number of repositories in the URL from 75 to 95 for example by simply putting repositories=95 in the URL. Numbers below 1 will return 100 repositories by default. In order to stop the service, run this command

## Built With
* [Java 8](https://www.oracle.com/java/technologies/java8.html) - Java is a general-purpose, class-based, object-oriented programming language designed for having lesser implementation dependencies.
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot is an open-source micro framework maintained by a company called Pivotal. It provides Java developers with a platform to get started with an auto configurable production-grade Spring application
* [Docker](https://spring.io) - Spring is a flexible and lightweight Java framework primarily used for building web applications.
* [Maven](https://maven.apache.org/) - Maven is a build automation tool used primarily for Java projects.

The application is a micro-service and has no front-end, this means that it returns a JSON object.

## Conclusion
The application should work perfectly if you follow the instructions and have an internet connection. Improvements can always be made, the following are a list of features not yet added to the application
* Customized Exception handling
* Spring security
* Customizable time interval, 30 days is the default setting