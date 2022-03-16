package gun03.newsletter;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.ParentClass;

public class SubscribeTest3 extends ParentClass {

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By mainMenuMyAccount = By.cssSelector("a[title='My Account']");
    By mainMenuMyAccountLogin = By.linkText("Login");

    @Test
    public void TestLogin() {
        openSite(url);
        clickTo(mainMenuMyAccount);
        clickTo(mainMenuMyAccountLogin);


    }


}
