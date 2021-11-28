## Getting Started

The project uses [Maven](https://maven.apache.org/) to manage build and dependencies.

From the root of the project execute:

- `./mvnw test` to execute the test suite
- `./mvnw spring-boot:run` to run the project
- `./mvnw package` to compile and package, the JAR will be available in `target/`

Or alternatively build, test, and run using the IDE of your choice, e.g. IntelliJ.

## Staring API

From the root of this project, run ```./mvnw spring-boot:run``` in the terminal to start the program. Alternatively,
build a jar with maven using the life cycle tools window or by using ```./mvnw clean package``` from the root of the
project.

If you choose to create a jar, run ```java -jar target/challenge-0.0.1-SNAPSHOT.jar```
in the terminal from the root of the project to start the program.

## Using the API

To use the API, you must submit a GET request from your browser or another application such as Postman. The request must
be in the form ```http://localhost:8080/bisection?a=INT&&b=INT``` where the following conditions must be true:

- a < b

- either f(a) < 0 and f(b) > 0 or f(a) > 0 and f(b) < 0.

- a and b must an integer

A valid example would be:

```http://localhost:8080/bisection?a=-4&&b=4```

An invalid example would be:

```http://localhost:8080/bisection?a=-5&&b=-5```