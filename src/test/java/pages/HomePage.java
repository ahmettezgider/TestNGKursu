package pages;

import org.openqa.selenium.By;
import utils.ParentClass;
import utils.WaitConditions;

public class HomePage extends ParentClass {

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By mainMenuMyAccount = By.cssSelector("a[title='My Account']");
    By mainMenuMyAccountLogin = By.linkText("Login");
    By lNotification = By.cssSelector("div.alert.alert-success");
    By lLoginEmail = By.id("input-email");
    By lLoginPassword = By.id("input-password");
    By lLoginSubmitButton = By.xpath("//input[@value='Login']");
    By lLogout = By.xpath("//div[@id='top-links']//a[text()='Logout']");

    By lEditAccountFirstname = By.id("input-firstname");
    By lEditAccountLastname = By.id("input-lastname");
    By lEditAccountTelephone = By.id("input-telephone");
    By lEditAccountContinueButton = By.xpath("//input[@value='Continue']");


    public void gotoSite(){
        openSite(url);
    }

    public void gotoLogin(){
        clickTo(mainMenuMyAccount);
        clickTo(mainMenuMyAccountLogin);

    }

    public void loginAs(String username, String password){
        sendkeysTo(lLoginEmail, username);
        sendkeysTo(lLoginPassword, password);
        clickTo(lLoginSubmitButton);
        waitFor(lLogout, WaitConditions.exist);
    }


    public void verifyNotification(String str){
        verifyTextIn(lNotification, str);
    }

    public void clickLinkText(String str){
        clickTo(By.partialLinkText(str));
    }

    public void updateAccount(String firstname, String lastname, String telephone){
        sendkeysTo(lEditAccountFirstname, firstname, true);
        sendkeysTo(lEditAccountLastname, lastname, true);
        sendkeysTo(lEditAccountTelephone, telephone, true);
        clickTo(lEditAccountContinueButton);
    }


}
