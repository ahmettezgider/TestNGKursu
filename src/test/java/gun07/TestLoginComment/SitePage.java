package gun07.TestLoginComment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SitePage {

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://opencart.abstracta.us/";
    By lUsername = By.id("input-email");
    By lPassword = By.id("input-password");
    By lLoginSubmit = By.cssSelector("input[value='Login']");
    By lMenuMyAccount = By.xpath("//a[@title='My Account']");
    By lSubmit = By.cssSelector("input-enquiry");
    By lInquery = By.id("input-enquiry");


    public SitePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void gotoURL(){
        driver.get(url);
    }

    public void login(String username, String password){
        driver.findElement(lMenuMyAccount).click();
        driver.findElement(getXPathOf("Login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPassword)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginSubmit)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(getXPathOf("Logout")));
    }

    public By getXPathOf(String str){
        return By.xpath("//a[text()='" + str + "']");
    }

    public By getXPathOfSiteMap(String str){
        return By.xpath("//ul[@class='breadcrumb']//a[text()='" + str + "'] ");
    }

    public void gotoContact(){
        driver.findElement(getXPathOf("Contact Us")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getXPathOfSiteMap("Contact Us")));
    }

    public void writeCommentToContact(String str){
        writeTo(lInquery, str);
    }

    public void writeTo(By locator, String str){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(str);
        System.out.println(driver.findElement(locator).getAttribute("value"));
    }

    public void clickToSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(lSubmit)).click();
    }


    public void logOut(){
        driver.findElement(lMenuMyAccount).click();
        driver.findElement(getXPathOf("Logout")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(getXPathOf("Login")));
    }



}
