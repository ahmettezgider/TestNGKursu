package gun07.TestLoginComment;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAccount extends TestBaseClass{

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

    @Test(priority = 3)
    @Parameters({"contactText"})
    public void fillContactUs(String text){
        sitePage.gotoContact();
        sitePage.writeCommentToContact(text);
        sitePage.clickToSubmit();
    }

    @Test(priority = 4)
    public void end(){
        sitePage.logOut();
    }


}
