import java.util.*;

class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class bfsCycleDetec {

    static boolean hasCycle(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];

        for (int start = 0; start < n; start++) {
            if (visited[start]) continue;

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(start, -1));
            visited[start] = true;

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                int node = cur.node;
                int parent = cur.parent;

                for (int nbr : graph.get(node)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.add(new Pair(nbr, node));
                    } else if (nbr != parent) {
                        return true; // cycle
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(hasCycle(n, graph) ? "Cycle exists" : "No cycle");
        sc.close();
    }
}
