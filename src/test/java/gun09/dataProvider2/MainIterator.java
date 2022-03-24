package gun09.dataProvider2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainIterator {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        for (Integer num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
        System.out.println("---------------------");

        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }

    }
}
