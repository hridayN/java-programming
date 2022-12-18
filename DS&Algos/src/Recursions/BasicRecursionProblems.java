package Recursions;

public class BasicRecursionProblems {
    public static void main(String[] args) {
        /*int num1 = 2, num2 = 5;
        System.out.println(String.format("Product %d x %d = %d", num1, num2, GetProduct(num1, num2)));*/

        /*int num = 10204;
        System.out.println(String.format("0s in %d: %d", num, GetZeroesCount(num)));*/
        /*int k = 4;
        System.out.println(String.format("Geometric sum upto power %d: %f", k, GetGeometricSum(k)));*/
        int num = 9;
        System.out.println(String.format("Sum of digits of %d= %d", num, GetDigitsSum(num)));
    }

    public static int GetProduct(int num1, int num2) {
        return GetProduct_Logic(num1, num2, 1);
    }

    /*Multiply two numbers recursively using addition operator only */
    public static int GetProduct_Logic(int num1, int num2, int counter) {
        if (counter == num2) return num1;

        return num1 + GetProduct_Logic(num1, num2, counter + 1);
    }

    public static int GetZeroesCount(int num) {
        return GetZeroesCount_Logic(num, 0);
    }

    public static int GetZeroesCount_Logic(int num, int count) {
        if (num < 10) return count;

        if (num % 10 == 0) count++;
        return GetZeroesCount_Logic(num / 10, count);
    }

    public static double GetGeometricSum(int k) {
        return 1 + GetGeometricSum_Logic(k, 1);
    }

    public static double GetGeometricSum_Logic(int k, int counter) {
        if (counter == k) {
            double result = 1 / Math.pow(2, counter);
            // System.out.println(String.format("1/2^%d: %f", counter, result));
            // System.out.println(String.format("Calculating: 1/2^%d", counter));
            return result;
        }
        // System.out.println(String.format("Calculating: 1/2^%d", counter));
        // Calculate for current counter
        double result = (1 / Math.pow(2, counter));

        // Add result of current counter + (counter + 1)
        result += GetGeometricSum_Logic(k, counter + 1);
        // System.out.println(String.format("1/2^%d: %f", counter + 1, result));
        return result;
    }

    public static int GetDigitsSum(int num) {
        if (num < 10) return num % 10;

        int sum = num % 10;
        sum += GetDigitsSum(num / 10);
        return sum;
    }
}
