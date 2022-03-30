package gun09.pagemodels.m10PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.DriverSingleton;

import java.time.Duration;

public class PageModel {

    WebDriver driver;
    WebDriverWait wait;

    public PageModel(){
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @BeforeTest
    public void beforeTest() {

    }

    @Test
    public void Test_Login() {
        LoginPO loginPO = new LoginPO(driver);

        driver.get("https://opencart.abstracta.us/index.php");

        loginPO.eMyAccount.click();
        loginPO.eLogin.click();
        loginPO.eUsername.sendKeys("testngkurs@gmail.com");
        loginPO.ePassword.sendKeys("testngkurs");
        loginPO.eLoginButton.click();
        wait.until(ExpectedConditions.titleIs("My Account"));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }


}
