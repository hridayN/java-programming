package OCAJP;

import java.util.ArrayList;
import java.util.List;

public class Chapter2 {
    public static void main(String[] args) {
        final String[] names = new String[3];
        names[0] = "Name1";
        names[1] = "Name2";
        names[2] = "Name3";

        // possible because ArrayList extends AbstractList which implements List interface
        List<String> values = new ArrayList<String>();

        int[][] list = {{1, 2, 3}, {6, 8, 4}, {2, 6, 9}};
        //searchWithOptionalLabelExample(list, 2);
        //searchWithoutBreakExample(list, 2);
        //searchWithInnerBreakExample(list, 2);
        //print2DArray(list);

        //ternaryTester();
        weirdCompilation4();
    }

    public static void searchWithOptionalLabelExample(int[][] arr, int valueToSearch) {
        int row = -1, col = -1;
        // OuterLoop is the label for outer most loop
        OuterLoop: for (int i = 0; i < arr.length; i++) {
            InnerLoop: for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == valueToSearch) {
                    row = i;
                    col = j;
                    break OuterLoop;    // this will break the outer most loop as and when the match is found
                }
            }
        }
        System.out.println("searchWithOptionalLabelExample's output: " + valueToSearch + " found in: " + row + "th array, " + col + "th index");
    }

    public static void searchWithoutBreakExample(int[][] arr, int valueToSearch) {
        int row = -1, col = -1;
        // OuterLoop is the label for outer most loop
        OuterLoop: for (int i = 0; i < arr.length; i++) {
            InnerLoop: for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == valueToSearch) {
                    row = i;
                    col = j;
                    //break OuterLoop;    // this will break the outer most loop as and when the match is found
                }
            }
        }
        System.out.println("searchWithoutBreakExample's output: " + valueToSearch + " found in: " + row + "th array, " + col + "th index");
    }

    public static void searchWithInnerBreakExample(int[][] arr, int valueToSearch) {
        int row = -1, col = -1;
        // OuterLoop is the label for outer most loop
        OuterLoop: for (int i = 0; i < arr.length; i++) {
            InnerLoop: for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == valueToSearch) {
                    row = i;
                    col = j;
                    break;    // this will break the inner loop as and when the match is found
                }
            }
        }
        System.out.println("searchWithInnerBreakExample's output: " + valueToSearch + " found in: " + row + "th array, " + col + "th index");
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("[" + i + ", " + j + "]: " + arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void ternaryTester() {
        int x = 5;
        System.out.println(x > 2? x < 4 ? 10 : 8 : 7);
        if (x > 2) {
            if (x < 4) {
                System.out.print(10);
            } else {
                System.out.print(8);
            }
        } else {
            System.out.print(7);
        }
    }

    public static void weirdCompilation1() {
        final char a = 'A', d = 'D';
        char grade = 'B';
        switch(grade) {
            case a:
            case 'B': System.out.print("great");
            case 'C': System.out.print("good"); break;
            case d:
            case 'F': System.out.print("not good");
        }
    }

    public static void weirdCompilation2() {
        boolean x = true, z = true;
        int y = 20;
        x = (y != 10) ^ (z=false);  // here we are assigning false to z, overall expression: (true)^(false)
        System.out.println(x+", "+y+", "+z);
    }

    public static void weirdCompilation3() {
        int counter = 1;
/*        The expression inside the loop increments
        i but then assigns i the old value. Therefore, i ends the loop with the same value
        that it starts with: 0. The loop will repeat infinitely, outputting the same statement over
        and over again because i remains 0 after every iteration of the loop.*/
        for (int i = 0; i < 10; ) {
            i = i++;
            System.out.println(counter++ + "Hello World");
        }
    }

    public static void weirdCompilation4() {
        int count = 0;
        ROW_LOOP: for(int row = 1; row <=3; row++)
                    for(int col = 1; col <=2 ; col++) {
                        if (row * col % 2 == 0) continue ROW_LOOP;      // here we are continuing the execution of ROW_LOOP (by incrementing row further)
                        count++;
                    }
        System.out.println(count);
    }

    public static void weirdOutput1() {
        int x1 = 50, x2 = 75;
        boolean b = x1 >= x2;
        if(b = true) System.out.println("Success");     // here we are assigning true to b, so if condition is: if (true)
        else System.out.println("Failure");
    }
}
