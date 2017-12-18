package WDFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pavlo.balyuk on 11/27/2017.
 */
public class SingletonWD {

    private static String firefoxDriverPath = "D:\\Selenium Tests\\geckodriver-v0.19.1-win32\\geckodriver.exe";

    private static String chromeDriverPath = "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe";

    private static WebDriver driver;

    private SingletonWD() {

    }

    public static synchronized WebDriver getInstance(String browser) throws IOException {
        if (driver == null) {
            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                driver = new FirefoxDriver();
            } else if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = new ChromeDriver();
            } else {
                throw new UnsupportedOperationException("Unknown browser " + browser);
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killInstance(){
        driver.quit();
        driver = null;
    }
}
