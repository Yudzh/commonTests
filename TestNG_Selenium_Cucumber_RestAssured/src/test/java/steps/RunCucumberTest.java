package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

  @DataProvider(parallel = true)
  @Override
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
