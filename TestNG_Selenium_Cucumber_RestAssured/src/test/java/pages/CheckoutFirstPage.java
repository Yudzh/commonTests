package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.User;

public class CheckoutFirstPage extends BasePage {

  @FindBy(id = "first-name")
  private WebElement firstName;

  @FindBy(id = "last-name")
  private WebElement lastName;

  @FindBy(id = "postal-code")
  private WebElement zip;

  @FindBy(id = "continue")
  private WebElement continueButton;


  public CheckoutFirstPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected String getPageKeyWord() {
    return "checkout-step-one";
  }

  @Step("Filling user info")
  public void fillUserInfo(User user){
    sendKeys(firstName, user.getFullName().getFirstName());
    sendKeys(lastName, user.getFullName().getLastName());
    sendKeys(zip, user.getLocation().getPostCode());
  }

  @Step("Sending user info")
  public void sendUserInfo(){
    buttonClick(continueButton);
  }


}
