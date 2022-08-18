package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {
    public static void main(String[] args) {
        /*int[] arr = {1, 2, 3, 4, 5};
        RotationType rotationType = RotationType.Left;
        switch (rotationType) {
            case Left:
                //LeftRotation(2, arr);
                break;
            case Right:
                RightRotation(4, arr);
                break;
            default: break;
        }

        List<Integer> result = LeftRotation(2, Arrays.asList(1, 2, 3, 4, 5));
        for(int i =0; i < result.size(); i++) {
            System.out.print(result.get(i) + ", ");
        }*/

        int[] result = matchingStrings(new String[]{"aba","baba","aba","xzxb"}, new String[]{"aba","xzxb","ab"});
        displayArray(result);

        result = matchingStrings(new String[]{"def","de","fgh"}, new String[]{"de","lmn","fgh"});
        displayArray(result);
    }

    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void LeftRotation(int numberOfRotations, int[] arr) {
        int[] result = new int[arr.length];

        System.out.println("Before rotation: ");
        for (int i =0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        // Set first numberOfRotations elements into new array
        for (int i = 0; i < arr.length-numberOfRotations; i++) {
            result[i] = arr[numberOfRotations+i];
        }

        // Set last numberOfRotations elements into new array
        for (int i = 0; i < numberOfRotations; i++) {
            result[arr.length-1-i] = arr[numberOfRotations-1-i];
        }

        System.out.println("\nAfter rotating " + numberOfRotations + " elements");
        for (int i =0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static void RightRotation(int numberOfRotations, int[] arr) {

    }

    public static List<Integer> LeftRotation(int numberOfRotations, List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        // Set first numberOfRotations elements into new array
        for (int i = 0; i < arr.size()-numberOfRotations; i++) {
            result.add(arr.get(numberOfRotations+i));
        }

        // Set last numberOfRotations elements into new array
        for (int i = 0; i < numberOfRotations; i++) {
            result.add(arr.get(i));
        }
        return result;
    }

    public static void RightRotation(int numberOfRotations, List<Integer> arr) {

    }

    public static int[] matchingStrings(String[] strings, String[] queries) {
        int[] matchingResult = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int match = 0;
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])) {
                    match++;
                }
            }
            matchingResult[i] = match;
        }
        return matchingResult;
    }
}

enum RotationType {
    Left,
    Right
}
