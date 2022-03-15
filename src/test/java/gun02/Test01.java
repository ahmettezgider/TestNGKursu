package gun02;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Driver;

public class Test01 {

    WebDriver driver;

    @Test
    void t1(){
        driver = Driver.getDriver();
    }

    @Test
    void t2(){
        driver.get("https://www.google.com");

        Test02 test02 = new Test02();
        test02.t3();

        Test03 test03 = new Test03(driver);
        test03.t3();

    }

    @AfterTest
    public void aTest(){
        Driver.quitDriver();
    }

}
