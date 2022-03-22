package gun07.TestLoginComment;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAccount extends TestBaseClass{

    SitePage sitePage;

    @Test
    @Parameters({"contactText"})
    public void fillContactUs(String text){
        sitePage.gotoContact();
        sitePage.writeCommentToContact(text);
        sitePage.clickToSubmit();
    }

    @Test(priority = 1)
    public void end(){
        sitePage.logOut();
    }


}
