package seleniumtest.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.testng.Assert;
import seleniumtest.utils.DriverUtils;

import java.net.MalformedURLException;

public class GeneralSteps {

    @Given("^the page with url '(.+?)' is opened$")
    public void navigateToURL(String url) throws MalformedURLException {
        DriverUtils.navigate(url);
        Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), url);
    }
}
