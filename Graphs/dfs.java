import java.util.*;

public class dfs {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Function to create graph
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void Dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]){
        //visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                Dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String args[]) {
        int V = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        Dfs(graph, 0, new boolean[V]); 
    }
}

// import java.util.*;

// public class Main {
//     static void dfsUtil(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {
//         visited[node] = true;
//         result.add(node);

//         for (int neighbor : adj.get(node)) {
//             if (!visited[neighbor]) {
//                 dfsUtil(neighbor, visited, adj, result);
//             }
//         }
//     }

//     static ArrayList<Integer> dfsTraversal(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean[] visited = new boolean[V];
//         ArrayList<Integer> result = new ArrayList<>();

//         // For disconnected graphs
//         for (int i = 0; i < V; i++) {
//             if (!visited[i]) {
//                 dfsUtil(i, visited, adj, result);
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int V = sc.nextInt();  // number of vertices
//         int E = sc.nextInt();  // number of edges

//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < V; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Reading edges
//         for (int i = 0; i < E; i++) {
//             int u = sc.nextInt();
//             int v = sc.nextInt();
//             adj.get(u).add(v);
//             adj.get(v).add(u);  // remove this line if graph is directed
//         }

//         ArrayList<Integer> result = dfsTraversal(V, adj);

//         for (int node : result) {
//             System.out.print(node + " ");
//         }
//     }
// }
