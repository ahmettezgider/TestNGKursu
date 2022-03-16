package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.LinkedList;
import java.util.List;

import static utils.LocatorsInterface.*;
import static utils.LocatorsClass.*;


public class Test04_opencart1 extends ParentClass {

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By lSearchInput = By.cssSelector("input[name='search']");
    By lSearchButton = By.cssSelector("#search button");

    List<String> menu = new LinkedList<>(){{
        add("Destop");
        add("Laptops & Notebooks");
    }};



    @Test
    public void MenuList(){
        openSite(url_static_Class);
        sendkeysTo(lSearchInput_interface, "mac");
        //waitFor(lSearchButton, clickable);
        clickTo(lSearchButton);
        //List<WebElement> menuler = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));
        List<WebElement> menuler = driver.findElements(By.cssSelector("ul.nav.navbar-nav > li"));

        for (int i = 0; i < menuler.size(); i++) {
            Assert.assertEquals(menuler.get(i).getText(), menu.get(i));
        }


        //driver.get("https://www.google.com");
        //driver.findElement(By.cssSelector("input[name='search']")).sendKeys("mac");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search button"))).click();



    }



}
