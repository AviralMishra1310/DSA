public class LC76 {
    public String minWindow(String s, String t) {
        int[] hash = new int[128];

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int m = t.length();

        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) cnt++;
            hash[s.charAt(r)]--;
            r++;

            while (cnt == m) {
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) cnt--;
                l++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
