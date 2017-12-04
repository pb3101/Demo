package Login;

import Pages.MainPage;
import Pages.PageFactoryLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pavlo.balyuk on 12/4/2017.
 */
public class LoginUsingPageFactory {


    static WebDriver driver;

    MainPage HomePage;

    PageFactoryLogin LoginPageFactory;

    @BeforeMethod

    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://gmail.com");

        HomePage = PageFactory.initElements(driver, MainPage.class);

        LoginPageFactory = PageFactory.initElements(driver, PageFactoryLogin.class);

    }

    @Test

    public void test() throws IOException {

        LoginPageFactory.inpt_userName.sendKeys("webdriver2018");
        LoginPageFactory.btn_nextToUserName.click();
        LoginPageFactory.inpt_passWord.sendKeys("2018webdriver");
        LoginPageFactory.btn_nextToPass.click();
        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
        LoginPageFactory.clickLogout();
    }

    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}

