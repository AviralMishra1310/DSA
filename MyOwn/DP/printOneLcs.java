import java.util.*;

class printOneLcs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Backtrack to get ONE LCS
        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else {

                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                }
                else {
                    i--;
                }
            }
        }

        lcs.reverse();

        System.out.println("One LCS = " + lcs.toString());

        sc.close();
    }
}
