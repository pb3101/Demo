package WDFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/**
 * Created by pavlo.balyuk on 12/18/2017.
 */
public class Setup {

    static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        driver = SingletonWD.getInstance("chrome");
    }
    @AfterSuite
    public void afterSuite(){
        SingletonWD.killInstance();
    }
}
