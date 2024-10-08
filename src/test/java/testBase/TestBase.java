package testBase;

import configDriver.ConfigDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase {

  WebDriver driver = ConfigDriver.setupFirefoxDriver();

    private PageBase pageBase;


    @BeforeClass
    public void init() throws Exception {

        pageBase = PageFactory.initElements(driver, PageBase.class);


    }

    @Test
    public void test() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        pageBase.userLogin();

    }

    @AfterTest
    public void close() {
        //driver.close();
    }

}
