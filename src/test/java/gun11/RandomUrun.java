package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import static gun11.RandomUrunLocators.*;
import static gun11.RandomUrunLocatorsClass.*;

public class RandomUrun extends ParentClass {


    List<WebElement> products;
    List<WebElement> productPrices;
    List<WebElement> productAddToCarts;
    Object[] myUrun;

    @Test
    public void test1(){
        String searcedText = "ipod";
        driver.get(url);
        sendkeysTo(lSearch, searcedText + Keys.ENTER);

        products = driver.findElements(lProductNames);
        for (WebElement product : products) {
            Assert.assertTrue(product.getText().toLowerCase().contains(searcedText));
        }
    }

    @Test
    public void test2(){
        productPrices = driver.findElements(lProductPrices);
        productAddToCarts = driver.findElements(lProductAddToCarts);
        for (int i = 0; i < 4; i++) {
            System.out.println(getPriceAsNumber(productPrices.get(i).getText()));
        }

        int rUrun = new Random().nextInt(productPrices.size());

        myUrun = new Object[]{products.get(rUrun).getText(), getPriceAsNumber(productPrices.get(rUrun).getText())};

        productAddToCarts.get(rUrun).click();


        wait.until(ExpectedConditions.not(ExpectedConditions.textMatches(lCart, Pattern.compile(".*Loading.*"))));
        driver.findElement(lCart).click();

        //wait.until(ExpectedConditions.elementToBeClickable(lCart)).click();
        WebElement cartPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(lCartPanel));

        Assert.assertTrue(cartPanel.getText().contains(myUrun[0].toString()));
        Assert.assertTrue(cartPanel.getText().contains(products.get(rUrun).getText()));

    }


    @Test
    public void test3(){
         String urunAdi = driver.findElement(lCartTableUrunIsimleri).getText();
         String urunFiyati = driver.findElement(lCartTotal).getText();
         String urunFiyati1 = driver.findElement(RelativeLocator.with(By.cssSelector("td")).toRightOf(lCartTotalText)).getText();

         Assert.assertEquals(urunAdi, myUrun[0]);
         Assert.assertEquals(getPriceAsNumber(urunFiyati), myUrun[1]);
         Assert.assertEquals(getPriceAsNumber(urunFiyati1), myUrun[1]);



    }


    public double getPriceAsNumber(String text){
        String str = text.split("\n")[0]
                .replaceAll("[^0-9]","");

        return Double.parseDouble(str)/100;
    }
}

interface RandomUrunLocators {
    String url = "http://opencart.abstracta.us/";
    By lSearch = By.cssSelector("input[name='search']");
    By lProductNames = By.cssSelector(".caption a");
    By lProductPrices = By.xpath("//div[@class='caption']/p[2]");
    By lProductAddToCarts = By.xpath("//button[contains(@onclick,'cart.add')]");
    By lCart = By.cssSelector("#cart button");
    By lCartPanel = By.cssSelector("ul.dropdown-menu.pull-right");

    By lCartTableUrunIsimleri = By.xpath("//table[@class='table table-striped']//td[2]");
    By lCartTotal = By.xpath("//table[@class='table table-bordered']//tr[4]/td[2]");
    By lCartTotalText = By.xpath("//td[./*[text()='Total']]");


}

class RandomUrunLocatorsClass {
    public static final String url1 = "http://opencart.abstracta.us/";
    public static final By lSearch1 = By.cssSelector("input[name='search']");

    public By getXpath(LocalDate date){
        String ay = date.getMonth().toString();
        int gun = date.getDayOfMonth();
        return By.xpath("//div[./h2[contains(text(), '" + ay + "')]]//*[contains(text(),'" + gun +"')]");
    }


}
