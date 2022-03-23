package gun07.TestLoginComment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class TestBaseClass {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){

    }

    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String browser){
        System.out.println(browser);
        switch (browser.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        //System.out.println(driver);
        driver.quit();
    }

}
