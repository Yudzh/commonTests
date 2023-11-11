package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import storage.Users;

public class LoginPage extends BasePage{

  private static final String PASSWORD = "secret_sauce";

  @FindBy(id = "user-name")
  private WebElement inputLogin;

  @FindBy(id = "password")
  private WebElement inputPassword;

  @FindBy(id = "login-button")
  private WebElement loginButton;


  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected String getPageKeyWord() {
    return "saucedemo";
  }

  @Step("Try to login")
  public void loginAsUser(Users user){
    sendKeys(inputLogin, user.abbr);
    sendKeys(inputPassword, PASSWORD);
    buttonClick(loginButton);
  }


}
