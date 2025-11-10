# Generic application test automation framework

## Getting started
This project has been adjusted to run with Java 24 and Spring 3.5.x. Other dependencies are as per the
pom.xml present in the project.

The project also enforces Google's code formatter.

Build project using: `mvn clean install` and run tests using: `mvn test`

Simply clone the framework to get started with your tests. Model your system based on users (or actors)
that would affect the system. The demo tests available should serve as guidelines on how to model
tests representing user interaction with the system. The framework is opensource in order to allow
modifications/additions in the framework.

## Foreword

This repository is essentially a playground that allows the author to think about and
integrate different approaches and design patterns that are often employed by test automation
engineers to meet requirements for a test framework. It also contains some additional topics
such as dependency injection and property management which are generally an afterthought for
many engineers.

Typical patterns, features, tools etc. that are integrated in the framework.
- JUnit5 based testing setup
- Playwright integration
- Playwright - Cucumber integration demo tests
- Implementation of the *Screenplay* pattern

The basic framework is made up of some common tools and techniques that are most often
used by quality engineers. These are all time tested utilities that allow the author to
show a possibility of achieving any type of integration between them as needed by test
framework requirements.

The author has picked JUnit 5 as the choice of test tool and maven as the choice
of build tool. Author's own familiarity with these two tools is the prime reason for
such a choice.

The framework implements the screenplay pattern in plain Java, with some additional
code to allow the users to write their JUnit5 based tests in the *given()* - *when()* -
*then()* descriptive format. The screenplay pattern is seen here as an evolved version
of the command and query pattern, which most of quality engineers including the author
are aware of.

The framework also integrates cucumber jvm, allowing an opportunity to write specifications
in Gherkin language. In the Playwright-Cucumber demo tests, the author has explicitly used
Gherkin language based feature to describe the feature, and then used Playwright as the
frontend interaction tool.

There are demo tests that show usage of the framework for writing generic JUnit5 based tests,
followed by showing descriptive aka bdd way of writing JUnit5 tests.

The author has chosen to use Spring for dependency injection and configuration management. This
again is purely from author's perspective of familiarity with spring. It is safe to say, that
the framework would happily allow integration of dependency injection and configuration management
using other tools such as Micronaut.
