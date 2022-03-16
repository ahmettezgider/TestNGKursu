package gun03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.List;

public class _01_opencartMenuHover extends ParentClass {

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By mainMenuItems = By.cssSelector("ul.nav.navbar-nav>li");

    @Test
    public void Test_HoverAndJustifyMenu(){
        //driver.get(url);
        openSite(url);

        List<WebElement> elementOfMenuItems = driver.findElements(mainMenuItems);

        for (WebElement menuItem : elementOfMenuItems) {
            hover(menuItem, 300);
            if (menuItem.findElements(By.cssSelector("div.dropdown-inner")).size()>0) {
                System.out.println("Alt Menu Var " + menuItem.findElements(By.cssSelector("div.dropdown-inner li")).size());
                Assert.assertTrue(menuItem.findElement(By.cssSelector(".dropdown-inner")).isDisplayed());
            }else{
                System.out.println("Alt Menu Yok");
            }
        }


        //driver.findElements(By.cssSelector("ul#asd")).get(0);   // null list return eder, hata return etmez
        //driver.findElement(By.cssSelector("ul#asd"));   // hata return eder




    }

    @Test
    public void testWriteWithJavascript(){
        openSite(url);
        String js = "document.getElementById(\"logo\").innerHTML = 'Java Kurs';";
        ((JavascriptExecutor)driver).executeScript(js);
        sleep(5000);
    }

}
