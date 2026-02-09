import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public  class GraphsTraversals {
        static  class  Edge {
        int str;
        int des;
        int wt;

        public Edge(int s, int d, int w) {
            this.str = s;
            this.des = d;
            this.wt = w;
        }

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    // bfs using adjencency list
    public static void bfs(ArrayList<Edge> graph[]) { // O(V+E) - time (Vertices+Edges)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // source = 0;

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) { // if not already visited
                System.out.print(curr+ " "); // print
                vis[curr] = true; // mark visited
                for(int i = 0; i < graph[curr].size(); i++) { // add neighbours of that curr node(vertices)
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }
    // dfs using adjencency list
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean  vis[]) { // O(V+E) - time (Vertices+Edges)
        // vis
        System.out.print(curr+ " ");
        vis[curr] =  true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.des]) {
                dfs(graph, e.des, vis);
            }
        }
    }

    public static void main(String[] args) {
        /* 
            Graph Structure:

                1-------3
               /        | \
              /         |  \
             0          |   5-----6
              \         |  /
               \        | /  
                2-------4
        */
       int V = 7;
       @SuppressWarnings("unchecked") 
       ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[V];
       createGraph(graph);

        System.out.print("BFS: ");
        bfs(graph);
        System.out.println();
        System.out.print("DFS: ");
        dfs(graph, 0, new boolean[V]);
    }
}