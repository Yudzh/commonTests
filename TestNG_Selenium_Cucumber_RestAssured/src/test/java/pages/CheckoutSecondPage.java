package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSecondPage extends BasePage {


  @FindBy(id = "finish")
  private WebElement finishButton;


  public CheckoutSecondPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected String getPageKeyWord() {
    return "checkout-step-two";
  }

  public void finishPayment() {
    buttonClick(finishButton);
  }
}
