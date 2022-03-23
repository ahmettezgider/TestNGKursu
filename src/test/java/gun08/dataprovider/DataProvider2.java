package gun08.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ParentClass;
import utils.WaitConditions;
import static gun08.dataprovider.LocatorAndTools.*;


public class DataProvider2 extends ParentClass {
    /*
        https://opencart.abstracta.us/index
        adresinin login kisminda
        10 farkli yetkisiz kullanici ve sifre ile giris yapmaya calisin
        siteye girilemedigini asset edin.
     */



    @Test(dataProvider = "data")
    public void test1(String username, String password, int status){

        LocatorAndTools.getDriverStatikSample(username);

        openSite(LocatorAndTools.url);
        sendkeysTo(lUsername, username, true);
        sendkeysTo(lPassword, password, true);
        clickTo(lLoginSubmit);
        if (status == 0){
            verifyTextIn(lNotification, "Warning");
        }else{
            waitFor(lLogout, WaitConditions.exist);
            /*
                logout yapmak lazim
             */
        }
    }


    @DataProvider(name = "data")
    public Object[][] getDate(){
        Object[][] data = {
                {"hleetham0@usnews.com", "Dz7pYk", 0},
                {"mvawton1@ebay.co.uk", "P6uQ10x07pbo", 0},
                {"ijonuzi2@blogger.com", "ueQsdRg", 0},
                {"rhackley3@phpbb.com", "BrQmT8OQy3d8", 0},
                {"sbaylis4@admin.ch", "2FrLKz", 0},
                {"bdunsford5@gnu.org", "0h0Ej32", 0},
                {"dmarven6@accuweather.com", "lLIXdOlqjrR", 0},
                {"adalgarnowch7@mediafire.com", "cbZt2ZqlCvf3", 0},
                {"eneal8@drupal.org", "bwwy0aBJIJ", 0},
                {"cdovington9@list-manage.com", "o7CbGpxaalv", 0},
                {"bdorkena@github.com", "8AjXlD6", 0},
                {"hbendb@imdb.com", "mCdonxCK2Ix", 0},
                {"cburnhillc@stumbleupon.com", "s9KIhZYWF57", 0},
                {"dcastelaind@timesonline.co.uk", "zEWuz4URBkP", 0},
                {"lcradducke@google.co.jp", "RUIP3F", 0},
                {"testngkurs@gmail.com", "testngkurs", 1},
        };
        return data;
    }

}
