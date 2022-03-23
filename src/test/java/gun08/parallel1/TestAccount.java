package gun08.parallel1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAccount extends TestBaseClass {

    SitePage sitePage;

    @Test
    public void gotoURL(){
        System.out.println("goto URL 2");
    }

    @Test(dependsOnMethods = {"gotoURL"}, priority = 1)
    @Parameters({"username", "password"})
    public void login(String username, String password){
        System.out.println("login Acc");
        System.out.println(username + ", " + password);
    }

    @Test(priority = 3)
    @Parameters({"contactText"})
    public void fillContactUs(String text){
        System.out.println("contact : " + text);
    }

    @Test(priority = 4)
    public void end(){
        System.out.println("logout");
    }


}
