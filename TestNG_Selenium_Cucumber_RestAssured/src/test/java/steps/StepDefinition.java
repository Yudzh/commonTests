package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import pages.LoginPage;
import springConfig.Config;
import storage.Users;

@CucumberContextConfiguration
@ContextConfiguration(classes = Config.class)
@Scope("cucumber-glue")
@Slf4j
public class StepDefinition extends BaseSteps {

  public LoginPage loginPage;

  @Given("Open login page")
  public void goToLoginPage(){
    getWebDriver().get("https://www.saucedemo.com/");
    loginPage = new LoginPage(getWebDriver());
  }

  @When("Login as {string} user")
  public void loginAsUser(String userName){
    loginPage.loginAsUser(Users.findByAbbr(userName));
  }


}
