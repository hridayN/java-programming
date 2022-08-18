package DynamicProgramming.Memoization;

public class MemoizedProblems {
    static int n = 4;
    static int memo[] = new int[n + 1];
    public static void main(String[] args) {
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        System.out.println("total steps to 1: " + getMinStepsByMemoization(4));
    }

    public static int getMinStepsByMemoization(int n) {
        if (n == 1) return 0;

        // check if we already have n
        if (memo[n] != -1) return memo[n];

        int r = 1 + getMinStepsByMemoization(n - 1);

        if (n % 2 == 0) r = Math.min(r, 1 + getMinStepsByMemoization(n / 2));
        if (n % 3 == 0) r = Math.min(r, 1 + getMinStepsByMemoization(n / 3));

        memo[n] = r;
        return r;
    }

    public static int getMinStepsByBottomUp() {
        return -1;
    }
}
