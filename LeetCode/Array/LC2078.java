public class LC2078 {
    public int maxDistance(int[] col) {
        int n = col.length;
        int ans = 0;
        for(int j = n - 1; j >= 0; j--){
            if(col[j] != col[0]){
                ans = j;
                break;
            }
        }
        for(int i = 0; i < n; i++){
            if(col[i] != col[n - 1]){
                ans = Math.max(ans, n - 1 - i);
                break;
            }
        }
        return ans;
    }
}

