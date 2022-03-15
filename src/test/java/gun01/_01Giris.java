package gun01;

import org.testng.annotations.Test;

// @Test annotation"i olan classlar TestNG classlaridir.
// @Test annotation"i olan method ve class calistirilabilir
// bir test calistirildiginda o class"dan bir nesne olusturak calistirir.
// @Test annotation"i olan her bir method ayri ayri calistirilabilir.

public class _01Giris {

    public static void main(String[] args) {
        System.out.println("main");

        _01Giris giris = new _01Giris();
        //giris.test1();
        giris.test2();


    }


    int number = 10;

    // Instance initializer. Nesne olustugunda constructordan önce calisir
    {
        System.out.println("instance initializer");
    }

    public _01Giris(){
        System.out.println("constuctor");
        System.out.println(number);
    }

    @Test
    void test1(){
        System.out.println("testNG-1 " + number);
    }

    @Test
    void test2(){
        System.out.println("testNG-2");
    }



    /*
        Functional testlerin yapilmasi icin bir tool
        Assertion
        Testleri organize

        TestNG - JUnit
        Annotations
        @Test
        @BeforeClass
        @AfterTest
        .....

     */


}
