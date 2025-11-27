import java.util.*;

public class cycleDetectUndir{
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int V){
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr, int parent){
        vis[curr] = true;

        for(int neigh : graph.get(curr)){
            if(!vis[neigh]){
                if(dfs(graph, vis, neigh, curr)) return true;
            }else if(neigh != parent){
                return true;
            }
        }
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
            graph.get(v).add(u);
        }

        if(hasCycle(graph, V)){
            System.out.println("Cycle detected");
        }else{
            System.out.println("No Cycle");
        }

        sc.close();
    }
}

