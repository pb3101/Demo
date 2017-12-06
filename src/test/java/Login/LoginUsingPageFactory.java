package Login;

import Pages.MainPage;
import Pages.PageFactoryLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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
//mvn -Dtest=LoginUsingPageFactory test
public class LoginUsingPageFactory {

    static WebDriver driver;

    MainPage HomePage;

    PageFactoryLogin LoginPageFactory;

    @BeforeTest

    public void BeforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://gmail.com");

        HomePage = PageFactory.initElements(driver, MainPage.class);

        LoginPageFactory = PageFactory.initElements(driver, PageFactoryLogin.class);

    }

    @DataProvider(name = "credentials")
    public static Object[][] createData() {
        return new Object[][]{
                {"incorrectUserName", "2018webdriver"},
                {"webdriver2018", "incorrectPassword"},
                {"webdriver2018", "2018webdriver"},
        };
    }

    @Test(dataProvider = "credentials")

    public void test(String userName, String passWord) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,3);
        try{
            LoginPageFactory.inpt_userName.sendKeys(userName);
            LoginPageFactory.btn_nextToUserName.click();
            String err_text = LoginPageFactory.err_container.getText();
            Assert.assertTrue(err_text.contains(err_text), "Couldn't find your Google Account");
       }
        catch (Exception err_userName){
            System.out.println("Wrong username input");
        }
        try {
            LoginPageFactory.inpt_passWord.sendKeys(passWord);
//            wait.until(ExpectedConditions.elementToBeClickable(LoginPageFactory.btn_nextToPass));
            LoginPageFactory.btn_nextToPass.click();
//            wait.until(ExpectedConditions.visibilityOf(LoginPageFactory.btn_nextToPass));
            String err_text = LoginPageFactory.err_container.getText();
            Assert.assertTrue(err_text.contains(err_text),"Wrong password. Try again or click Forgot password to reset it.");
        }
        catch (Exception err_passWord){
            System.out.println("Wrong password input");
        }
        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
        LoginPageFactory.clickLogout();
        assertTrue(driver.getTitle().contentEquals("Hi webdriver"));
    }

    @AfterTest

    public void afterMethod() {

        driver.quit();

    }

}

