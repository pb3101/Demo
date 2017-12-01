package Pages;

import WDFactory.SingletonWD;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class MainPage {
    public void mainPage(String browser) throws IOException{
        //all objects need review, only structure implemented.
        SingletonWD.getInstance(browser).findElements(By.xpath("//*[@id='table']/tbody/tr[3]/td[3]"));
        // 50 mails on page table contains subject text good idea
        // "//*table[contains(@name, "doo Buchung")]/tbody/tr{2}/td[5]"
        SingletonWD.getInstance(browser).findElement(By.xpath("//*[@id=':io']")); //prev mail page
        SingletonWD.getInstance(browser).findElement(By.xpath("//*[@id=':in']")); //next mail page
        SingletonWD.getInstance(browser).findElement(By.xpath("//*[@id=':iw']")); //full left side menu open
    }

    public void clickLogout(String browser) throws IOException {
        SingletonWD.getInstance(browser).findElement(By.xpath("//a[contains(@title, 'Google Account')]")).click();
        SingletonWD.getInstance(browser).findElement(By.linkText("Sign out")).click();
    }

    public void validateMainPagePresence(String browser) throws IOException {
        assertTrue(SingletonWD.getInstance(browser).getCurrentUrl().contains("https://mail.google.com/mail/u/0/#inbox"));
    }
}
