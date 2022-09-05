package seleniumtest.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.Page;

public class LoginPage extends Page {

    private static final XLogger LOGGER = XLoggerFactory.getXLogger(LoginPage.class.getName());


    @FindBy(id = "username")
    public static WebElement emailInput;

    @FindBy(id = "password")
    public static WebElement passwordInput;

    @FindBy(id = "btnSubmit")
    public static WebElement signInButton;

    public void typeIntoInputFields(String inputField, String text) {
        if (inputField.equals("username")) {
            DriverUtils.sendKeys(emailInput, text);
        } else if (inputField.equals("password")) {
            DriverUtils.sendKeys(passwordInput, text);
        } else LOGGER.error("Unknown inputField: {}", inputField);
    }

    public void clickButton(String buttonName) {
        if (buttonName.equals("Sign in")) {
            DriverUtils.clickElement(signInButton);
        } else LOGGER.error("Unknown Button: {}", buttonName);
    }
}
