# Web Automation with Selenium Documentation

## Project Overview

This project is an automation framework for web testing using Selenium and TestNG. It includes various features and best practices for writing and maintaining automated tests. The project structure is managed using Maven, and it leverages Selenium for browser automation and TestNG for test execution.

### Project Structure

The project structure follows Maven conventions and includes the standard Maven directories such as `src/main` and `src/test`. Key files include:

- `pom.xml`: Maven Project Object Model (POM) file defining project details, dependencies, and build configurations.
- `src/test/resources/testng.xml`: TestNG XML configuration file specifying test suite details.

## Project Dependencies

The project relies on several external libraries to facilitate testing. Here are the main dependencies specified in the `pom.xml` file:

- **Selenium**: Version 4.11.0
- **TestNG**: Version 7.5.1
- **Log4j**: Version 2.17.2
- **OpenCSV**: Version 5.6
- **Allure TestNG**: Version 2.17.0

These dependencies provide functionalities for browser automation, testing framework support, logging, CSV handling, and test reporting with Allure.

## Guidelines and Commit History

### Guidelines with Commit IDs

1. **[Basic Links](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/01fbecc18494a425702bbacb777712059a12fac0)**: Covers basic link interactions like `basicLink`, `partialLink`, `linkWithAttributes`, `linkInNewTab`, `dynamicLink`, and `redirectLink`.

2. **[Headless Browsers and Drivers](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/06010b04fb8f2481ce8a4f75b5b43578f71f19c9)**: Explains the usage of headless browsers and drivers.

3. **[Download/Upload File in Selenium](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/08d2c5c24270594f0905b3390fa0437dfb9f1d48)**: Describes how to handle file download and upload in Selenium.

4. **[TestNG Test Listeners (Test Suite Level)](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/bd5126106da0dc07059f71a957e4f539192b9306)**: Demonstrates the usage of TestNG Test Listeners at the test suite level.

5. **[Asserts: Soft vs. Hard Asserts](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/0fc13938b685184dd6427510caa52ec90064f7a0)**: Discusses the differences between soft and hard asserts.

... (and so on)

### Additional Topics

- **[Using JavaScriptExecutor](commit_link_here)**: Utilizes the JavaScriptExecutor interface for executing JavaScript code in Selenium.

- **[Allure Screenshots](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/2a9cc16b3e3c6b08a69dfd4d1cb770dd67afb7b1)**: Introduces the capturing of screenshots with Allure.

- **[TestNG DataProviders](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/5740ab96ce98a6d3136beae355a6667af75b7873)**: Explains the usage of TestNG DataProviders for data-driven testing.
- 
- **[Parallel Test execution](https://github.com/ashik-e-rabbani/Web-automation-with-selenium/commit/5fca6ac5ae3628ea48ef04a55f53a65f2bab18d7)**: Use the paraller driver initalization thru ThreadLocal so each test class will have different driver thread to perform individual actions.

... (and so on)

## Selenium Best Practices and Design Patterns

### Page Object Model (POM)

The project follows the Page Object Model (POM) design pattern for structuring Selenium tests. Page Object Classes encapsulate web page details and functionalities, providing better code organization and reusability.

### Browser Driver Factory

The Browser Driver Factory is implemented as a design pattern to manage the creation and configuration of web browser drivers dynamically.

### Test Utilities

Test utilities are provided to support and simplify the testing process. These utilities enhance code readability and maintainability.

### Running Tests in Parallel

Tests are designed to run in parallel using the parallel driver initialization through ThreadLocal. This ensures that each test class has a different driver thread for performing individual actions.

## Documentation Contributors

- **Author**: **[Ashik E Rabbani - LinkedIn](https://www.linkedin.com/in/ashik-e-rabbani/)**

- **Contributors**: [Are you one of them? Let's dive!]

For additional details on individual topics, refer to the corresponding commits and their associated documentation.

