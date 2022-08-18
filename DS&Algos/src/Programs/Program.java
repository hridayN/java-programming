package Programs;

public class Program {
    public static void main(String[] args) {
        //System.out.print(fibonacci(5));
        //fibonacciSequence(5, 1);
        // System.out.println("Factorial for 5 is: " + factorial(5));
        calculateMedian(5);
    }

    public static int fibonacci(int numbers) {
        if (numbers == 0) {
            return 0;
        }
        if (numbers == 1) {
            return 1;
        }

        return fibonacci(numbers-1) + fibonacci(numbers-2);
    }

    public static void fibonacciSequence(int totalNumbers, int start) {
        int[] sequence = new int[totalNumbers];
        sequence[0] = (start == 0 || start <= 0) ? 0 : 1;
        sequence[1] = 1;
        for(int i = 2; i < totalNumbers; i++) {
            sequence[i] = sequence[i-1] + sequence[i-2];
        }
        printArray(sequence);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static int factorial(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    /*Median should be such that:
    For even: left = right = n/2
    For odd: left = right - 1
     */
    public static void calculateMedian(int n) {
        int median = n/2, left = 0, right = 0;
        // {0, 1}, {2,3,4}
        System.out.print(String.format("Median: %d", median));
    }
}
