package pages;

import io.qameta.allure.Step;
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

  @Step("Clicking on FINISH button")
  public void finishPayment() {
    buttonClick(finishButton);
  }
}
