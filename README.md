# Customer-Account-Service of the Ardalo Digital Platform
[![Build Status](https://github.com/ardalo/adp-customer-account-service/actions/workflows/main.yml/badge.svg)](https://github.com/ardalo/adp-customer-account-service/actions/workflows/main.yml)
[![License](https://img.shields.io/github/license/ardalo/adp-customer-account-service)](https://github.com/ardalo/adp-customer-account-service/blob/main/LICENSE)
[![Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=ardalo_adp-customer-account-service&metric=coverage)](https://sonarcloud.io/summary/new_code?id=ardalo_adp-customer-account-service)

Ardalo Digital Platform service taking care of the customer account domain.

## Infrastructure
* [Swagger UI](http://adp-customer-account-service.api.ardalo.com/)

## Quick Start
* Start application and find API docs at `http://localhost:8080`
  ```console
  $ ./gradlew bootRun
  ```
* Run tests
  ```console
  $ ./gradlew clean test
  ```
* Generate Code Coverage Report. HTML report can be found in `./build/reports/jacoco/test/html`
  ```console
  $ ./gradlew check jacocoTestReport
  ```
* Build docker image via gradle and run docker container via `docker compose`. Find API docs at `http://localhost:8080`
  ```console
  $ ./gradlew bootBuildImage --imageName=ardalo/adp-customer-account-service
  $ docker compose up
  ```
* Check for outdated dependencies via [Gradle Versions Plugin](https://github.com/ben-manes/gradle-versions-plugin)
  ```console
  $ ./gradlew dependencyUpdates -Drevision=release
  ```
* Check for vulnerable dependencies via [OWASP Dependency-Check Plugin](https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html). HTML report can be found in `./build/reports/dependency-check-report.html`
  ```console
  $ ./gradlew dependencyCheckAnalyze
  ```
* Update gradle wrapper to latest gradle version
  ```console
  $ ./gradlew wrapper --gradle-version latest
  ```
