import java.util.*;

public class LC525 {
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, max = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) sum--;
            else sum++;

            if(map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(findMaxLength(nums));
    }
}