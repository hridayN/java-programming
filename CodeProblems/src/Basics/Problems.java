package Basics;

public class Problems {
    public static void main(String[] args) {
        int n = 64;
        /*loop1(n);
        loop2(n);
        loop4(n);*/
    }

    public static void loop1(int n) {
        int total = 0;
        for (int i = 0; i < n; i += 2) {
            total++;
        }
        System.out.println("loop1 total: " + total);
    }

    public static void loop2(int n) {
        int total = 0;
        for (int i = 1; i < n; i *= 2) {
            total++;
        }
        System.out.println("loop2 total: " + total);
    }

/*    public static void loop3(int n) {
        int total = 0;
        for (int i = 0; i < n; i *= 2) {
            total++;
        }
        System.out.println("loop3 total: " + total);
    }*/

    public static void loop4(int n) {
        int total = 0;
        for (int i = n; i > 0; i /= 2) {
            total++;
        }
        System.out.println("loop4 total: " + total);
    }
}
