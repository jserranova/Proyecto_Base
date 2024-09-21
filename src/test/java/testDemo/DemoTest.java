package testDemo;

import configDriver.ConfigDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.demo.PageBaseDemo;

import static org.testng.Assert.assertTrue;

public class DemoTest {

    WebDriver driver = ConfigDriver.setupChromeDriver();
    private PageBaseDemo pageBaseDemo;

    @BeforeClass
    public void init() {

        pageBaseDemo = PageFactory.initElements(driver, PageBaseDemo.class);
    }

    @Test
    public void loginUser() {
        pageBaseDemo.userLogin();
    }

    @Test(dependsOnMethods = {"loginUser"})   /* ejecutate primero el loginUser*/
    public void existElement() throws InterruptedException {
        assertTrue(pageBaseDemo.isExistElement());
        Thread.sleep(1000);
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
