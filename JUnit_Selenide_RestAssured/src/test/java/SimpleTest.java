import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import page.CartPage;
import page.CheckoutPage;
import page.FinishPaymentPage;
import page.InventoryPage;
import page.LoginPage;
import pojo.User;
import pojo.Users;
import service.ApiContainer;
import springConfig.Config;

@SpringJUnitConfig(Config.class)
public class SimpleTest {

  @Autowired
  private ApiContainer apiContainer;

  @Test
  public void firstTest(){
    LoginPage loginPage = open("https://www.saucedemo.com/", LoginPage.class);
    loginPage.loginAsUser(Users.STANDART_USER);
    InventoryPage inventoryPage = new InventoryPage();
    assertEquals(6, inventoryPage.getInventory().size());
    inventoryPage.buyAnyItem();
    inventoryPage.getCartButton().shouldBe(Condition.visible).click();
    CartPage cartPage = new CartPage();
    assertEquals(1, cartPage.getCartItems().size());

    User user = apiContainer.userService.getUser();

    cartPage.getCheckoutButton().shouldBe(Condition.visible).click();

    CheckoutPage checkoutPage = new CheckoutPage();
    checkoutPage.fillUserInfo(user);
    checkoutPage.getContinueButton().shouldBe(Condition.visible).click();

    FinishPaymentPage finishPaymentPage = new FinishPaymentPage();
    finishPaymentPage.getFinishButton().shouldBe(Condition.visible).click();

  }
}
