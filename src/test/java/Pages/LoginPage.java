package Pages;

import WDFactory.SingletonWD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class LoginPage{

    private static WebDriver driver;

    @FindBy(how = How.CSS, using = "#identifierId")
    @CacheLookup
    public static WebElement inpt_userName;

    @FindBy(how = How.XPATH, using = "//div[@id=\"password\"]//input")
    public static WebElement inpt_passWord;

    @FindBy(how = How.CSS, using = "#identifierNext")
    @CacheLookup
    public static WebElement btn_nextToUserName;

    @FindBy(how = How.CSS, using = "#passwordNext")
    public static WebElement btn_nextToPass;

    @FindBy(how = How.XPATH, using = "//a[contains(@title, 'Google Account')]")
    @CacheLookup
    public static WebElement dropdn_account;

    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    @CacheLookup
    public static WebElement btn_logOut;

    public void enterUserName (String userName) throws IOException {
        inpt_userName.sendKeys(userName);
        this.submitEntrance();
    }

    public void enterPassWord (String passWord) throws IOException {
        inpt_passWord.sendKeys(passWord);
        this.submitEntrance();
    }
    public void submitEntrance() throws IOException {
        btn_nextToUserName.click();
        btn_nextToPass.click();
    }
    public void validateLoginPagePresence() throws IOException {
        assertTrue(driver.getTitle().contains("Gmail"));
    }

    public void clickLogout() {
        dropdn_account.click();
        btn_logOut.click();
    }
}