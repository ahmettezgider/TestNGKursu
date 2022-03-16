package gun03.newsletter;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import utils.Driver;
import utils.ParentClass;

public class SubscribeTest extends ParentTestClass {



    @Test
    public void TestLogin(){

       HomePage homePage = new HomePage();
       homePage.gotoSite();
       homePage.gotoLogin();

    }




}
