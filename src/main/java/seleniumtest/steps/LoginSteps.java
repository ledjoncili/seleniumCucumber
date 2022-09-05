package seleniumtest.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumtest.page.LoginPage;
import seleniumtest.utils.DriverUtils;

public class LoginSteps {
    private static LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @And("^we type '(.+?)' in the '(.+?)' input field$")
    public void typeInTheInputField(String text, String inputField) {
        loginPage.typeIntoInputFields(inputField, text);
    }

    @Then("^make sure user user is successfully logged in$")
    public void makeSureUserUserIsSuccessfullyLoggedIn() {
        DriverUtils.getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("fdxMainNav")));
    }

    @And("^we click '(.+?)' button$")
    public void clickButton(String buttonName) {
        loginPage.clickButton(buttonName);
    }
}
