package factory;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private static final String BROWSER = "browser";
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String CHROME_HEADLESS = "chrome_headless";
    private static final String FIREFOX_HEADLESS = "firefox_headless";
    private static final String SELENIUM_HUB = "seleniumHub";
    private static URL seleniumHubURL;

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriver() {
        String browserName = System.getProperty(BROWSER);
        browserName = browserName == null ? CHROME : browserName.toLowerCase();
        return createWebDriver(browserName);
    }

    private static WebDriver createWebDriver(String browserType){
        //TODO Add condition for another browsers
        final String seleniumHubProperty = System.getProperty(SELENIUM_HUB);

        if(seleniumHubProperty != null){
            try {
                seleniumHubURL = new URL(seleniumHubProperty);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-proxy-server");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.addArguments("--force-device-scale-factor=1");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            return new RemoteWebDriver(seleniumHubURL, options);
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        return new ChromeDriver(options);
    }
}
