package gun13.paket1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Browser;
import utils.Driver;

public class TestClass1 {
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String browser) {
        if (browser.equalsIgnoreCase("firefox"))
            driver = Driver.getDriver(Browser.FIREFOX);
        else if (browser.equalsIgnoreCase("edge"))
            driver = Driver.getDriver(Browser.EDGE);
        else
            driver = Driver.getDriver(Browser.CHROME);
        //driver = Driver.getDriver(Browser.valueOf(browser.toUpperCase()));
    }

    @Test
    public void test1() {
        driver.get("http://opencart.abstracta.us/");
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("mac" + Keys.ENTER);

        WebDriver d = Driver.getDriver();  // Calisan thread"in driver"ini return edecek. Yani yukaridaki driver'i
        d.get("http://google.com");
    }


    @AfterTest
    public void afterTest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Driver.quitDriver();
    }

}
