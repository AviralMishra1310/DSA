public class LC1021 {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                if(open > 1) sb.append(ch);
            }else{
                open--;
                if(open > 0) sb.append(ch);
            }
        }
        return sb.toString();
    }
}

