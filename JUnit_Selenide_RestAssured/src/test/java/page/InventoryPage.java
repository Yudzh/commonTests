package page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class InventoryPage extends BasePage {

  private SelenideElement cartButton = $(By.xpath("//a[@class='shopping_cart_link']"));
  private ElementsCollection inventory = $$(By.xpath("//div[@class='inventory_list']/div[@class='inventory_item']"));
  private ElementsCollection buyButtons = $$(By.xpath("//div[@class='inventory_list']/div[@class='inventory_item']//button"));

  @Override
  protected String getPageKeyWord() {
    return "inventory";
  }

  @Step("Try to buy an item")
  public void buyAnyItem(){
    int random = ThreadLocalRandom.current().nextInt(1,6);
    buyButtons.get(random).click();
  }

}
