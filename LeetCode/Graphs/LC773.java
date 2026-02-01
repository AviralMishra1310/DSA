import java.util.Scanner;

class LC733 {

    // DFS helper
    // TC: O(m * n)
    public static void helper(int[][] image, int sr, int sc, int color,
                              boolean[][] vis, int orgCol) {

        if (sr < 0 || sc < 0 ||
            sr >= image.length || sc >= image[0].length ||
            vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = color;

        // left
        helper(image, sr, sc - 1, color, vis, orgCol);
        // right
        helper(image, sr, sc + 1, color, vis, orgCol);
        // up
        helper(image, sr - 1, sc, color, vis, orgCol);
        // down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        int orgColor = image[sr][sc];
        helper(image, sr, sc, color, vis, orgColor);
        return image;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scn.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scn.nextInt();

        int[][] image = new int[rows][cols];

        System.out.println("Enter image matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = scn.nextInt();
            }
        }

        System.out.print("Enter start row (sr): ");
        int sr = scn.nextInt();

        System.out.print("Enter start column (sc): ");
        int sc = scn.nextInt();

        System.out.print("Enter new color: ");
        int color = scn.nextInt();

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Updated Image:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scn.close();
    }
}
