import java.util.*;

public class LC283 {

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;

        while (i < n && j < n) {

            if (nums[i] == 0 && nums[j] == 0) {
                j++;

            } else if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;

            } else {
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        moveZeroes(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}
