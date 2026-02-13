import java.util.*;

public class LC135 {

    public static int candy(int[] nums) {
        int n = nums.length, total = 0;
        int arr[] = new int[n];

        Arrays.fill(arr, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        for (int x : arr) {
            total += x;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(candy(nums));

        sc.close();
    }
}
