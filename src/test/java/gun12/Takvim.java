package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.List;

public class Takvim extends ParentClass {

    String url = "https://opencart.abstracta.us/index";
    By lSearchInput = By.cssSelector("input[name='search']");
    By lComputer = By.cssSelector("img.img-responsive");
    By lDate = By.xpath("(//i[@class='fa fa-calendar'])[3]");
    By lmonthAndYears = By.xpath("(//th[@class='picker-switch'])[4]");
    By lNext = By.xpath("(//th[@class='picker-switch'])[4]/following-sibling::th[@class='next']");

    String year="June 2023";

    List<WebElement> monthAndYear;
    String monthYearString;
    String [] array;

    @Test
    public void test1(){
        driver.get("http://opencart.abstracta.us/index.php?route=product/product&product_id=42&search=cinema");
        clickTo(driver.findElement(lDate));
/*
        while (true) {
            if (driver.findElement(lmonthAndYears).getText().equalsIgnoreCase(year))
                break;
            clickTo(lNext);
        }
   */
        while (!driver.findElement(lmonthAndYears).getText().equalsIgnoreCase(year)) {
            clickTo(lNext);
        }


    }

}
