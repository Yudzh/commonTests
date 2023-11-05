package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

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


}
