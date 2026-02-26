public class LC343 {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;

        int p = 1;

        while(n > 4){
            p = p * 3;
            n = n - 3;
        }

        return p * n;
    }
}