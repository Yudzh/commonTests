package pages;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import storage.Users;

public class InventoryPage extends BasePage {

  @FindBy(xpath = "//a[@class='shopping_cart_link']")
  private WebElement cartButton;

  private static final By INVENTORY = By.xpath("//div[@class='inventory_list']/div[@class='inventory_item']");
  private static final By BUY_BUTTONS = By.xpath("//div[@class='inventory_list']/div[@class='inventory_item']//button");

  public InventoryPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected String getPageKeyWord() {
    return "inventory";
  }

  public int checkAllInventorySize() {
    return driver.findElements(INVENTORY).size();
  }

  public void buyAnyItem(){
    int random = ThreadLocalRandom.current().nextInt(1,6);
    driver.findElements(BUY_BUTTONS).get(random).click();
  }

  public void goToCart(){
    buttonClick(cartButton);
  }


}
