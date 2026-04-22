import java.util.*;
class LC3668 {
    public int[] recoverOrder(int[] order, int[] friends) {
        int m = friends.length;
        int[] ans = new int[m];
        HashSet<Integer> set = new HashSet<>();
        for(int f : friends) set.add(f);
        int k = 0;
        for(int x : order){
            if(set.contains(x)){
                ans[k++] = x;
            }
        }
        return ans;
    }
}