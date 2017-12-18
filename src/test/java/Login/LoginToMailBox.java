package Login;

import Pages.MainPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by pavlo.balyuk on 12/4/2017.
 */
//mvn -Dtest=LoginToMailBox test
public class LoginToMailBox {

    static WebDriver driver;

    MainPage HomePage;

    LoginPage LoginPage;

    @BeforeMethod

    public void BeforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://gmail.com");

        LoginPage = PageFactory.initElements(driver, LoginPage.class);

    }

    @Parameters({"userName", "passWord"})
    @Test

    public void login(String userName, String passWord) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        LoginPage.inpt_userName.sendKeys(userName);
        LoginPage.btn_nextToUserName.click();
        LoginPage.inpt_passWord.sendKeys(passWord);
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.btn_nextToPass));
        LoginPage.btn_nextToPass.click();
        wait.until(ExpectedConditions.visibilityOf(LoginPage.btn_nextToPass));
        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
        LoginPage.dropdn_account.click();
        Assert.assertTrue(LoginPage.acc_Email.getAttribute("href").equals("https://myaccount.google.com/?utm_source=OGB&utm_medium=act"));
    }

    @AfterMethod

    public void afterMethod() {
        driver.quit();
        driver = null;
    }

}

