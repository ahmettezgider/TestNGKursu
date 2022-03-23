package gun08.dataprovider;

import java.util.Scanner;

public class ObjectOrnek {

    public static void main(String[] args) {


        int a = 1;
        String s = "a";

        Object a1 = 3;
        Object s1 = "aaaaa";

        int[] arr1 = {1,2,3,4,5};
        String[] arr2 = {"a", "b", "c"};

        int[] arr3 = new int[]{1,2,3,4,5};
        int[] arr4 = new int[5];


        Object[] objArr = {1, 1.3, "a", new int[]{1,2,3}, new Scanner(System.in), new ObjectOrnek()};

        Object num1 = 10;
        Object num2 = 2;
        System.out.println(Integer.parseInt(num1.toString()) % Integer.parseInt(num2.toString()) );



    }
}
