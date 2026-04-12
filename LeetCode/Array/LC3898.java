public class LC3898{
    public int[] findDegrees(int[][] matrix) {
        int ans[] = new int[matrix.length];
        int idx = 0;
        for(int[] row : matrix) {
            int c = 0;
            for(int col : row) {
                c += (col == 1) ? 1 : 0;
            }
            ans[idx++] = c;
        }
        return ans;
    }
}