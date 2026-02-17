import java.util.*;

public class LC442 {

    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findDuplicates(nums));
    }
}
