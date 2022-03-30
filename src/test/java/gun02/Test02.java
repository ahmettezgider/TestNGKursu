package gun02;

import org.openqa.selenium.WebDriver;
import utils.DriverSingleton;

public class Test02 {
    WebDriver driver;
    public Test02() {
        this.driver = DriverSingleton.getDriver();
    }
    void t3(){
        driver.get("http://www.yahoo.com");
    }
}
