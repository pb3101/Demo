package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

/**
 * Created by pavlo.balyuk on 12/8/2017.
 */
public class LetterPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Three')]//ancestor::h2")
    public static WebElement ltr_Subject;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Bring your contacts and mail into ') and span[contains(text(), 'Gmail')]]")
    public static WebElement lrt_Body_Part;
}