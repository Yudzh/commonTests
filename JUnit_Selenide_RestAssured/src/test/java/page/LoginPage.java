package page;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import pojo.Users;

@Getter
public class LoginPage extends BasePage{

  private static final String PASSWORD = "secret_sauce";

  private SelenideElement inputLogin = $("#user-name");
  private SelenideElement inputPassword = $("#password");
  private SelenideElement loginButton = $("#login-button");

  @Override
  protected String getPageKeyWord() {
    return "saucedemo";
  }

  @Step("Try to login")
  public void loginAsUser(Users user){
    inputLogin.sendKeys(user.abbr);
    inputPassword.sendKeys(PASSWORD);
    loginButton.click();
  }


}
