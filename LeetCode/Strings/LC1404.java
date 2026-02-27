public class LC1404 {
    public int numSteps(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() != 1){
            if(sb.charAt(sb.length()-1) == '0'){ //last 0 to even wrna odd
                sb.deleteCharAt(sb.length()-1);
            }else{
                int i;
                for(i = sb.length()-1; i >= 0; i--){
                    if(sb.charAt(i) == '0'){
                        sb.setCharAt(i,'1');
                        break;
                    }else{
                        sb.setCharAt(i,'0');
                    }
                }
                if(i < 0){
                    sb.insert(0,'1');
                }
            }
            cnt++;
        }
        return cnt;
    }
}

