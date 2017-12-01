package Login;

import Pages.LoginPage;
import Pages.MainPage;
import WDFactory.SingletonWD;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */

// To run test from console use command
// mvn -Dtest=ConfigTestWD test
public class Login {
//
//    @BeforeClass // Runs this method before the first test method in the current class is invoked
//    public void initWD() throws IOException {
//        WebDriver webDriver = SingletonWD.getInstance("chrome");
//        webDriver.get("http://www.gmail.com"); //Open browser window
//        webDriver.manage().window().maximize();
//    }

    @Test
    public void login(String browser) throws IOException {
        String baseUrl = "http://www.gmail.com";
        SingletonWD.getInstance(browser).get(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.validateLoginPagePresence(browser);
        loginPage.login("webdriver2018","2018webdriver",browser);
        loginPage.submitEntrance(browser);
        MainPage mainPage = new MainPage();
        mainPage.validateMainPagePresence(browser);
        mainPage.clickLogout(browser);
        String header = SingletonWD.getInstance(browser).findElement(By.id("headingText")).getText();
        Assert.assertEquals(header, "Hi webdriver");
        SingletonWD.getInstance(browser).quit();
    }
//
//    @AfterClass
//    public void closeWD() throws IOException {
//        WebDriver webDriver = SingletonWD.getInstance("chrome");
//        webDriver.quit();
//    }

}
