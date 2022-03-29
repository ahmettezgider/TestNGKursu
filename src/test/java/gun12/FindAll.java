package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

public class FindAll extends ParentClass {


    FindAllPO po;
    String searchText = "mac";

    @Test
    public void test1() {
        po = new FindAllPO(driver);
        driver.get("http://opencart.abstracta.us/");
        po.getSearchText().sendKeys(searchText);
        po.getSearchButton().click();
        Assert.assertTrue(po.getSiteMap().getText().contains("Search"));
    }



    @Test
    public void test2() {

        for (WebElement productName : po.getProducts()) {
            System.out.println(productName.getText());
            Assert.assertTrue(productName.getText().toLowerCase().contains(searchText));
        }

    }

    @Test
    public void test3(){
        System.out.println("--------------------");
        for (WebElement element : po.getIsimveFiyat()) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void test4(){

        driver.findElements(By.cssSelector("xxx")); // hata vermez, null List return eder
        System.out.println("after findElements");

        //driver.findElement(By.cssSelector("xxx"));  // hata verir
        //System.out.println("after findElement");


        if (driver.findElements(By.cssSelector("#content h1")).size()>0)
            System.out.println("Bu element mevcut");
        else
            System.out.println("Bu element mevct degil");


        System.out.println("------------------------------------");
        System.out.println(po.getFindBys().getText());

        WebElement e = driver
                .findElement(By.xpath("(//div[@class='product-thumb'])[2]"))
                .findElement(By.cssSelector("h4"));
        System.out.println(e.getText());
        /*
            tüm sayfada "//div[@class='product-thumb'])[2]" bu elementi bul sonra
            bu element altinda "h4" ü bul

            1. yol
            WebElement e = driver
                .findElement(By.xpath("(//div[@class='product-thumb'])[2]"))
                .findElement(By.cssSelector("h4"));

            2. yol
            @FindBys({
                @FindBy(xpath = "(//div[@class='product-thumb'])[2]"),  // Parent selector
                @FindBy(css = "h4")                                     // child selector
            })
         */


    }



}

/*
    <p class='a b c d'>
    <p class='d e f g'>
    <p class='f'>

    @FindAll({
        @FindBy(css='p.a'),
        @FindBy(css='p.d'),
        @FindBy(css='p.f')
    })



 */