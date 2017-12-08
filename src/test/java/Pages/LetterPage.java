package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

/**
 * Created by pavlo.balyuk on 12/8/2017.
 */
public class LetterPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Three tips to get the most out of Gmail')]")
    public static WebElement ltr_Subject;

    // TODO: 12/8/2017 XPATHES FOR MAIL BODY PARTS 
    
    @FindBy(how = How.XPATH, using = "//td[contains(@span, contains(text(),'Bring your contacts and mail into Gmail'))]]") //*[@id=":6p"]/div[1]/div/div[1]/table/tbody/tr/td/div[4]/table/tbody/tr/td/span[1] - hard XPATH
    public static WebElement lrt_Body_Part1;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Find what you need fast')]") //*[@id=":6p"]/div[1]/div/div[1]/table/tbody/tr/td/div[6]/table/tbody/tr/td/span[1]
    public static WebElement lrt_Body_Part2;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Much more than email')]") //*[@id=":6p"]/div[1]/div/div[1]/table/tbody/tr/td/div[8]/table/tbody/tr/td/span[1]
    public static WebElement lrt_Body_Part3;
}
