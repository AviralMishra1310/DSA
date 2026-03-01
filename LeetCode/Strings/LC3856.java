public class LC3856 {
    public String trimTrailingVowels(String s) {
        int i = s.length() - 1;
        while(i >= 0 && isVow(s.charAt(i))){
            i--;
        }

        return s.substring(0, i+1);
    }

    boolean isVow(char c){
        return c=='a' || c=='e' || c=='o' || c=='i' || c=='u';
    }
}

