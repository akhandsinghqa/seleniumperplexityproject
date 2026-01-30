# 🧪 Selenium Java Automation Framework

A scalable, maintainable Selenium automation framework built with **Java**, **TestNG**, **Allure Reporting**, and the *
*Page Object Model (POM)** design pattern.

## 📚 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Configuration Setup](#configuration-setup)
- [Running the Tests](#running-the-tests)
- [Generating Allure Reports](#generating-allure-reports)
- [Best Practices](#best-practices)
- [Contributing](#contributing)
- [License](#license)

---

## ✅ Features

- Cross-browser support: Chrome, Firefox, Edge
- Local and remote (Grid) execution support
- Page Object Model (POM) design pattern
- Parameterized execution with TestNG
- Thread-safe WebDriver using DriverFactory
- Screenshot capture on failures
- Allure reporting support
- Utility classes for waits, config, and screenshots

---

## 🛠 Tech Stack

| Layer              | Tool / Library         |
|--------------------|------------------------|
| Language           | Java 11+               |
| Build Tool         | Maven                  |
| Testing Framework  | TestNG                 |
| WebDriver          | Selenium WebDriver     |
| Reporting          | Allure                 |
| Logging (optional) | Log4j2 / Console       |
| Data               | `.properties`, `.json` |

---

## 📁 Project Structure

``` 
src/
├── main/
│ ├── java/
│ │ └── com.perplexity.automation/
│ │ ├── pages/ # Page Object classes
│ │ ├── utils/ # Utility classes (Driver, Config, Screenshot, Wait)
│ │ └── constants/ # Framework-wide constants
│ └── resources/
│ ├── configs/ # Configuration.properties file
│ └── log4j2.xml # Logging configuration
│
└── test/
├── java/
│ └── com.example.automation/
│ ├── base/ # BaseTest and TestNG listeners
│ └── tests/ # Test classes
└── resources/
└── testng.xml # TestNG suite configuration
```

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browsers installed
- IntelliJ IDEA / Eclipse IDE
- Allure CLI (optional for report generation)

### 📥 Clone the Project

- git clone https://github.com/your-org/selenium-java-framework.git
- cd selenium-java-framework

### 📦 Install Dependencies

- mvn clean install

---

## ⚙️ Configuration Setup

- Update the `Configuration.properties` file at:
  src/main/resources/configs/Configuration.properties

### Sample content:

- base_url=https://example.com
- browser=firefox
- run_mode=local
- grid_url=http://localhost:4444/wd/hub
- implicit_wait=10
- username=testuser
- password=password123

---

## 🧪 Running the Tests

### ▶️ Using Maven:

- mvn clean test -DsuiteXmlFile=testng.xml

### ▶️ Using IntelliJ / Eclipse:

- Right-click on `testng.xml`
- Choose **Run 'testng.xml'**

---

## 📊 Generating Allure Reports

1. Run the tests, which creates Allure results:
    - mvn clean test

2. Generate and open the report:
    - allure serve target/allure-results

> 💡 Make sure Allure CLI is installed. Install from:
> 👉 https://docs.qameta.io/allure/#_get_started

---

## 🧠 Best Practices

- Keep all web element locators private and scoped to their Page Object.
- Use descriptive and reusable page methods.
- Use utility classes (e.g., `WaitUtils`, `ScreenshotUtils`) to avoid repeating code.
- Never hardcode credentials—use external property files or environment variables.
- Encapsulate common actions in `BasePage` and test lifecycle in `BaseTest`.
- Use `ThreadLocal<WebDriver>` in `DriverFactory` to ensure thread safety for parallel execution.

---

## 🤝 Contributing

We welcome contributions! To contribute:

1. Fork the repo
2. Create a new branch:
    - git checkout -b feature/your-feature-name
3. Make your changes & commit:
    - git commit -am "Added new feature"

4. Push the branch:
    - git push origin feature/your-feature-name
5. Create a Pull Request

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Maintained By

**Your Name / Your Organization**  
Contact: [your-email@example.com](mailto:your-email@example.com)  
GitHub: [github.com/your-org](https://github.com/your-org)

---

> 📌 Need CI/CD support or Grid/Docker integration? Let us know, we’ll help you scale 🚀.