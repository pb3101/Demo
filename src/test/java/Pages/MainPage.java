package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class MainPage {

    public MainPage (WebDriver driver){PageFactory.initElements(driver, this);}

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

    @FindBy(how = How.XPATH, using = "//span/b[contains(text(), 'Three')]/parent::span/../span[contains(text(), 'Three tips to get the most out of Gmail')]")
    public static WebElement ltr_Entry;
}
