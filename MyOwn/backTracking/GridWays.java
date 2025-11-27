public class GridWays {
       public static int gridWays(int i, int j, int n, int m){
        //base case
        if(i == n-1 && j == m-1){ //condn for last cell
            return 1;
        }else if(i == n || j ==n){
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(gridWays(0, 0, n, m)); 
    }
   
}

//  public static int countWays(int rows, int cols) {
//         int totalMoves = rows + cols - 2;      // Total moves from (0,0) to (n-1,m-1)
//         int downMoves = rows - 1;              // You need to go down (n - 1) times

//         return (int) computeCombination(totalMoves, downMoves);
//     }

//     // This function calculates nCr = n! / (r! * (n - r)!)
//     public static long computeCombination(int total, int choose) {
//         long result = 1;

//         // Use smaller of r and (n - r) to optimize
//         if (choose > total - choose) {
//             choose = total - choose;
//         }

//         // Iteratively calculate the result to avoid large factorials
//         for (int i = 0; i < choose; i++) {
//             result = result * (total - i);
//             result = result / (i + 1);
//         }

//         return result;
//     }

//     public static void main(String[] args) {
//         int rows = 3;
//         int cols = 3;
//         System.out.println("Total ways = " + countWays(rows, cols));  // Output: 6
//     }