package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    By ldays = By.xpath("(//table[@class='table-condensed'])[4]//td");

    String year="June 2012";

    List<WebElement> monthAndYear;
    String monthYearString;
    String [] array;
    String dayString = "10";

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

        /*
        List<WebElement> days = driver.findElements(ldays);
        for (int i = 0; i < days.size(); i++) {
            days = driver.findElements(ldays);
            if (days.get(i).getText().contains(dayString)) {
                days.get(i).click();
            }
        }
         */

        List<WebElement> days = driver.findElements(ldays);
        for (WebElement day : days) {
            if (day.getText().contains(dayString)) {
                day.click();
                //clickByAction(day);
                //clickByJS(day);
                break;
            }
        }

        clickTo(driver.findElement(lDate));


    }



}
