package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.List;
import java.util.Random;

import static gun11.RandomUrunLocators.*;
import static gun11.RandomUrunLocatorsClass.*;

public class RandomUrun extends ParentClass {

    List<WebElement> products;
    List<WebElement> productPrices;
    List<WebElement> productAddToCarts;

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
        Object[] myUrun = {products.get(rUrun).getText(), getPriceAsNumber(productPrices.get(rUrun).getText())};

        productAddToCarts.get(rUrun).click();


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
}

class RandomUrunLocatorsClass {
    public static final String url1 = "http://opencart.abstracta.us/";
    public static final By lSearch1 = By.cssSelector("input[name='search']");


}
