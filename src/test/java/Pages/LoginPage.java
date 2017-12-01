package Pages;

import WDFactory.SingletonWD;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class LoginPage{
    public void login(String userName, String password, String browser) throws IOException {
        SingletonWD.getInstance(browser).findElement(By.cssSelector("#identifierId")).clear();
        SingletonWD.getInstance(browser).findElement(By.cssSelector("#identifierId")).sendKeys(userName);
        SingletonWD.getInstance(browser).findElement(By.xpath("//div[@id=\"password\"]//input")).clear();
        SingletonWD.getInstance(browser).findElement(By.xpath("//div[@id=\"password\"]//input")).sendKeys(password);
    }
    public void submitEntrance(String browser) throws IOException {
        SingletonWD.getInstance(browser).findElement(By.cssSelector("#identifierNext")).click();
        SingletonWD.getInstance(browser).findElement(By.cssSelector("#passwordNext")).click();
    }
    public void validateLoginPagePresence(String browser) throws IOException {
        assertTrue(SingletonWD.getInstance(browser).getTitle().contains("Gmail"));
    }
}
