package steps;

import static org.springframework.test.util.AssertionErrors.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.AssertionErrors;
import org.springframework.util.Assert;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import rest.ApiContainer;
import springConfig.Config;
import storage.Users;

@CucumberContextConfiguration
@ContextConfiguration(classes = Config.class)
@Scope("cucumber-glue")
@Slf4j
public class StepDefinition extends BaseSteps {

  @Autowired
  public ApiContainer apiContainer;

  public LoginPage loginPage;
  public InventoryPage inventoryPage;
  public CartPage cartPage;

  @Given("Open login page")
  public void goToLoginPage() {
    getWebDriver().get("https://www.saucedemo.com/");
    loginPage = new LoginPage(getWebDriver());
  }

  @When("Login as {string} user")
  public void loginAsUser(String userName) {
    loginPage.loginAsUser(Users.findByAbbr(userName));
    inventoryPage = new InventoryPage(getWebDriver());
  }

  @Then("Check inventory size")
  public void checkInventorySize() {
    assertEquals("Inventory size is not valid", 6, inventoryPage.checkAllInventorySize());
  }

  @When("Buy any item")
  public void buyAnyItem() {
    inventoryPage.buyAnyItem();
  }

  @When("Go to cart page")
  public void goToCart() {
    inventoryPage.goToCart();
    cartPage = new CartPage(getWebDriver());
  }

  @Then("Check cart inventory size is {int}")
  public void checkCartSize(int size) {
    assertEquals("Cart size", size, cartPage.checkCartItemsSize());
  }

  @When("Get user")
  public void getUser(){
    apiContainer.userService.getUser();
  }


}
