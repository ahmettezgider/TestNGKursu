package gun06.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass3 {

    @Test
    @Parameters("name") //buradaki parametre ismi ile xml"deki isim ayni olmali
    public void isimYaz(String a){
        System.out.println(a);
    }
}
