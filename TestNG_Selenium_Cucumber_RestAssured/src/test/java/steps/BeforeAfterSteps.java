package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Slf4j
public class BeforeAfterSteps extends BaseSteps{

    @Before
    public void init(Scenario scenario){
        log.info("Starting scenario - " + scenario.getName());
        getDataStorage().clear();
    }

    @After
    public void close(Scenario scenario){
        log.info("Scenarion " + scenario.getName() + " end");
        if(driver.get() != null){
            screenshot();
            driver.get().quit();
            driver.remove();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
    }
}
