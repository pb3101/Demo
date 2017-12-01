package Login;

import Pages.LoginPage;
import Pages.MainPage;
import WDFactory.SingletonWD;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class LoginWrongUserName {
    // TODO: 12/1/2017 refactor test for its purpose (negative scenario)
    @Test
    public void login(String browser) throws IOException {
        String baseUrl = "http://www.gmail.com";
        SingletonWD.getInstance(browser).get(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.validateLoginPagePresence(browser);
        loginPage.login("incorrectUserName","2018webdriver",browser);
        loginPage.submitEntrance(browser);
        MainPage mainPage = new MainPage();
        mainPage.validateMainPagePresence(browser);
        mainPage.clickLogout(browser);
        String header = SingletonWD.getInstance(browser).findElement(By.id("headingText")).getText();
        Assert.assertEquals(header, "Hi webdriver");
        SingletonWD.getInstance(browser).quit();
    }
}
