package page;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public abstract class BasePage {

    protected BasePage(){
        webdriver().shouldHave(urlContaining(getPageKeyWord()));
    }

    protected abstract String getPageKeyWord();

}
