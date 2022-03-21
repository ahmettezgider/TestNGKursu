package gun06.tests;

import org.testng.annotations.Test;

public class TestClass1 {

    @Test(groups = {"TestGrup1"})
    public void test1(){
        System.out.println("Test-1");
    }

    @Test(groups = {"TestGrup1", "TestGrup2"})
    public void test2(){
        System.out.println("Test-2");
    }

    @Test(groups = {"TestGrup2"})
    public void test3(){
        System.out.println("Test-3");
    }




}
