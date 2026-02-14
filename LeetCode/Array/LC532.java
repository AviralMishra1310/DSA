import java.util.*;

public class LC532 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        int result = findPairs(nums, k);
        System.out.println("Number of unique k-diff pairs: " + result);
    }

    public static int findPairs(int[] nums, int k) {

        if (k < 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) > 1) count++;
            } else {
                if (map.containsKey(num + k)) count++;
            }
        }

        return count;
    }
}
