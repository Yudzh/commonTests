package factory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private static final String BROWSER = "browser";
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String CHROME_HEADLESS = "chrome_headless";
    private static final String FIREFOX_HEADLESS = "firefox_headless";

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriver() {
        String browserName = System.getProperty(BROWSER);
        browserName = browserName == null ? CHROME : browserName.toLowerCase();
        //TODO add remote control (hub)
        return createWebDriver(browserName);
    }

    private static WebDriver createWebDriver(String browserType){
        //TODO Add condition for another browsers
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        return new ChromeDriver(options);
    }
}
