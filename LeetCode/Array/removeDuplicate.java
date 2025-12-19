import java.util.*;

public class removeDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[res] = nums[i];
                res++;
            }
        }

        System.out.println(res);
    }
}
