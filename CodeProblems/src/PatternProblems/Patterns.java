package PatternProblems;

import java.util.Arrays;
import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {
        // pattern1(-1);
        /*int totalJumps = totalJumps(10, 1, 1, new int[]{ 10 });
        System.out.print(totalJumps);*/
        // int points = rewardPoints(3, 7, new int[]{2,6,9}, new int[]{3,5,3});
        //System.out.print(points);

        int[] arr = new int[50];
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            int input = scn.nextInt();
            arr[i] = input;
        }
        scn.close();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result[i] = arr[0] * arr[1];
            } else if (i == arr.length - 1) {
                result[i] = arr[arr.length - 1] * arr[arr.length - 2];
            } else {
                result[i] = arr[i - 1] * arr[i + 1];
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static void pattern1(int num) {
        if (num < 1) {
            System.out.print("Please provide number greater than or equal to 1.");
        } else if (num == 1) {
            System.out.print(num);
        } else {
            // print 1st row
            printFirstOrLastRow(num);

            // print 2nd to middle-1 rows
            printTopToMiddle(num);

            // print middle row
            printMiddleRow(num);

            // print middle+1 to 2n-2 rows
            printMiddleToBottom(num);

            // print last row
            printFirstOrLastRow(num);
        }
    }

    public static void printFirstOrLastRow(int num) {
        for (int i = 0; i < 2 * num - 1; i++) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void printMiddleRow(int num) {
        int cols = 2 * num - 1, counter = 0, valueToPrint = num;
        boolean middlePrinted = false;
        while (counter < cols) {
            if (!middlePrinted && valueToPrint != 1) {
                System.out.print(valueToPrint);
                valueToPrint--;
            } else if (valueToPrint == 1) {
                System.out.print(valueToPrint++);
                middlePrinted = true;
            } else {
                System.out.print(valueToPrint++);
            }
            counter++;
        }
        System.out.println();
    }

    public static void printTopToMiddle(int num) {
        int rows = ((2 * num - 1) - 3) / 2;
        for (int i = 0; i < rows; i++) {
            int valueToPrint = num - (i + 1), times = (2 * valueToPrint) - 1, termsToPrintBySelf = (i * 2) + 2, temp = num, valuePrinted = num;
            // print starting
            for (int j = 0; j < termsToPrintBySelf / 2; j++) {
                System.out.print(temp);
                if (j != (termsToPrintBySelf / 2) - 1) {
                    temp--;
                }
            }
            valuePrinted = temp;

            // print middle
            printNTimesValue(times, valueToPrint);

            // print end
            for (int j = 0; j < termsToPrintBySelf / 2; j++) {
                System.out.print(valuePrinted++);
            }

            System.out.println();
        }
    }

    public static void printMiddleToBottom(int num) {
        int rows = ((2 * num - 1) - 3) / 2;
        for (int i = rows; i > 0; i--) {
            int valueToPrint = num - i, times = (2 * valueToPrint) - 1, termsToPrintBySelf = 2 * i, temp = num, valuePrinted = num;
            // print starting
            for (int j = 0; j < termsToPrintBySelf / 2; j++) {
                System.out.print(temp);
                if (j != (termsToPrintBySelf / 2) - 1) {
                    temp--;
                }
            }
            valuePrinted = temp;

            // print middle
            printNTimesValue(times, valueToPrint);

            // print end
            for (int j = 0; j < termsToPrintBySelf / 2; j++) {
                System.out.print(valuePrinted++);
            }

            System.out.println();
        }
    }

    public static void printNTimesValue(int cols, int valueToPrint) {
        for (int i = 0; i < cols; i++) {
            System.out.print(valueToPrint);
        }
    }

    public static int totalJumps(int capacityToJump, int slidesDownBy, int walls, int[] wallSizes) {
        int jumps = 0;
        for(int i = 0; i < walls; i++) {
            int heightAchieved = 0;
            int wallSize = wallSizes[i];
            while(heightAchieved < wallSize) {
                heightAchieved += capacityToJump - slidesDownBy;
                jumps++;
            }
        }
        return jumps;
    }

    public static int rewardPoints(int books, int timeLimit, int[] rewards, int[] timeInfo) {
        int frontRewards = 0, backRewards = 0;
        int timeTaken = 0;
        for (int i = 0; i < timeInfo.length; i++) {
            if (timeTaken+timeInfo[i] <= timeLimit) {
                timeTaken += timeInfo[i];
                frontRewards += rewards[i];
            }
        }

        timeTaken = 0;
        for (int i = timeInfo.length-1; i >= 0; i--) {
            if (timeTaken+timeInfo[i] <= timeLimit) {
                timeTaken += timeInfo[i];
                backRewards += rewards[i];
            }
        }

        return (frontRewards > backRewards) ? frontRewards : backRewards;
    }

    public static void replace(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result[i] = arr[0] * arr[1];
            } else if (i == arr.length - 1) {
                result[i] = arr[arr.length - 1] * arr[arr.length - 2];
            } else {
                result[i] = arr[i - 1] * arr[i + 1];
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}
