package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import springConfig.Config;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static storage.KeyWordStorage.USER;
import static storage.KeyWordStorage.USER_TO;

@CucumberContextConfiguration
@ContextConfiguration(classes = Config.class)
@Scope("cucumber-glue")
@Slf4j
public class StepDefinition extends BaseSteps {


}
