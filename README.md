# TicTacToe
Application to play TicTacToe

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

1. One way is to execute the `main` method in the `com.github.tictactoe.TicTacToeApplication` class from your IDE(Open as java project using pom.xml).
2. You can also run it via below commands to create a jar and run the application. Maven should be configured.
    a. Open a command prompt window and go to the root directory(\tic-tac-toe) of the application.
    b. run command -> ```mvn package```. This will create a jar of application in target folder
    c. Go to target folder and run command -> ```java -jar tictactoe-0.0.1-SNAPSHOT.jar```

```shell
mvn spring-boot:run
```
Once the application is started , you can start playing TicTacToe.
