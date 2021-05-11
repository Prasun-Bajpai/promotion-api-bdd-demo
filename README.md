# Promotion API BDD Complete Assignment

* [Required Software](#required-software)
* [How to execute the tests](#how-to-execute-the-tests)
   * [Running the test suites](#running-the-test-suites)
   * [Generating the test report](#generating-the-test-report)
* [About the Project Structure](#about-the-project-structure)
* [Libraries](#libraries)

This project was created to test Promotion REST API using Rest-Assured.
It tests the API: 
API Endpoint: http://api.intigral-ott.net/popcorn-api-rs-7.9.10/v1/promotions


## Required software
* Intellij IDEA/Eclipse
* Java JDK 8+
* JDK and Maven installed and Set in your classpath
* Clone/download the samplerestassureddemo project (https://github.com/Prasun-Bajpai/promotion-api-bdd-demo)

## How to execute the tests
Import the project into Intellij IDEA/Eclipse.
You can open the runner class(PromotionAPIRunnerTest) on `promotion-api-bdd-demo\src\test\java\com\intigral\api\runner\PromotionAPIRunnerTest.java` and execute it.
Or you can test it using mvn clean test command from command prompt or IDE.

### Running the test suites
The test suite can be run directly by your IDE or by command line.
If you run `mvn test` all the tests will execute because it's the regular Maven lifecycle to run all the tests.

### Generating the test report
On execution of test or mvn test command, test execution report get generated automatically.

You can access the reports at 'promotion-api-bdd-demo\target\cucumber-reports\index.html'

## About the Project Structure

### src/main/java/com/intigral/api

#### pojo
Contains pojo for all the objects present in the API response

#### utils
util package contains promotion API constants, helper and validator class for getting and setting the initial aspects to make the requests.

### src/test/java/com/intigral/api

#### PromotionAPIRunnerTest
This class runs the test cases by defining properties which binds the feature file and step class.
