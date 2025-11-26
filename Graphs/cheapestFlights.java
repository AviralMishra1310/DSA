import java.util.*;

public class cheapestFlights {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info{
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }
    public static int CheapestFlights(int n, int flights[][], int src, int dest, int k){
        @SuppressWarnings ("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k){
                continue;
            }

            //neighbours ke liye add kar do 
            for(int i = 0; i < graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;
                int newCost = curr.cost + wt;

                // relaxation wala step
                if(newCost < dist[v] && curr.stops <= k) {
                    dist[v] = newCost;
                    q.add(new Info(v, newCost , curr.stops + 1));
                }
            }
        }
        //dist[dest]
        return (dist[dest] == Integer.MAX_VALUE) ? -1 : dist[dest];
    }

    public static void main(String args[]){
        int n = 4;
        int flights[][] = {{0, 1, 100},{1,2,100},{2,0,100},{1,3,600}, {2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(CheapestFlights(n, flights, src, dst, k));
    }
}
