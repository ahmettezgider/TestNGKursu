package gun09.pagemodels.m6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class PageModel extends ParentPM{


    @Test
    public void Test_Login(){
        driver.get("https://opencart.abstracta.us/index.php");

        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(lMyAccount));
        myAccount.click();

        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(lLogin));
        login.click();

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername));
        username.sendKeys("testngkurs@gmail.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(lPassword));
        password.sendKeys("testngkurs");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(lLoginButton));
        loginButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(lLogout));
    }



}
