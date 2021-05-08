package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@href='/logout']")
    private WebElement logoutLink;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout(String url) {
        logoutLink.click();
    }

    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }
}
