package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class _06Ornek {

    /*
        Soru
        https://opensource-demo.orangehrmlive.com/index.php/auth/login
        @BeforeClass"da
            driver tanimlayin
        @Test
            siteye gidin, title"i assert edin

        @Test
            login olun, login oldugunuzu assert edin

        @AfterClass
            driveri kapatin

     */

    WebDriver driver;

    String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    By username = By.id("txtUsername");
    By password = By.id("txtPassword");
    By submitButton = By.id("btnLogin");
    By wellcome = By.id("welcome");


    @Test
    public void gotoSite(){
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
    }

    // dependsOnMethods, bu methodun hanfi methoda bagli oldugunu gösterir.
    // bagimli oldugu method calismadan calismaz.
    @Test(dependsOnMethods = "gotoSite")
    public void alogin(){
        driver.findElement(username).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(submitButton).click();
        String welcomeText = driver.findElement(wellcome).getText();
        Assert.assertTrue(welcomeText.contains("Welcome"));
    }


    @BeforeTest
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterClass(){
        driver.quit();
    }




}
