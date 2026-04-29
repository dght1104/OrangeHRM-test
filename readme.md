# OrangeHRM Test Automation Framework
> A scalable Playwright-based automation testing framework for web applications.

## 1. Overview
This project is an automation testing framework built using Playwright with Java, following the Page Object Model (POM) design pattern to ensure scalability, maintainability, and reusability.

It is designed to automate testing for the [OrangeHRM Demo Application](https://opensource-demo.orangehrmlive.com/), a web-based human resource management system.

The framework focuses on validating core functionalities, including:
- User authentication (Login)  
- Employee management workflows  
- Basic user interactions and navigation  

## 2. Tech Stack
- Language: Java (21)  
- Automation Tool: Playwright (1.45.0)  
- Test Framework: TestNG (7.9.0)  
- Build Tool: Maven  
- Reporting: Allure (2.24.0)  
- Design Pattern: Page Object Model (POM)  

## 3. Project Structure
```bash
    src
    ├── main
    │   ├── java
    │   │   └── com/orangehrm
    │   │       ├── allure          # Allure helpers 
    │   │       ├── annotations     # Custom annotations 
    │   │       ├── aspects         # AOP logic 
    │   │       ├── constants       # Constant values
    │   │       ├── dto             # Data Transfer Objects
    │   │       ├── enums           # Enum definitions 
    │   │       ├── helpers         # Helper classes
    │   │       ├── managers        # Driver / config / page manager 
    │   │       └── utils           # Utility classes
    │   └── resources
    │       └── config              # Configuration files 
    │
    └── test
        ├── java
        │   └── com/orangehrm
        │       ├── allure          # Test-level Allure integration 
        │       ├── listeners       # TestNG listeners 
        │       ├── pom             # Page Object Model classes
        │       └── testcases       # Test cases 
        └── resources
            └── suites              # TestNG suite XML files 
```
## 4. How to Run 

1. Clone the project
```bash
    git clone https://github.com/dght1104/OrangeHRM-test.git
    cd OrangeHRM-test
```

2. Build project
```bash
    mvn clean install -DskipTests
    mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```
3. Run all test
```bash
    mvn test "-DsuiteXmlFile=testng.xml"
```

4. Run a specific suite
```bash
    mvn test "-DsuiteXmlFile=src\test\resources\suites\OrangeHRM_01_VerifyLoginFunctionality.xml"
```

5. Generate Allure report
```bash
     allure serve target/allure-results      
```

---
## 5. Key Features

- Page Object Model (POM) architecture
- Reusable and maintainable framework
- Data-driven testing support
- Cross-browser execution
- Allure reporting integration

## 6. Test Coverage
The framework includes automated test scenarios such as:
- Login functionality validation  
- Employee creation and management  
- Navigation and UI interaction flows  

## Author
**Tran Dong Gia Han**  