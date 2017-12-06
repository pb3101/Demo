package Login;

import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */

// To run test from console use command
// mvn -Dtest=ConfigTestWD test
public class LoginDataDriven {
//
//        static WebDriver driver;
//
//        MainPage MainPage;
//
//        LoginPage LoginPage;
//
//        @BeforeMethod
//        public void beforeMethod() {
//            System.setProperty("webdriver.chrome.driver", "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe");
//            driver = new ChromeDriver();
//
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//            driver.get("http://gmail.com");
//
//            MainPage = PageFactory.initElements(driver, MainPage.class);
//
//            LoginPage = PageFactory.initElements(driver, LoginPage.class);
//
//        }
//        @DataProvider(name = "credentials")
//        public static Object[][] createData() {
//           return new Object[][]{
//                    {"webdriver2018", "2018webdriver"},
//                    {"incorrectUserName", "2018webdriver"},
//                    {"webdriver2018", "incorrectPassword"},
//           };
//        }
//
//        @Test(dataProvider = "credentials")
//        public void loginDataDriven(String userName, String passWord) throws IOException {
////            LoginPage.validateLoginPagePresence();
//            LoginPage.enterUserName(userName);
//            LoginPage.enterPassWord(passWord);
//
//            System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
//            LoginPage.clickLogout();
//        }
//
//        @AfterMethod
//
//        public void afterMethod() {
//
//            driver.quit();
//        }

}
