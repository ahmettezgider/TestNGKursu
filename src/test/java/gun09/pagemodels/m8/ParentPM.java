package gun09.pagemodels.m8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ParentClass;

public class ParentPM extends ParentClass{
    By lMyAccount = By.cssSelector("a[title='My Account']");
    By lLogin = By.xpath("//a[text()='Login']");
    By lUsername = By.id("input-email");
    By lPassword = By.id("input-password");
    By lLoginButton = By.cssSelector("input[value='Login']");
    By lLogout = By.xpath("//a[text()='Logout']");

    //WebDriver driver;
    //WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }


    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendkeys(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
}
