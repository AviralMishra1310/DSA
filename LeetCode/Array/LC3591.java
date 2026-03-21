public class LC3591 {
    public boolean isPrime(int n){
        if(n <= 1) return false;
        
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];

        for(int i = 0; i < n; i++){
            freq[nums[i]]++;
        }

        for(int i = 0; i < freq.length; i++){
            if(isPrime(freq[i])){
                return true;
            }
        }
        return false;
    }
}
