package page;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import pojo.User;

@Getter
public class CheckoutPage extends BasePage {

  private SelenideElement firstName = $("#first-name");
  private SelenideElement lastName = $("#last-name");
  private SelenideElement zip = $("#postal-code");
  private SelenideElement continueButton = $("#continue");

  @Override
  protected String getPageKeyWord() {
    return "checkout-step-one";
  }

  @Step("Filling user info")
  public void fillUserInfo(User user){
    firstName.shouldBe(Condition.visible).sendKeys(user.getFullName().getFirstName());
    lastName.shouldBe(Condition.visible).sendKeys(user.getFullName().getLastName());
    zip.shouldBe(Condition.visible).sendKeys(user.getLocation().getPostCode());
  }


}
