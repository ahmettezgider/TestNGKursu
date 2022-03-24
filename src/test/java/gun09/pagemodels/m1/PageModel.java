package gun09.pagemodels.m1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='My Account']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys("testngkurs@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password"))).sendKeys("testngkurs");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Logout']")));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }




}
