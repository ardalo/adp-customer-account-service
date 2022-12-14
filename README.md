# Customer-Account-Service of the Ardalo Digital Platform
![Build Status](https://github.com/ardalo/adp-customer-account-service/workflows/Build/badge.svg)
![License](https://img.shields.io/github/license/ardalo/adp-customer-account-service)
[![Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=ardalo_adp-customer-account-service&metric=coverage)](https://sonarcloud.io/summary/new_code?id=ardalo_adp-customer-account-service)

Ardalo Digital Platform service taking care of the customer account domain.

## Infrastructure
* [Swagger UI](http://adp-customer-account-service.api.ardalo.com/)

## Local Development
* Start application and find API docs at `http://localhost:8080`
  ```console
  $ ./gradlew bootRun
  ```
* Run tests
  ```console
  $ ./gradlew clean test
  ```
* Generate Code Coverage Report. HTML Report can be found in `./build/reports/jacoco/test/html`
  ```console
  $ ./gradlew check jacocoTestReport
  ```
* Build docker image via gradle and run docker container via `docker compose`. Find API docs at `http://localhost:8080`
  ```console
  $ ./gradlew bootBuildImage --imageName=ardalo/adp-customer-account-service
  $ docker compose up
  ```
* Check for updated dependencies via [Gradle Versions Plugin](https://github.com/ben-manes/gradle-versions-plugin)
  ```console
  $ ./gradlew dependencyUpdates -Drevision=release
  ```
