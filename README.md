🚀 DemoWebShop Automation Framework

This project is a professional-grade test Automation Framework built using Java + Selenium WebDriver + TestNG + Cucumber (BDD) for automating test cases on the demowebshop E-Commerce practice site.
Designed with scalability and parallel execution. This project automates the end-to-end user journeys of the DemoWebShop e-commerce platform using a BDD approach.

🛠 Tech Stack
Language: Java 24 (JDK 8 compatible source)
Framework: Selenium WebDriver 4.33.0
Test Runner: TestNG + Cucumber
Design Pattern: Page Object Model (POM)
Infrastructure: Selenoid (Dockerized Selenium)
Build Tool: Maven

🏗 Architecture
The framework follows a modular structure to ensure maintainability:
BDD/Cucumber: Feature files written in Gherkin for business-readable tests.
Step Definitions: Mapping Gherkin steps to Java logic.
Page Objects: Encapsulated UI elements and actions for each page.
TestBase: Centralized driver initialization and configuration.
Parallel Execution: Configured via TestNG to run multiple scenarios across Selenoid containers.

🚦 Getting Started
1. Prerequisites
	i. Docker Desktop installed and running.
	ii. Maven (version 3.9.x+) installed.
	iii. Selenoid CM (Configuration Manager) downloaded.

2. Infrastructure Setup (Selenoid)
To run tests in a dockerized environment, start Selenoid with the fixed Docker API version:
PowerShell
	# Set API version for Windows/Docker Desktop compatibility
	$env:DOCKER_API_VERSION = "1.45"

	# Start Selenoid with VNC enabled
	.\cm.exe selenoid start --vnc --args "-container-network host"

	# Start Selenoid UI to view live tests
	.\cm.exe selenoid-ui start
3. Running Tests
	Execute the full suite via Maven:
		Bash
		mvn clean test
		📊 Features Automated

🛡 Handling Data Isolation
To support high-speed parallel execution, this framework utilizes:
Guest Session Isolation: Every test runs in a fresh Selenoid container, ensuring a clean, empty cart for every scenario.
ThreadLocal Driver: Ensures that multiple browser instances do not conflict during execution.
