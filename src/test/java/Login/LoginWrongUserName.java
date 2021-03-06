package Login;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class LoginWrongUserName {
    static WebDriver driver;

    LoginPage LoginPage;

    @BeforeMethod

    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://gmail.com");

        LoginPage = new LoginPage(driver);

    }

    @DataProvider(name = "credentials")
    public static Object[][] createData() {
        return new Object[][]{
                {"incorrectUserName", "2018webdriver"},
        };
    }

    @Test(dataProvider = "credentials")

    public void login(String userName, String passWord) throws IOException {
            LoginPage.inpt_userName.sendKeys(userName);
            LoginPage.btn_nextToUserName.click();
            String err_text = LoginPage.err_container.getText();
            Assert.assertTrue(err_text.contains(err_text), "Couldn't find your Google Account");
    }

    @AfterMethod

    public void afterMethod() {
        driver.quit();
        driver = null;
    }

}
