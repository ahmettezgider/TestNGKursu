package gun08.parallel1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class TestBaseClass {

    protected WebDriver driver;


    @BeforeClass
    @Parameters({"browser"})
    public void beforeTest(String browser){
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

    @AfterClass
    public void afterTest(){
        //System.out.println(driver);
        driver.quit();
    }

}
