package gun07.TestLoginComment;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin extends TestBaseClass{

    SitePage sitePage;

    @Test
    public void gotoURL(){
        sitePage  = new SitePage(driver);
        sitePage.gotoURL();
    }

    @Test(dependsOnMethods = {"gotoURL"}, priority = 1)
    @Parameters({"username", "password"})
    public void login(String username, String password){
        sitePage.login(username, password);
    }

    @Test(priority = 2)
    public void logOut(){
        sitePage.logOut();
    }

}
