package steps;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import springConfig.Config;

@CucumberContextConfiguration
@ContextConfiguration(classes = Config.class)
@Scope("cucumber-glue")
@Slf4j
public class StepDefinition extends BaseSteps {


}
