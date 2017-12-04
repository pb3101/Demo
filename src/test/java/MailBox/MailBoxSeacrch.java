package MailBox;

import Pages.LoginPage;
import Pages.MainPage;
import WDFactory.SingletonWD;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class MailBoxSeacrch {
    // TODO: 12/1/2017 Create one more test with browser setup to skip login throw UI, set up cookies or OAUTH session (to investigate)
    @Test
    public void mailSearch(String browser) throws IOException{
        String baseUrl = "http://www.gmail.com";
        SingletonWD.getInstance(browser).get(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.validateLoginPagePresence(browser);
        loginPage.login("webdriver2018","2018webdriver",browser);
        loginPage.submitEntrance(browser);
        MainPage mainPage = new MainPage();
        mainPage.validateMainPagePresence(browser);
        mainPage.letterSearch(browser);
        mainPage.letterOpen(browser);
        mainPage.validateMailSubjectAndText(browser);
        mainPage.clickLogout(browser);
    }
}
