package gun09.pagemodels.m9PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageModel {

    WebDriver driver;
    WebDriverWait wait;
    /*
        calisilacak sayfanin selectorlerini @FindBy annotationi ile elemente ceviriyoruz
     */

    @FindBy(css = "a[title='My Account']")
    public WebElement eMyAccount;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement eLogin;

    @FindBy(id = "input-email")
    public WebElement eUsername;

    @FindBy(id = "input-password")
    public WebElement ePassword;

    @FindBy(css = "input[value='Login']")
    public WebElement eLoginButton;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement eLogout;

    public PageModel(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }


    @BeforeTest
    public void beforeTest() {

    }

    @Test
    public void Test_Login() {
        driver.get("https://opencart.abstracta.us/index.php");

        eMyAccount.click();
        eLogin.click();
        eUsername.sendKeys("testngkurs@gmail.com");
        ePassword.sendKeys("testngkurs");
        eLoginButton.click();
        wait.until(ExpectedConditions.titleIs("My Account"));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }


}
