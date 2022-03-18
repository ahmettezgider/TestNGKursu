package gun05;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;

public class TestEditAccount1 extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void test_GotoSite(){
        homePage.gotoSite();
    }

    @Test(dependsOnMethods = {"test_GotoSite"})
    public void test_Login(){
        homePage.gotoLogin();
        homePage.loginAs("testngkurs@gmail.com", "testngkurs");
    }

    @Test(dependsOnMethods = {"test_GotoSite", "test_Login"})
    public void test_UpdateMyAccount1(){
        homePage.clickLinkText("Edit Account");
        homePage.updateAccount("A", "A", "123");
        homePage.verifyNotification("successfull");
    }

    @Test(dependsOnMethods = {"test_GotoSite", "test_Login"})
    public void test_UpdateMyAccount2(){
        homePage.clickLinkText("Edit Account");
        homePage.updateAccount("testngkurs", "testngkurs", "123456789");
        homePage.verifyNotification("successfull");
    }


    /*
        priority siralama verir.
        önceki test basarisiz olsa da pesinen gelen test calistirilir.


        dependsOnMethods  ise bagimlilik ifade eder.
        Bagimli oldugu test basarili olursa o test calisir,
        basarisiz olursa o test skip edilir.

     */


}
