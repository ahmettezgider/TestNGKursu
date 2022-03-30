package gun03.newsletter;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverSingleton;

public class ParentTestClass {

    @BeforeSuite
    public void beforeSuite(){

    }



    @AfterSuite
    public void afterSuite(){
        DriverSingleton.quitDriver();
    }
}
