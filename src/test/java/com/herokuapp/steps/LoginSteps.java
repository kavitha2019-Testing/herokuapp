package com.herokuapp.steps;

import com.herokuapp.pages.LoginPage;
import com.herokuapp.pages.WelcomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.herokuapp.util.PropertiesReader.getPropertiesReader;
import static org.hamcrest.core.StringContains.containsString;

public class LoginSteps {

    private WebDriver driver;

    private LoginPage loginPage;
    private WelcomePage welcomePage;

    public LoginSteps() {
        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
        welcomePage = new WelcomePage(driver);
    }

    @Given("I am on Heroku login page")
    public void i_am_on_Heroku_login_page() {
        loginPage.open(getPropertiesReader().getProperty("url"));
    }

    @When("I login with {string} and {string}")
    public void i_login_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be able to successfully login")
    public void i_should_be_able_to_successfully_login() {
        boolean isLogoutLinkDisplayed = welcomePage.isLogoutLinkDisplayed();
        Assert.assertTrue("Logout link is not displayed on home page", isLogoutLinkDisplayed);
    }

    @Then("I should not be able to login")
    public void i_should_not_be_able_to_login() {
        String loginError = loginPage.findLoginError();
        String expectedErrorMessage = "Your password is invalid!";
        Assert.assertThat(loginError, containsString(expectedErrorMessage));
    }

}
