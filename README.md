# test-g2a
Test scenario:
URL: https://www.g2a.com

G2A Product Price Verification Automation

Overview

This project is a Selenium-based test automation suite designed to verify product pricing on the G2A website. The automation checks the price of a product on its detail page and in the shopping cart for an unauthenticated user. The test is parameterized to accept a product name and generates a detailed HTML report using ExtentReports.

Features

Parameterized Tests: Accepts a product name as a command-line parameter for flexible testing.
HTML Reporting: Utilizes ExtentReports to generate rich HTML reports with detailed logs and screenshots.
Docker Integration: Offers Docker configuration for consistent test execution across different environments.
Page Object Model: Implements the Page Object Model (POM) for maintainable and scalable test code.

Project Structure

src/main/java/test/g2a/pages/G2APage.java: Contains web elements and methods for interactions with the G2A website.
src/main/java/test/g2a/G2AautomationTest.java: Implements the test scenario.
src/main/java/test/g2a/config/TestBase.java: Provides base setup for WebDriver and ExtentReports.
src/main/java/test/g2a/utils/ScreenshotUtil.java: Utility class for capturing screenshots.
Dockerfile: Docker configuration for running tests in a container.

Prerequisites

Java 17: Make sure Java 17 is installed on your machine.
Gradle: The project is built with Gradle.
Docker: Required to run the tests within a containerized environment.
Getting Started

1. Clone the Repository
git clone https://github.com/yourusername/g2a-automation.git
2. Build the project using Gradle to resolve dependencies and compile the code:
./gradlew build
3. Running Tests Locally
./gradlew test -PproductName="Cyberpunk 2077 & Phantom Liberty Bundle (PC) - Steam Account - GLOBAL"
4. Running Tests with Docker
   Build the Docker Image
docker build -t g2a-gradle-test .
Run the Docker Container
docker run --rm g2a-gradle-test

