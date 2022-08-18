package Basics;

public class Complexity {
    public static void main(String[] args) {
        logOfLogN(1);
        // logOfLogN(2);
    }

    /* Complexity: O(log(log n)) */
    public static void logOfLogN(int k) {
        // n = 2^(2^k)
        double n = Math.pow(2, Math.pow(2, k));
        /*System.out.println("n: " + n);*/
        for (int i = 1; i <= n; i++) {
            double j = 2, counter = 0;
            while (j <= n) {
                j = Math.pow(j, 2);
                counter++;
            }
            System.out.println("counter: " + counter);
        }
    }
}
