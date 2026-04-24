public class LC2833 {
    public int furthestDistanceFromOrigin(String s) {
        int n = s.length(), left = 0, right = 0, blank = 0;;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == 'L'){
                left++;
            }else if(ch == 'R'){
                right++;
            }else{
                blank++;
            }
        }
        return Math.abs(right - left) + blank;
    }
}
