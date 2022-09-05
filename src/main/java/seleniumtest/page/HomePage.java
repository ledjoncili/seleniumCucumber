package seleniumtest.page;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.Page;

public class HomePage extends Page {

    private static final XLogger LOGGER = XLoggerFactory.getXLogger(HomePage.class.getName());

    @FindBy(id = "menuMdb")
    private static WebElement repositoryItem;

    @FindBy(id = "menuUser")
    private static WebElement userIconItem;

    @FindBy(id = "menuMdbStudies")
    private static WebElement studiesMenuItem;

    @FindBy(id = "switchEditMode")
    private static WebElement editFormButton;

    @FindBy(id = "assetLocaleEditTextTextareadescription")
    private static WebElement descriptionInputField;

    @FindBy(id = "saveAsset")
    private static WebElement saveAssetButton;

    @FindBy(id = "formDescription")
    private static WebElement formDescriptionValue;

    @FindBy(id = "menuUserLogout")
    public static WebElement logOutButton;

    @FindBy(css = ".signOut-reason")
    public static WebElement signOutReason;

    public void hoverOverItem(String itemName) {
        if (itemName.equals("repository")) {
            DriverUtils.hoverOverElement(repositoryItem);
        } else if (itemName.equals("user icon")) {
            DriverUtils.hoverOverElement(userIconItem);
        } else LOGGER.info("Unknown item: {}", itemName);
    }

    public void clickItemFromMenu(String item) {
        if (item.equals("Studies")) {
            DriverUtils.clickElement(studiesMenuItem);
        } else LOGGER.info("Unknown element: {}", item);
    }

    public void clickFormViewButton(String formsViewButtonName) {
        if (formsViewButtonName.equals("Edit form")) {
            DriverUtils.clickElement(editFormButton);
        } else if (formsViewButtonName.equals("Validate & Update")) {
            DriverUtils.clickElement(saveAssetButton);
        } else LOGGER.info("Button: {} not found!", formsViewButtonName);
    }

    public void typeInFormViewInputFields(String text, String inputField) {
        if (inputField.equals("description")) {
            DriverUtils.sendKeys(descriptionInputField, text);
        }
    }

    public void checkFormFieldValue(String formField, String expectedText) {
        WebElement webElement = null;
        if (formField.equals("description")) {
            webElement = formDescriptionValue;
        } else LOGGER.info("Unknown form field: {}", formField);

        if (webElement != null) {
            DriverUtils.getWait().until(ExpectedConditions.textToBePresentInElement(webElement, expectedText));
            Assert.assertEquals(expectedText, webElement.getText());
        }
    }
}
