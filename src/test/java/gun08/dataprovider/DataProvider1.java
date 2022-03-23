package gun08.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

public class DataProvider1 {


    @Test(dataProvider = "getData")
    public void test1(String name, String surname, int age, double height){
        System.out.println(name + ", " + surname + ", " + age + ", " + height);
    }


    /*
        Data Provider
     */
    @DataProvider
    public Object[][] getData(){
        Object[][] data = {
                {"A", "AS", 12, 1.23},
                {"B", "BS", 34, 1.87},
                {"C", "CS", 3, 0.78},
                {"D", "DS", 67, 1.55},
                {"E", "ES", 23, 1.67}
        };
        return data;
    }

}
