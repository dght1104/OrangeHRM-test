# Playwright Automation Testing Framework

# 1. Overview
# This project is an automation testing framework built using Playwright with Java,
# following the Page Object Model (POM) design pattern.

# Supports:
# - Functional Testing
# - Regression Testing
# - Cross-browser Testing
# - Data-driven Testing

# 2. Tech Stack
# - Java
# - Playwright
# - Maven
# - TestNG
# - Allure Report
# - POM Design Pattern

# 3. Project Structure
# src
# ├── main/java
# │   ├── pages
# │   ├── locators
# │   └── utils
# ├── test/java
# │   ├── tests
# │   ├── steps
# │   └── base
# └── resources
#     ├── config
#     └── testdata


# 4. Setup & Installation

# Clone project
git clone <your-repo-link>
cd <project-folder>

# Build project
mvn clean install -DskipTests

# Install Playwright browsers
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"


# 5. Run Tests

# Run all tests
mvn test

# Run TestNG suite
mvn test -DsuiteXmlFile=testng.xml


# 6. Quick Run
mvn clean install -DskipTests && \
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install" && \
mvn test -DsuiteXmlFile=testng.xml


# 7. Allure Report
allure generate allure-results --clean -o allure-report
allure open allure-report


# 8. Notes
# Ensure testng.xml exists
# Install browsers before running
mvn clean


# 9. Author
# Tran Dong Gia Han
