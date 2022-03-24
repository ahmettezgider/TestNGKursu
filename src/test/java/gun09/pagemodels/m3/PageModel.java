package gun09.pagemodels.m3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageModel {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void Test_Login(){
        driver.get("https://opencart.abstracta.us/index.php");

        By lMyAccount = By.cssSelector("a[title='My Account']");
        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(lMyAccount));
        myAccount.click();

        By lLogin = By.xpath("//a[text()='Login']");
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(lLogin));
        login.click();

        By lUsername = By.id("input-email");
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername));
        username.sendKeys("testngkurs@gmail.com");

        By lPassword = By.id("input-password");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(lPassword));
        password.sendKeys("testngkurs");

        By lLoginButton = By.cssSelector("input[value='Login']");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(lLoginButton));
        loginButton.click();

        By lLogout = By.xpath("//a[text()='Logout']");
        wait.until(ExpectedConditions.presenceOfElementLocated(lLogout));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
