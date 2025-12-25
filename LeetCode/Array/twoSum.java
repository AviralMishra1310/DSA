// lc -> 1
import java.util.*;

public class twoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();          
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();   

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int remaining = target - nums[i];
            if (numMap.containsKey(remaining)) {
                System.out.println(numMap.get(remaining) + " " + i);
                return;
            }
            numMap.put(nums[i], i);
        }
    }
}
