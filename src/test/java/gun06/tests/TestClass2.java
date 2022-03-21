package gun06.tests;

import org.testng.annotations.Test;

public class TestClass2 {


    @Test(groups = {"TestGrup1"}, dependsOnMethods = {"test6"})
    public void test4(){
        System.out.println("Test-4");
    }

    @Test(groups = {"TestGrup2"})
    public void test5(){
        System.out.println("Test-5");
    }

    @Test(groups = {"TestGrup1", "TestGrup2", "TestGrup3"})
    public void test6(){
        System.out.println("Test-6");
    }




}
