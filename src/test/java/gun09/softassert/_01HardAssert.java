package gun09.softassert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01HardAssert {

    @Test
    public void Test1(){
        Assert.assertTrue(true);
        System.out.println("test1");
    }

    @Test
    public void Test2(){
        Assert.assertTrue(false);
        System.out.println("test2");
    }

    /*
        Hata varsa orada test kesilir

     */


}
