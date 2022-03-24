package gun09.pagemodels.m5;

import org.openqa.selenium.By;

public class Locators {
    public static final By lMyAccount = By.cssSelector("a[title='My Account']");
    public static final By lLogin = By.xpath("//a[text()='Login']");
    public static final By lUsername = By.id("input-email");
    public static final By lPassword = By.id("input-password");
    public static final By lLoginButton = By.cssSelector("input[value='Login']");
    public static final By lLogout = By.xpath("//a[text()='Logout']");

}
