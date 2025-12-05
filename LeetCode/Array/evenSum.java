import java.util.*;

public class evenSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        int total = 0;
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            total += nums[i];
        }

        int left = 0, ans = 0;
        for(int i = 0; i < n-1; i++){
            left += nums[i];
            int right = total - left;
            if((right - left) % 2 == 0) ans++;
        }

        System.out.println(ans);
    }
}

