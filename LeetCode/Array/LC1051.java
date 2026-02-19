import java.util.*;

public class LC1051 {

    public static int heightChecker(int[] arr){
        int n = arr.length, cnt = 0;
        int[] nums = arr.clone();
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(arr[i] != nums[i]){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(heightChecker(arr));
    }
}
