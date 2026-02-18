import java.util.*;

public class LC1791 {
    public static int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || 
           edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return edges[0][1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of edges: ");
        int n = sc.nextInt();

        int[][] edges = new int[n][2];

        System.out.println("Enter edges (u v):");
        for(int i = 0; i < n; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        int center = findCenter(edges);
        System.out.println("Center node is: " + center);

        sc.close();
    }
}
