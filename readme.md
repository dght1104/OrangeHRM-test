# Playwright Automation Testing Framework

## 1. Overview
This project is an automation testing framework built using Playwright with Java, following the Page Object Model (POM) design pattern for scalability and maintainability.

It supports:
- Functional Testing  
- Regression Testing  
- Cross-browser Testing  
- Data-driven Testing  

---

## 2. Tech Stack
- Language: Java  
- Automation Tool: Playwright  
- Build Tool: Maven  
- Test Framework: TestNG  
- Reporting: Allure Report  
- Design Pattern: Page Object Model (POM)  

---

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
---
## 4. How to Run 
```bash
    git clone https://github.com/dght1104/OrangeHRM-test.git
    cd OrangeHRM-test

# Build project
    mvn clean install -DskipTests

# Install Playwright browsers
    mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"

# Run all tests
    mvn test

# Run specific suite
    mvn test -DsuiteXmlFile=testng.xml

# Full flow (one command)
    mvn clean install -DskipTests && \
    mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install" && \
    mvn test -DsuiteXmlFile=testng.xml

# Generate Allure report
    allure generate allure-results --clean -o allure-report
    allure open allure-report
```

---
## 5. Key Features

- Page Object Model (POM) architecture
- Reusable and maintainable framework
- Data-driven testing support
- Cross-browser execution
- Allure reporting integration

## Author: Tran Dong Gia Han