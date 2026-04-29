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
├── main/java
│   ├── pages        # Page Object classes
│   ├── locators     # UI locators
│   └── utils        # Utilities
│
├── test/java
│   ├── tests        # Test cases
│   ├── steps        # Business logic layer
│   └── base         # Base setup
│
└── resources
    ├── config       # Configuration files
    └── testdata     # Test data

4. Setup & Installation
4.1 Clone project
git clone <your-repo-link>
cd <project-folder>
4.2 Build project
mvn clean install -DskipTests
4.3 Install Playwright browsers
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
5. Run Tests
5.1 Run all tests
mvn test
5.2 Run specific TestNG suite
mvn test -DsuiteXmlFile=testng.xml
6. Quick Run (Full Flow)
mvn clean install -DskipTests && \
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install" && \
mvn test -DsuiteXmlFile=testng.xml
7. Generate Allure Report
allure generate allure-results --clean -o allure-report
allure open allure-report
8. Key Features
Page Object Model (POM) architecture
Reusable and maintainable framework
Data-driven testing support
Cross-browser execution
Allure reporting integration
9. Example Test Flow
loginStep.loginToTheApplication("Admin", "admin123");
employeeStep.navigateToEmployeePage();
employeeStep.addEmployee(firstName, middleName, lastName, empId);
10. Notes
Ensure testng.xml exists
Install browsers before running tests
If errors occur:
mvn clean
11. Author

Tran Dong Gia Han
