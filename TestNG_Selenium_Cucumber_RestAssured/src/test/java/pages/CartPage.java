package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

  @FindBy(id = "checkout")
  private WebElement checkoutButton;

  private static final By CART_ITEMS = By.xpath("//div[@class='cart_item']");


  public CartPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected String getPageKeyWord() {
    return "cart";
  }

  public int checkCartItemsSize(){
    return driver.findElements(CART_ITEMS).size();
  }

  @Step("Click on CHECKOUT button")
  public void checkout(){
    buttonClick(checkoutButton);
  }


}
