package Pages;

import WDFactory.SingletonWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertTrue;

/**
 * Created by pavlo.balyuk on 12/1/2017.
 */
public class MainPage{
    private WebDriver driver;
    public void mainPage(String browser) throws IOException {
        // TODO: 12/1/2017 all objects need review, only structure implemented.
        SingletonWD.getInstance(browser).findElements(By.xpath("//*[@id='table']/tbody/tr[3]/td[3]"));
        // 50 mails on page table contains subject text good idea
        // "//*table[contains(@name, "doo Buchung")]/tbody/tr{2}/td[5]"
        SingletonWD.getInstance(browser).findElement(By.xpath("//*[@id=':io']")); //prev mail page
        SingletonWD.getInstance(browser).findElement(By.xpath("//*[@id=':in']")); //next mail page
        SingletonWD.getInstance(browser).findElement(By.xpath("//*[@id=':iw']")); //full left side menu open
    }

    // TODO: 12/1/2017 try to handle case when correct letter not on 1st page 
    public void letterSearch(String browser) throws IOException {
        try {
            SingletonWD.getInstance(browser).findElement(By.xpath("//*table[contains(@text, 'Three tips to get the most out of Gmail')]"));
        } catch (NoSuchElementException notFound) {
            System.out.println("No letter found");
        }
    }

    public void letterOpen(String browser) throws IOException {
        SingletonWD.getInstance(browser).findElement(By.xpath("//*table[contains(@text, 'Three tips to get the most out of Gmail')]")).click();
    }

    public void validateMailSubjectAndText(String browser) throws IOException {
        assertTrue(SingletonWD.getInstance(browser).getTitle().contentEquals("Hi webdriver"));
    }

    public void clickLogout(String browser) throws IOException {
        SingletonWD.getInstance(browser).findElement(By.xpath("//a[contains(@title, 'Google Account')]")).click();
        SingletonWD.getInstance(browser).findElement(By.linkText("Sign out")).click();
    }

    public void validateMainPagePresence(String browser) throws IOException {
        assertTrue(SingletonWD.getInstance(browser).getCurrentUrl().contains("https://mail.google.com/mail/u/0/#inbox"));
    }

    public void clickLogout() {
        driver.findElement(By.xpath("//a[contains(@title, 'Google Account')]")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }
}
