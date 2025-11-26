import java.util.*;

public class topologiSort {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){ // ye no cycle wala graph hai isme FALSE dega
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(3,2));
    }

    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i < graph.length; i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis, s); //modified dfs
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop()+ " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //graph[curr] ka matlab hai: curr node se jo outgoing edges hain unko nikalo.
            // Har edge e me e.src = curr aur e.dest ek neighbour hai.

            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }

            // Agar neighbour (e.dest) abhi tak visited nahi hai, to DFS ko neighbour par bhej do.
            // Matlab pehle us neighbour ke sab dependencies explore ho jaayein.
        }
        s.push(curr);
    }

    public static void main(String args[]){
        int V = 6;

        @SuppressWarnings ("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph);
    }
}

//neopat style
// import java.util.*;

// public class TopologicalSort {
//     static class Edge {
//         int src, dest;
//         Edge(int s, int d) {
//             src = s;
//             dest = d;
//         }
//     }

//     // Graph creation from input
//     static void createGraph(List<Edge>[] graph, int[][] edges) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         for (int[] e : edges) {
//             graph[e[0]].add(new Edge(e[0], e[1])); // u -> v
//         }
//     }

//     // Topological Sort using DFS
//     static void topSort(List<Edge>[] graph) {
//         boolean[] visited = new boolean[graph.length];
//         Stack<Integer> stack = new Stack<>();

//         for (int i = 0; i < graph.length; i++) {
//             if (!visited[i]) {
//                 dfs(graph, i, visited, stack);
//             }
//         }

//         // print result
//         while (!stack.isEmpty()) {
//             System.out.print(stack.pop() + " ");
//         }
//     }

//     static void dfs(List<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
//         visited[curr] = true;

//         for (Edge e : graph[curr]) {
//             if (!visited[e.dest]) {
//                 dfs(graph, e.dest, visited, stack);
//             }
//         }

//         stack.push(curr);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int V = sc.nextInt(); // vertices
//         int E = sc.nextInt(); // edges

//         int[][] edges = new int[E][2];
//         for (int i = 0; i < E; i++) {
//             edges[i][0] = sc.nextInt(); // u
//             edges[i][1] = sc.nextInt(); // v
//         }

//         @SuppressWarnings("unchecked")
//         List<Edge>[] graph = new ArrayList[V];
//         createGraph(graph, edges);

//         topSort(graph);
//     }
// }
