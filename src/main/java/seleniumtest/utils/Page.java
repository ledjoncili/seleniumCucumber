package seleniumtest.utils;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public Page() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }
}
