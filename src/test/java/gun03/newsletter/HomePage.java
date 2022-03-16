package gun03.newsletter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.ParentClass;

public class HomePage extends ParentClass {

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By mainMenuMyAccount = By.cssSelector("a[title='My Account']");
    By mainMenuMyAccountLogin = By.linkText("Login");


    public void gotoSite(){
        openSite(url);
    }

    public void gotoLogin(){
        clickTo(mainMenuMyAccount);
        clickTo(mainMenuMyAccountLogin);

    }

    @Test
    public void Testt(){

    }


}
