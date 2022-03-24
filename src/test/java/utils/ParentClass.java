package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class ParentClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentClass(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    /**
     * aldigi url"e driver.get eden method
     * @param url string
     */
    public void openSite(String url){
        driver.get(url);
    }

    /**
     * aldigi By class"indan locatora click eden method
     * @param locator By
     */
    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * aldigi WebElement clickable oluncaya kadar bekler ve click eder
     * @param element WebElement
     */
    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendkeysTo(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    public void sendkeysTo(By locator, String text, boolean clear){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (clear)
            element.clear();
        element.sendKeys(text);
    }

    public void waitFor(By locator, WaitConditions waitCondition){
        switch (waitCondition){
            case exist:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
        }
    }

    public void hover(WebElement element){
        hover(element, 10);
    }

    public void hover(WebElement element, long milis){
        new Actions(driver).moveToElement(element).pause(milis).build().perform();
    }

    public boolean isExist(By locator){
        return driver.findElements(locator).size()>0;
    }

    public boolean isExist1(By locator){
        try {
            driver.findElement(locator);
            return true;
        }catch (Exception e){
           return false;
        }
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyTextIn(By locator, String str){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(notification.getText().toLowerCase().contains(str.toLowerCase()));
    }


    @AfterSuite
    public void afterSuite(){
        sleep(3000);
        Driver.quitDriver();
    }


}
