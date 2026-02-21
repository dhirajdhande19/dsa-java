import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static  class  Edge {
        int str;
        int des;

        public Edge(int s, int d) {
            this.str = s;
            this.des = d;
        }

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // O(V+E) : V = vertices + E: edges
    public static boolean isBipartitie(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(col, -1);
        for(int i = 0; i < graph.length; i++) {
            if(col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(col[e.des] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.des] = nextCol;
                            q.add(e.des);
                        } else if(col[e.des] == col[curr]) return  false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        /*
            if graph doesn't have cycle (Acylic) || 
            if graph have even cycle || its bipartite by default!
            if grpah have odd cycle -> non-bipartite
            
                0------2
               /      /
              /      /
             1      4
              \    /
               \  /
                3
            Output: FALSE
        */
       int V = 5;
       @SuppressWarnings("unchecked")
       ArrayList<Edge> graph[] = new ArrayList[V];
       createGraph(graph);
       System.out.println("is bipartite: " + isBipartitie(graph));
    }
}
