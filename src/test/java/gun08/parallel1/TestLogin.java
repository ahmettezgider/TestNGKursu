package gun08.parallel1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin extends TestBaseClass {


    @Test
    public void gotoURL(){
        System.out.println("goto URL");
    }

    @Test(dependsOnMethods = {"gotoURL"}, priority = 1)
    @Parameters({"username", "password"})
    public void login(String username, String password){
        System.out.println("login test");
        System.out.println(username + ", " + password);
    }

    @Test(priority = 2)
    public void logOut(){
        System.out.println("logout");
    }

}
