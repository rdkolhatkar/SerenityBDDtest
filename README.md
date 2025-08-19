# 🚀 SerenityBDDtest

A **UI Test Automation Project** using **Serenity BDD**, **Java**, **Maven**, and **Selenium WebDriver**.  
This project demonstrates how to write clean, maintainable, and well-documented UI automation tests with **Serenity reports**.

---

## 📂 Project Overview

**Tech Stack:**
- ☕ Java 11+
- 🧩 Maven 3.6+
- 🎭 Serenity BDD
- ✅ JUnit
- 🌐 Selenium WebDriver
- 🌍 Chrome / Firefox

---

## 📁 Project Structure  

SerenityBDDtest/
├── src/
│ ├── test/
│ │ ├── java/ # Test implementations
│ │ └── resources/ # Test resources and configurations
└── pom.xml # Maven configuration file


---

## ⚙️ Key Dependencies (`pom.xml`)

```xml
<properties>
    <serenity.version>4.2.3</serenity.version>
    <serenity.maven.version>3.5.0</serenity.maven.version>
    <webdriver.driver>chrome</webdriver.driver>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

<dependencies>
    <dependency>
        <groupId>net.serenity-bdd</groupId>
        <artifactId>serenity-core</artifactId>
        <version>${serenity.version}</version>
    </dependency>
    <dependency>
        <groupId>net.serenity-bdd</groupId>
        <artifactId>serenity-junit</artifactId>
        <version>${serenity.version}</version>
    </dependency>
    <dependency>
        <groupId>net.serenity-bdd</groupId>
        <artifactId>serenity-selenium</artifactId>
        <version>${serenity.version}</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.9.0</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    </dependency>
</dependencies>
<build>
    <plugins>
        <plugin>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-maven-plugin</artifactId>
            <version>${serenity.maven.version}</version>
            <executions>
                <execution>
                    <goals>
                        <goal>aggregate</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
🛠️ Configuration (serenity.conf)
```groovy   
webdriver {
    driver = chrome
}
serenity {
    project.name = "SerenityBDDtest"
    take.screenshots = FOR_FAILURES
    timeout = 5000
}
serenity {
    reports {
        outputDirectory = "target/site/serenity"
    }
}
``` 
▶️ Running Tests
```bash
mvn clean verify
mvn clean verify serenity:aggregate
mvn clean verify -Dtest=LoginTest
mvn clean verify -Dwebdriver.driver=firefox
mvn clean verify -DforkCount=2 -DreuseForks=true
```
📊 Serenity Reports

After test execution, open:
👉 target/site/serenity/index.html

You’ll see detailed visual reports with steps, screenshots, and test results.

📝 Example Test
```java
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed
    WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Test
    public void user_can_login() {
        loginSteps.opens_login_page();
        loginSteps.logs_in_with("user", "password");
        loginSteps.should_see_home_page();
    }
}
```
🔗 CI/CD Integration
✅ GitHub Actions Example
```yaml
name: Serenity BDD Tests
on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Run Serenity BDD Tests
        run: mvn clean verify serenity:aggregate

      - name: Upload Serenity Report
        uses: actions/upload-artifact@v3
        with:
          name: serenity-report
          path: target/site/serenity    
```