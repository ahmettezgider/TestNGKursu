package gun09.softassert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _02SoftAssert {

    /*
        soft assert, tüm assertleri tamamladiktan sonra sonucu verir
        Hatalarda kesmez
     */

    SoftAssert sa = new SoftAssert();

    @Test
    public void Test1(){
        sa.assertTrue(false);
        System.out.println("test1");

        sa.assertTrue(true);  // asserti degerlendirir, isleme koymaz
        System.out.println("test2");

        sa.assertAll();  // bu satirla üstteki tüm assertler isletilir
    }

    @Test(priority = -1)
    public void Test2(){
        Assert.assertTrue(false);  // burada testi keser
        System.out.println("test1");

        Assert.assertTrue(true);
        System.out.println("test2");

    }

}
