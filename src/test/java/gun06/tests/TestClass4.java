package gun06.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverSingleton;

public class TestClass4 {
    WebDriver driver;

    @BeforeTest
    @Parameters("browserName")
    public void beforeTest(String browser){
        driver = DriverSingleton.getDriver(browser);
        //driver = Driver.getDriver(Browser.valueOf(browser));
        // getDriver() methodu Browser enum"i aliyor ise
        // gelen string Browser.valueOf(browser) ile enuma dönüstürülür

        /*
        switch (browser.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
         */
    }

    @Test
    public void gotoUrl(){
        driver.get("http://opencart.abstracta.us/");
    }


    @Test(dependsOnMethods = {"gotoUrl"})
    @Parameters({"searchText", "browserName"})
    public void search(String text, String browser){
        driver.findElement(By.cssSelector("#search input")).sendKeys(text + Keys.ENTER);
        System.out.println("Method : " + browser);
    }

    @AfterTest
    @Parameters("browserName")
    public void afterTest(String bName){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bName);
        //driver.quit();
        DriverSingleton.quitDriver();
    }

}
