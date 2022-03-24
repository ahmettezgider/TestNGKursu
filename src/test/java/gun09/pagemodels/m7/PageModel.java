package gun09.pagemodels.m7;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class PageModel extends ParentPM {


    @Test
    public void Test_Login(){
        driver.get("https://opencart.abstracta.us/index.php");
        click(lMyAccount);
        click(lLogin);
        sendkeys(lUsername, "testngkurs@gmail.com");
        sendkeys(lPassword, "testngkurs");
        click(lLoginButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(lLogout));
    }



}
