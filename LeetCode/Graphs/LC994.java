import java.util.*;

class LC994 {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        // count fresh & add rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // BFS (each level = 1 minute)
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();

                for (int[] d : dir) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];

                    if (r >= 0 && c >= 0 && r < m && c < n
                            && grid[r][c] == 1) {

                        grid[r][c] = 2;   // make rotten
                        fresh--;
                        q.add(new int[]{r, c});
                    }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    // MAIN → easiest user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter grid (0 empty, 1 fresh, 2 rotten):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Minimum minutes = " + orangesRotting(grid));
        sc.close();
    }
}
