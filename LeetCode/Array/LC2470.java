public class LC2470 {
    static int gcd(int a, int b){
        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length, cnt = 0;

        for(int i = 0; i < n; i++){
            int cur = nums[i];
            for(int j = i; j < n; j++){
                cur = lcm(cur, nums[j]);
                if(cur == k) cnt++;
                if(cur > k) break; 
            }
        }
        return cnt;
    }
}



