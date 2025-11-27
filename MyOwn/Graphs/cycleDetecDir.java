import java.util.*;

public class cycleDetecDir{
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int V){
        boolean[] vis = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(graph, vis, recStack, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, boolean[] recStack, int node){
        vis[node] = true;
        recStack[node] = true;

        for(int neigh : graph.get(node)){
            if(!vis[neigh]){
                if(dfs(graph, vis, recStack, neigh)) return true;
            }else if(recStack[neigh]){
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        if(hasCycle(graph, V)){
            System.out.println("Cycle detected");
        }else{
            System.out.println("No Cycle");
        }

        sc.close();
    }
}

