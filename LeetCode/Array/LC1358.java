public class LC1358 {
    public int numberOfSubstrings(String s) {
       int n = s.length(), cnt = 0;
        int a = -1, b = -1, c = -1;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == 'a') a = i;
            else if(ch == 'b') b = i;
            else if(ch == 'c') c = i;

            int min = Math.min(a, Math.min(b, c));
            if(min != -1) cnt += min + 1;
        }
        return cnt;
    }
}
