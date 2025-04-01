# DHL Transit Time Automation Project

## Overview
This project automates the testing of the **DHL European Road Freight Transit Time Calculator** using **Java, Selenium, and TestNG**. The purpose of this automation is to verify the functionality of the tool, validate input fields, and ensure correct transit time calculations for different destination countries.

## Tech Stack
- **Programming Language:** Java
- **Automation Framework:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)

## Features
- Automated validation of transit time calculator functionality
- Input field validation for valid and invalid test cases
- Use of Page Object Model for maintainability
- Centralized WebDriver management

## Project Structure
```
DHLTransitTimeAutomation/
│── src/main/java/
│   ├── pages/                 # Page Object Model classes
│   ├── utils/                 # WebDriver Manager & Helper utilities
│── src/test/java/
│   ├── tests/                 # Test classes for valid & invalid inputs
│── pom.xml                    # Maven dependencies and configurations
│── testng.xml                 # TestNG test execution configuration
```

## Setup & Installation
### Prerequisites
1. Install **Java JDK (17 or above)**
2. Install **Maven**
3. Install **Google Chrome** (Latest Version)
4. Install **ChromeDriver** (Ensure it matches Chrome version)
5. Install **Eclipse/IntelliJ IDEA**

### Steps to Run the Tests
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repository/DHLTransitTimeAutomation.git
   ```
2. Navigate to the project folder:
   ```sh
   cd DHLTransitTimeAutomation
   ```
3. Run tests using Maven:
   ```sh
   mvn clean test
   ```
4. Run tests using TestNG in Eclipse:
   - Open `testng.xml`
   - Right-click and **Run As > TestNG Suite**

## Test Scenarios
- **Valid Input Test:**
  - Enter valid origin and destination countries
  - Click Calculate and verify transit time is displayed
- **Invalid Input Test:**
  - Enter incorrect values and verify error message
  - Leave fields blank and check validation messages

## Reporting
- **Test Reports:** Automatically generated in `target/surefire-reports`

## Contributors
- **Seema Gupta** - Automation Tester

## License
This project is open-source and available for modification and enhancement.

