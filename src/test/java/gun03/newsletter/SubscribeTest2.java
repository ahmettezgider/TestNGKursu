package gun03.newsletter;

import org.testng.annotations.Test;
import pages.HomePage;

public class SubscribeTest2 extends ParentTestClass{


    @Test
    public void testGotoLogin1(){
        HomePage homePage = new HomePage();
        homePage.gotoSite();
        homePage.gotoLogin();
    }
}
