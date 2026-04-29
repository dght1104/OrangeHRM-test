🧪 Playwright Automation Testing Framework
📌 Overview

This project is an automation testing framework built using Playwright with Java, following the Page Object Model (POM) design pattern for scalability and maintainability.

It is designed to support:

Functional Testing
Regression Testing
Cross-browser Testing
Data-driven Testing
🚀 Tech Stack
Language: Java
Automation Tool: Playwright
Build Tool: Maven
Test Framework: TestNG
Reporting: Allure Report
Design Pattern: Page Object Model (POM)
📂 Project Structure
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
⚙️ Setup & Installation
1. Clone project
git clone <your-repo-link>
cd <project-folder>
2. Build project
mvn clean install -DskipTests
3. Install Playwright browsers
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
▶️ Run Tests
Run all tests
mvn test
Run specific TestNG suite
mvn test -DsuiteXmlFile=stestng.xml
⚡ Quick Run (Full flow)
mvn clean install -DskipTests && \
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install" && \
mvn test -DsuiteXmlFile=stestng.xml
📊 Generate Allure Report
allure generate allure-results --clean -o allure-report
allure open allure-report
🧩 Key Features
Page Object Model (POM) architecture
Reusable and maintainable structure
Data-driven testing support
Cross-browser execution
🛠 Example Test Flow
loginStep.loginToTheApplication("Admin", "admin123");
employeeStep.navigateToEmployeePage();
employeeStep.addEmployee(firstName, middleName, lastName, empId);
⚠️ Notes
Ensure stestng.xml exists (or rename to testng.xml)
Run browser installation before executing tests
If gặp lỗi:
mvn clean
Author

Tran Dong Gia Han