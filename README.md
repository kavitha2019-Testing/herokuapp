# Herokuapp Automation Tests
This project contains automation tests for Herokuapp

### Tools Used
- Java8
- Selenium
- Webdrivermanager
- Junit
- Cucumber
- Maven

### How to run tests using maven
- mvn clean test (runs tests in dev environment)
- mvn clean test -Denvironment=qa (runs tests in qa environment)

### How to run tests using IDE
Run com.herokuapp.CucumberRunnerTest (runs tests in dev environment)
Run com.herokuapp.CucumberRunnerTest with system property "-Denvironment=qa" (runs tests in qa environment)

### How to check test reports
- Test reports can be found at: {ProjectHome}\target\reports\html\index.html

### Improvements todo
- Use property files to configure url, browser name and other environment specific information
- Define seperate configuration files for each environment (dev, qa, staging etc)
- Use Spring framework and cucumber-spring to create instances of dependencies
- Enhance project to run tests on other browsers Ex: IE, Firefox, Android Mobile Web, iPhone mobile web
- Add webdriver waits at the places needed
- Add browserstack or saucelab support
- Send notifications to Slack or Teams channel incase build fails
- Run tests against local selenium grid (Use docker)
