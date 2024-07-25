package page;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class FinishPaymentPage extends BasePage {

  private SelenideElement finishButton = $("#finish");

  @Override
  protected String getPageKeyWord() {
    return "checkout-step-two";
  }

}
