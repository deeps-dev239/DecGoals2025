# DecGoals2025
# 🧪 Selenium Automation Framework

This repository contains a **Selenium Test Automation Framework** built using **Java, TestNG, and Maven**.  
The framework supports **Cross-Browser testing (Chrome & Edge)** and is integrated with **GitHub Actions** for **CI/CD automation**.

---

## 📌 Tech Stack Used

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- GitHub Actions (CI/CD)

---

## 📂 Project Structure

├── src
│ ├── test
│ │ ├── java
│ │ │ ├── tests → All test classes (Login, Outlet, Kitchen, etc.)
│ │ │ ├── utils → BaseTest and utility classes
│ │ │ └── pages → Page Object Model classes
│ │ └── resources
│
├── testng.xml → TestNG suite file
├── pom.xml → Maven dependencies
└── README.md


java -version
mvn -version

Project Setup
Project is created locally as a Maven TestNG Automation Framework
Page classes, test classes, utilities, and pom.xml are manually created
Dependencies are managed using Maven
Browser configuration is handled in the BaseTest class

Install dependencies:
mvn clean install

- Test Execution Commands
Run All Tests Using TestNG XML
mvn test -Dsurefire.suiteXmlFiles=testng.xml
Run Tests from IDE
Right-click on testng.xml

Select Run as → TestNG Suite

CI Execution (GitHub Actions)
Tests are executed automatically on code push or pull request

Maven command used in CI:
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
