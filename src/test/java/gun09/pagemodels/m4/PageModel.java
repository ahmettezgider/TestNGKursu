package gun09.pagemodels.m4;

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

    By lMyAccount = By.cssSelector("a[title='My Account']");
    By lLogin = By.xpath("//a[text()='Login']");
    By lUsername = By.id("input-email");
    By lPassword = By.id("input-password");
    By lLoginButton = By.cssSelector("input[value='Login']");
    By lLogout = By.xpath("//a[text()='Logout']");

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

    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
