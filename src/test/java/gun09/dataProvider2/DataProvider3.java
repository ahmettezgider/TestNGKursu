package gun09.dataProvider2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class DataProvider3 {


    @Test(dataProvider = "DataproviderObject")
    public void write(String str, int num){
        System.out.println(str + ", " + num);
    }

    @Test(dataProvider = "DataproviderIterator", priority = 1)
    public void write1(String str, int num){
        System.out.println(str + ", " + num);
    }


    @DataProvider(name = "DataproviderObject")
    public Object[][] objectData(){
        Object[][] data = new Object[][]{
                {"A", 1},
                {"B", 2},
                {"C", 3}
        };
        return data;
        /*
        {
            {}
            {}
         }
         */
    }


    @DataProvider(name = "DataproviderIterator")
    public Iterator<Object[]>  iteratorData(){
        ArrayList<Object[]> data = new ArrayList<>();

        Object[] o1 = new Object[]{"A", 1};
        data.add(o1);
        data.add(new Object[]{"B", 2});
        data.add(new Object[]{"C", 3});
        return data.iterator();
    }

    /*
        [
            {}
            {}
         ]
     */

}
