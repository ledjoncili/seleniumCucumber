package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumtest.page.HomePage;
import seleniumtest.utils.DriverUtils;

import java.util.List;
import java.util.stream.Collectors;

public class HomeSteps {
    private static HomePage homePage;
    private static WebDriver driver;

    public HomeSteps() {
        homePage = new HomePage();
        driver = DriverUtils.getDriver();
    }

    @When("^we hover over '(.+?)' item$")
    public void hoverItem(String itemName) {
        homePage.hoverOverItem(itemName);
    }

    @And("^we click '(.+?)' item from repository nav-menu$")
    public void clickRepoMenuItem(String item) {
        homePage.clickItemFromMenu(item);
    }

    @Then("^check the following options are shown under Tech Study$")
    public void checkOptions(DataTable dataTable) {
        List expectedOptions = dataTable.asList(String.class);
        By optionSelector = By.cssSelector(".container-item-properties strong");
        DriverUtils.getWait().until(ExpectedConditions.presenceOfElementLocated(optionSelector));
        List<String> actualOptions = driver.findElements(optionSelector).stream().map(WebElement::getText).collect(Collectors.toList());

        if (expectedOptions.size() == actualOptions.size()) {
            expectedOptions.forEach(option -> Assert.assertTrue(actualOptions.contains(option)));
        } else Assert.fail();
    }

    @Then("^enter '(.+?)' view$")
    public void enterView(String viewName) {
        By dynamicViewSelectorByName = By.xpath("//div[@class='container-item-name']/h1[text()='" + viewName + "']");
        DriverUtils.clickElement(driver.findElement(dynamicViewSelectorByName));
        DriverUtils.getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='breadcrumb-title'][text()='" + viewName + "']")));
    }

    /**
     * This method clicks all subcategories from group view taking as parameter group view name and
     * subcategory itemName
     *
     * @param subCategory subcategory of group view
     * @param category    group view
     */
    @And("^click '(.+?)' from '(.+?)' view$")
    public void enterFromGroupsView(String subCategory, String category) {
        By selector = By.xpath("//div[@class='fdx-minimize-section-header']/h3[text()='" + category + "']/../following-sibling::div//ul//li//span[text()='" + subCategory + "'][1]");
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(selector));
        DriverUtils.clickElement(driver.findElement(selector));
    }

    @When("^select '(.+?)' form$")
    public void selectForm(String formName) {
        By formSelectorByName = By.xpath("//div[@class='fdx-ellipsis']/span[text()='" + formName + "']");
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(formSelectorByName));
        DriverUtils.clickElement(driver.findElement(formSelectorByName));

        By loadingSelector = By.cssSelector(".overlay-loading-wrapper");
        DriverUtils.getWait().until(ExpectedConditions.attributeContains(loadingSelector, "class", "show-overlay"));
        DriverUtils.getWait().until(ExpectedConditions.not(ExpectedConditions.attributeContains(loadingSelector, "class", "show-overlay")));
        DriverUtils.getWait().until(ExpectedConditions.attributeContains(loadingSelector, "class", "ng-hide"));
    }

    @And("^click '(.+?)' button from Form view$")
    public void clickFormButton(String formsViewButtonName) {
        homePage.clickFormViewButton(formsViewButtonName);
    }

    @And("^type '(.+?)' in the study screen '(.+?)' input field$")
    public void typeInTheStudyScreenField(String text, String inputField) {
        homePage.typeInFormViewInputFields(text, inputField);
    }

    @And("^make sure '(.+?)' value is '(.+?)'$")
    public void checkInputValue(String formField, String expectedText) {
        homePage.checkFormFieldValue(formField, expectedText);
    }

    @And("^we click '(.+?)' item from user menu$")
    public void clickUserMenuOption(String option) {
        DriverUtils.clickElement(HomePage.logOutButton);
    }

    @Then("^check sign out reason is as following$")
    public void checkSignOutReason(DataTable dataTable) {
        String expectedReason = dataTable.raw().get(0).get(0);
        DriverUtils.getWait().until(ExpectedConditions.textToBePresentInElement(HomePage.signOutReason, expectedReason));
    }
}
