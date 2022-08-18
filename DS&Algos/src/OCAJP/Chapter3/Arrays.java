package OCAJP.Chapter3;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30 };
        // print(arr);
        //assignments();
        binarySearch(arr, 20);
        binarySearch(arr, 11);
    }

    public static void print(int[] arr) {
        java.util.Arrays.toString(arr);
    }

    public static void assignments() {
        String[] strings = { "stringvalues" };
        Object[] objects = strings;
        String[] strings2 = (String[]) objects;
        // strings2[0] = new StringBuilder();   // StringBuilder is not a String, can't be stored as String
        /*
        here, objects is an array containing string array, and we can't store StringBuilder into String[]
        at runtime we get ArrayStoreException
        */
        objects[0] = new StringBuilder();
    }

    public static void binarySearch(int[] arr, int num) {
        /*
        i. if num is found at a index, we get that index
        ii. if num is not found, we get (negation of index at which num should have been + -1)
        */
        System.out.println(java.util.Arrays.binarySearch(arr, num));
    }
}
