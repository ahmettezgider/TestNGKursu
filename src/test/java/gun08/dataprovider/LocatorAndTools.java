package gun08.dataprovider;

import org.openqa.selenium.By;

public class LocatorAndTools {

    public static String url = "https://opencart.abstracta.us/index.php?route=account/login";
    public static By lUsername = By.id("input-email");
    public static By lPassword = By.id("input-password");
    public static By lLoginSubmit = By.cssSelector("input[value='Login']");
    public static By lLogout = By.xpath("//a[text()='Logout']");
    public static By lNotification = By.cssSelector("div.alert.alert-danger");

    public static void getDriverStatikSample(String username){
        System.out.println(username);
    }

}
