package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

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
            driver.get().quit();
            driver.remove();
        }
    }
}
