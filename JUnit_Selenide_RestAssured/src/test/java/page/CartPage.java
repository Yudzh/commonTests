package page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CartPage extends BasePage {

  private SelenideElement checkoutButton = $("#checkout");
  private ElementsCollection cartItems = $$(By.xpath("//div[@class='cart_item']"));

  @Override
  protected String getPageKeyWord() {
    return "cart";
  }


}
