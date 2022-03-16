package gun03.newsletter;

import org.testng.annotations.Test;

public class SubscribeTest2 extends ParentTestClass{


    @Test
    public void testGotoLogin1(){
        HomePage homePage = new HomePage();
        homePage.gotoSite();
        homePage.gotoLogin();
    }
}
