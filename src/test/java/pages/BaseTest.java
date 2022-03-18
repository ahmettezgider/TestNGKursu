package pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Driver;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite(){

    }




    @AfterSuite
    public void afterSuite(){
        Driver.quitDriver();
    }

}
