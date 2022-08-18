package OCAJP.Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {
        //basics();
        convertingArrayToList();
    }

    public static void basics() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        System.out.println("list: " + list);

        // here, 1 is taken as an index
        list.remove(1);

        // here we are passing 1 as actual value to be removed
        list.remove(new Integer(1));

        System.out.println("list: " + list);
    }

    public static void autoBoxingInToInteger() {

    }

    public static void convertingArrayToList() {
        String[] stringArray =  {"first", "second"};
        System.out.println("stringArray: " + Arrays.asList(stringArray));

        List<String> stringList = Arrays.asList(stringArray);       // list and array, both point to the same data store here.
        System.out.println("stringList: " + stringList);

        stringList.set(1, "third");
        System.out.println("stringList: " + stringList);
        System.out.println("stringArray: " + Arrays.asList(stringArray));

        stringArray[0] = "fourth";
        System.out.println("stringList: " + stringList);
        System.out.println("stringArray: " + Arrays.asList(stringArray));
    }
}
