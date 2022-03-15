package gun02;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Driver;

public class Test02 {
    WebDriver driver;
    public Test02() {
        this.driver = Driver.getDriver();
    }
    void t3(){
        driver.get("http://www.yahoo.com");
    }
}
