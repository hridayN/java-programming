package Patterns;

public class Pattern {

    public static void main(String[] args) {
        //NbyNSquareStarPattern(5);
        //NbyNHollowSquareStarPattern(5);
        //RowNumberStarsPattern(5);
        //RowNumberStarsPatternReverse(5);
        //RowNumberStarsPatternMirrorImage(5);
        //RowNumberNumbersPattern(5);
        //InvertedHalfNumberPyramidPattern(5);
        //FloydsTriangle(5);
        //FloydsTriangleWith101(5);
        //ButterflyPattern(5);
        //SolidRhombus(5);
        //NumberPyramidLeftInclined(5);
        //NumberSquarePyramidPattern(3);
        // PrintCenterRow(3);
        // PerfectNumberPyramid(5);
        PalindromePattern(5);
    }

    /* Print * in nxn shape
     * For solving this, think of solving to print the * n times(i.e., column times) in a single row(horizontally)
     * Then, make an outer loop, which will print n rows
     */
    public static void NbyNSquareStarPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void NbyNHollowSquareStarPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void RowNumberStarsPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void RowNumberStarsPatternReverse(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void RowNumberStarsPatternMirrorImage(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //System.out.print(String.format("%d", i+j));
                if (i+j > n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void RowNumberNumbersPattern(int n) {
        for (int i = 1; i <= n; i++) {
            int count = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(String.format("%d ", count++));
            }
            System.out.println();
        }
    }

    public static void InvertedHalfNumberPyramidPattern(int n) {
        for (int i = n; i >= 1; i--) {
            int count = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(String.format("%d ", count++));
            }
            System.out.println();
        }
    }

    public static void FloydsTriangle(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(String.format("%d ", count++));
            }
            System.out.println();
        }
    }

    public static void FloydsTriangleWith101(int n) {
        int variable = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(String.format("%d ", variable));
                variable = (variable == 1) ? 0 : 1;
            }
            System.out.println();
        }
    }

    public static void ButterflyPattern(int n) {
        int cols = n*2;
        ButterflyPatternTop(n, cols);
        ButterflyPatternBottom(n, cols);
    }

    public static void ButterflyPatternTop(int n, int cols) {
        for (int i = 1; i <= cols/2; i++) {
            // print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // print spaces
            for (int j = i+1; j <= cols-i; j++) {
                System.out.print(String.format("  "));
            }

            // print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void ButterflyPatternBottom(int n, int cols) {
        for (int i = cols/2; i >= 1; i--) {
            // print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // print spaces
            for (int j = i+1; j <= cols-i; j++) {
                System.out.print(String.format("  "));
            }

            // print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void SolidRhombus(int n) {
        int cols = 2*n-1;
        // height
        for (int i = 1; i <= n; i++) {
            int charsPrinted = 0;
            // print charsPrinted
            for (int j = n-1; j >= i; j--) {
                System.out.print("_");
                charsPrinted++;
            }

            // print Symbol
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
                charsPrinted++;
            }

            // print charsPrinted
            for (int j = 0; j < cols-charsPrinted; j++) {
                System.out.print("_");
            }
            System.out.println();
        }
    }

    public static void NumberPyramidLeftInclined(int n) {
        int counter = 1;
        // height
        for (int i = 1; i <= n; i++) {
            int charsPrinted = 0;
            // print 1st space
            System.out.print("_");
            charsPrinted++;

            // print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(counter);
                charsPrinted++;
            }

            // print last spaces
            for (int j = 1; j <= n-charsPrinted; j++) {
                System.out.print("_");
            }
            counter++;
            System.out.println();
        }
    }

    public static void PerfectNumberPyramid(int n) {
        int counter = 1;
        // height
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            // Print number
            for (int j = 1; j <= i; j++) {
                // Print same number, row times
                System.out.print(counter);

                // Print a space after every number, except at the last
                if (j != i) {
                    System.out.print(" ");
                }
            }

            // Print spaces at the last of numbers
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            // Increment the number after every row
            counter++;
            System.out.println();
        }
    }

    public static void PerfectPalindromicPattern(int n) {
        int cols = 2 * n - 1;

        // height
        for (int i = 1; i <= n; i++) {
            int counter = 1;
            // Print spaces
            for (int j = 1; j <= i; j++) {
                System.out.print("_");
            }

            for (int j = 1; j <= (2*i-1); j++) {
                if (j < i) {
                    System.out.print(counter);
                }
            }
        }
    }

    public static void PalindromePattern(int n) {
        // height
        for (int i = 1; i <= n; i++) {
            int numbersInARow = 2*i-1;
            // Print spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            // print number
            int counter = i, charsPrinted = 0;
            for (int j = 1; j <= numbersInARow; j++) {
                if (counter >= 1) {
                    System.out.print(counter--);
                    charsPrinted++;
                }
            }

            // print remaining numbers of row
            if (counter == 0) {
                counter++;
                for (int j = 1; j <= numbersInARow-charsPrinted; j++) {
                    System.out.print(++counter);
                }
            }


            System.out.println();
        }
    }

    /*public static int[] GetReversePalindrome(int n) {
        int[] arr = new int[n];
        if (n == 0) {
            arr[0] = 0;
        } else if (n == 1) {
            arr[0] = 1;
        }

        return GetReversePalindrome(n--);
    }*/

    // 4444444
    // 4333334
    // 4322234
    // 4321234
    // 4322234
    // 4333334
    // 4444444
}
