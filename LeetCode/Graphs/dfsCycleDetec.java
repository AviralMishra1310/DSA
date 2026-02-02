import java.util.*;

public class dfsCycleDetec {

    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                if (dfs(nbr, node, visited, graph))
                    return true;
            } 
            else if (nbr != parent) {
                return true; // cycle found
            }
        }
        return false;
    }

    static boolean hasCycle(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, graph))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // nodes
        int e = sc.nextInt(); // edges

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        System.out.println(hasCycle(n, graph) ? "Cycle exists" : "No cycle");
        sc.close();
    }
}
