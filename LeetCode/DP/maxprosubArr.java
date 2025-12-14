import java.util.*;

public class maxproSubArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int preFix = 1, suffix = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (preFix == 0) preFix = 1;
            if (suffix == 0) suffix = 1;

            preFix *= nums[i];
            suffix *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(preFix, suffix));
        }

        System.out.println(ans);
    }
}
