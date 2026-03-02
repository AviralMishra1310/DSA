public class LC233 {
    public int countDigitOne(int n) {
        long digPos = 1;  
        int cnt = 0;

        while (digPos <= n) {
            
            long left = n / (digPos * 10);
            long curr = (n / digPos) % 10;
            long right = n % digPos;

            if (curr == 0) {
                cnt += left * digPos;
            } 
            else if (curr == 1) {
                cnt += left * digPos + right + 1;
            } 
            else {
                cnt += (left + 1) * digPos;
            }

            digPos *= 10;
        }

        return cnt;
    }
}   

