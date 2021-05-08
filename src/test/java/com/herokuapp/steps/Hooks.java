package com.herokuapp.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    /**
     * The static driver is initialised only once before first test
     * It is closed after all tests
     */
    public static WebDriver driver;

    /**
     * This method is run before each test
     * Open browser before first test.
     */
    @Before
    public void openDriver() {
        if (driver == null) {
            createDriver();
        }
    }

    /**
     * This method is run after each test
     * Delete all cookies from browser after each test
     * If test fails, save the browser screenshot to reports
     */
    @After
    public void after(Scenario scenario) {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

    private void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();// decide it from env
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
