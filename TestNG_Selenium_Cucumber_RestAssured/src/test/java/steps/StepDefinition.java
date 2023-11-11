package steps;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static storage.KeyWordStorage.USER;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import pages.CartPage;
import pages.CheckoutFirstPage;
import pages.CheckoutSecondPage;
import pages.InventoryPage;
import pages.LoginPage;
import rest.ApiContainer;
import springConfig.Config;
import storage.Users;
import pojo.User;

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
  public CheckoutFirstPage checkoutFirstPage;
  public CheckoutSecondPage checkoutSecondPage;

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
    screenshot();
    inventoryPage.goToCart();
    cartPage = new CartPage(getWebDriver());
  }

  @Then("Check cart inventory size is {int}")
  public void checkCartSize(int size) {
    assertEquals("Cart size", size, cartPage.checkCartItemsSize());
  }

  @When("Get user")
  public void getUser(){
    getDataStorage().add(USER, apiContainer.userService.getUser());
  }

  @When("Checkout")
  public void checkout(){
    cartPage.checkout();
    checkoutFirstPage = new CheckoutFirstPage(getWebDriver());
    checkoutFirstPage.fillUserInfo((User) getDataStorage().get(USER));
    checkoutFirstPage.sendUserInfo();
  }

  @When("Finish payment")
  public void finishPayment(){
    checkoutSecondPage = new CheckoutSecondPage(getWebDriver());
    checkoutSecondPage.finishPayment();
  }

  @When("Wait {int} seconds")
  public void waitSec(int seconds){
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


}
