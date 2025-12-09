//LC 1092
import java.util.*;

public class ShortestCommonSuperseq {

    public static String shortestSuperseq(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // build LCS table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // build shortest supersequence
        int i = m, j = n;
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                result.append(s2.charAt(j - 1));
                j--;
            } else {
                result.append(s1.charAt(i - 1));
                i--;
            }
        }

        while (i > 0) {
            result.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.append(s2.charAt(j - 1));
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        String ans = shortestSuperseq(s1, s2);

        System.out.println("Shortest Common Supersequence: " + ans);
    }
}
