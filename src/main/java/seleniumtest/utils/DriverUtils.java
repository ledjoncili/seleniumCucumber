package seleniumtest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class DriverUtils {
    private static final WebDriver driver = WebDriverFactory.getInstance().getDriver();
    private static final WebDriverWait WAIT = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 5);

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return WAIT;
    }

    public static void navigate(String relPath) throws MalformedURLException {
        WebDriverFactory.getInstance().getDriver().navigate().to(relPath);
    }

    public static void sendKeys(WebElement webElement, String text){
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
        WAIT.until(ExpectedConditions.attributeToBe(webElement, "value", text));
    }

    public static void clickElement(WebElement webElement){
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void hoverOverElement(WebElement webElement){
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }

    public static void hoverOverElement(By selectorBy){
        WebElement webElement = driver.findElement(selectorBy);
        hoverOverElement(webElement);
    }

}
