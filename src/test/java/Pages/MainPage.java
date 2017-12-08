package Pages;

import WDFactory.SingletonWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertTrue;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class MainPage{
    private WebDriver driver;

    public String ltr_Subject = "Three tips to get the most out of Gmail";

    @FindBy(how = How.XPATH, using = "//*[@id='gbqfq']")
    public static WebElement src_Input;

    @FindBy(how = How.XPATH, using = "//a[contains(@title, 'Google Account')]")
    @CacheLookup
    public static WebElement dropdn_account;

    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    @CacheLookup
    public static WebElement btn_logOut;

    @FindBy(how = How.XPATH, using = "//*[@id='gbqfb']")
    @CacheLookup
    public static WebElement btn_Search;

    @FindBy(how = How.XPATH, using = "//*table/table/span[contains(text(), 'Three tips to get the most out of Gmail')]") //*[@id=":2"]/div/div/div[4]
    @CacheLookup
    public static WebElement ltr_Entry;
}
