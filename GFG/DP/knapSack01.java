import java.util.*;

public class knapSack01 {

    public static int knapsack(int W, int val[], int wt[]) {

        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
                                        dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();

        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();

        System.out.print("Enter Knapsack Capacity W: ");
        int W = sc.nextInt();

        int ans = knapsack(W, val, wt); 

        System.out.println("Maximum value = " + ans);
    }
}
