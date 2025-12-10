import java.util.*;

public class LongestIncSubSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 0;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        System.out.println("Length of LIS = " + maxi);
    }
}
