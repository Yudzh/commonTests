package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    protected BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.urlContains(getPageKeyWord()));
    }

    protected abstract String getPageKeyWord();

    protected void sendKeys(WebElement element, String keys) {
        if (keys != null){
            wait.until(ExpectedConditions.visibilityOf(element)).clear();
            element.sendKeys(keys);
        }
    }

    /**
     * Waiting for the page to open. Method will be wait until it finds correct url or fails by timeout
     *
     * @throws TimeoutException
     */
    protected void waitForOpen() throws TimeoutException {
        if (getPageKeyWord() != null) {
            wait.until(ExpectedConditions.urlContains(getPageKeyWord()));
        }
    }

    protected void waitForOpen(String pageKey) throws TimeoutException {
        wait.until(ExpectedConditions.urlContains(pageKey));
    }

    /**
     * Click button on the page
     *
     * @param pathToElement
     */
    protected void buttonClick(By pathToElement) {
        WebElement element = driver.findElement(pathToElement);
        buttonClick(element);
    }

    protected void buttonClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
}
