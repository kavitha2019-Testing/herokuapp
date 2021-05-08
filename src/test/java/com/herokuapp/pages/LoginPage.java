package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "username")
    private WebElement loginInputField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "flash-messages")
    private WebElement loginError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs("The Internet"));
    }

    public void login(String username, String password) {
        loginInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public String findLoginError() {
        return loginError.getText();
    }

}
