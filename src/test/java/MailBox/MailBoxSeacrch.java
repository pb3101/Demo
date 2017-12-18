package MailBox;

import Pages.LetterPage;
import Pages.LoginPage;
import Pages.MainPage;
import WDFactory.SingletonWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.reporters.jq.Main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class MailBoxSeacrch {
    static WebDriver driver;

    MainPage MainPage;

    LoginPage LoginPage;

    LetterPage LetterPage;

    @BeforeMethod
    public void BeforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:\\TestNG\\src\\main\\resources\\drivers\\chrome\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://gmail.com");

        MainPage = PageFactory.initElements(driver, MainPage.class);

        LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LetterPage = PageFactory.initElements(driver, LetterPage.class);

    }

    @DataProvider(name = "credentials")
    public static Object[][] createData() {
        return new Object[][]{
                {"webdriver2018", "2018webdriver"},
        };
    }

    @Test(dataProvider = "credentials")
    public void mailSearch(String userName, String passWord) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        LoginPage.inpt_userName.sendKeys(userName);
        LoginPage.btn_nextToUserName.click();
        LoginPage.inpt_passWord.sendKeys(passWord);
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.btn_nextToPass));
        LoginPage.btn_nextToPass.click();
        wait.until(ExpectedConditions.visibilityOf(LoginPage.btn_nextToPass));
        MainPage.src_Input.sendKeys(MainPage.ltr_Subject);
        wait.until(ExpectedConditions.elementToBeClickable(MainPage.btn_Search));
        MainPage.btn_Search.click();
        wait.until(ExpectedConditions.visibilityOf(MainPage.btn_Search));
        MainPage.ltr_Entry.click();
        Assert.assertTrue((LetterPage.ltr_Subject.getText().contains("Three tips to get the most out of Gmail")) && (LetterPage.lrt_Body_Part.getText().contains("Bring your contacts and mail into Gmail")));
        MainPage.dropdn_account.click();
        MainPage.btn_logOut.click();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        driver = null;
    }
}
