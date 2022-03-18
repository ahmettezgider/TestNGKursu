package gun03.newsletter;

import org.testng.annotations.Test;
import pages.HomePage;

public class SubscribeTest extends ParentTestClass {



    @Test
    public void TestLogin(){

       HomePage homePage = new HomePage();
       homePage.gotoSite();
       homePage.gotoLogin();

    }




}
