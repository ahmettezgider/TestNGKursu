package gun02;

import org.openqa.selenium.WebDriver;

public class Test03 {
    WebDriver driver;
    public Test03(WebDriver driver) {
        this.driver = driver;
    }
    void t3(){
        driver.get("http://www.amazon.com");
    }
}
