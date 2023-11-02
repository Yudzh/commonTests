package steps;

import factory.TestContextFactory;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import rest.ApiContainer;
import storage.DataStorage;
import storage.TestContext;

public class BaseSteps {


    protected static ThreadLocal<TestContext> testContext = new ThreadLocal<>();
    protected static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        return null;
    });

    @Autowired
    protected ApiContainer apiContainer;

    protected DataStorage getDataStorage() {
        if (testContext.get() == null) {
            testContext.set(TestContextFactory.getTestContext());
        }
        return testContext.get().getDataStorage();
    }

    protected WebDriver getWebDriver() {
        if (driver.get() == null) {
            driver.set(WebDriverFactory.getWebDriver());
        }
        return driver.get();
    }


}
