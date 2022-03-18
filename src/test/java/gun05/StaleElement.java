package gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.ParentClass;

public class StaleElement extends ParentClass {

    String url = "http://opencart.abstracta.us";
    By menuDesktops = By.xpath("//ul//*[text()='Desktops']");
    By lNotification = By.cssSelector("div.alert.alert-success");

    @Test
    public void gotoSite(){
        driver.get(url);
    }


    @Test(priority = 1, enabled = false)
    public void clickToDesktops(){
        clickTo(menuDesktops);
    }

    @Test(priority = 1/*, expectedExceptions = {StaleElementReferenceException.class}*/)
    public void clickToDesktops1(){
        WebElement dt = driver.findElement(menuDesktops);
        driver.navigate().refresh();
        clickTo(dt);
        verifyTextIn(lNotification, "successfull");
    }

    /*
        Bir selector refresh öncesi ya da ajax"in ilgili elemeti güncellemesi ya da degistirmesi öncesi
        element halinde alinmissa, refresh sonrasi ya da ajax islemi sonrasi o element ile yapilacak islemler
        StaleElement hatasi verir.
        Bu nedenle selectörlerin ne zaman element"e cevrilecekleri önemlidir.
     */





}
