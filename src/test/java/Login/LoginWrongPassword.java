package Login;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class LoginWrongPassword {
    static WebDriver driver;

    LoginPage LoginPage;

    @BeforeMethod

    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://gmail.com");


        LoginPage = PageFactory.initElements(driver, LoginPage.class);

    }

    @DataProvider(name = "credentials")
    public static Object[][] createData() {
        return new Object[][]{
                {"webdriver2018", "incorrectPassword"},
        };
    }

    @Test(dataProvider = "credentials")

    public void login(String userName, String passWord) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 3);

        LoginPage.inpt_userName.sendKeys(userName);
        LoginPage.btn_nextToUserName.click();
        LoginPage.inpt_passWord.sendKeys(passWord);
        wait.until(ExpectedConditions.visibilityOf(LoginPage.btn_nextToPass));
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.btn_nextToPass));
        LoginPage.btn_nextToPass.click();
        String err_text = LoginPage.err_container.getText();
        Assert.assertTrue(err_text.contains(err_text), "Wrong password. Try again or click Forgot password to reset it.");
    }

    @AfterMethod

    public void afterMethod() {
        driver.quit();
        driver = null;
    }

}

