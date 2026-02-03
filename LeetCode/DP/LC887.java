import java.util.Scanner;

public class LC887 {

    public static int superEggDrop(int k, int n) {
        int[] dp = new int[k + 1];
        int moves = 0;

        while (dp[k] < n) {
            moves++;
            for (int e = k; e >= 1; e--) {
                dp[e] = dp[e] + dp[e - 1] + 1;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(); // eggs
        int n = sc.nextInt(); // floors

        System.out.println(superEggDrop(k, n));
    }
}
