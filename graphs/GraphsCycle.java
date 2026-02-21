import java.util.ArrayList;

public class GraphsCycle {
    static  class  Edge {
        int str;
        int des;

        public Edge(int s, int d) {
            this.str = s;
            this.des = d;
        }

    }

    // undirect graph
        /* 
                0--------3
               /|        |
              / |        |
             1  |        4
              \ |
               \|
                2
        */
    // static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 1));
    //     graph[0].add(new Edge(0, 2));
    //     graph[0].add(new Edge(0, 3));

    //     graph[1].add(new Edge(1, 0));
    //     graph[1].add(new Edge(1, 2));

    //     graph[2].add(new Edge(2, 0));
    //     graph[2].add(new Edge(2, 1));

    //     graph[3].add(new Edge(3, 0));
    //     graph[3].add(new Edge(3, 4));

    //     graph[4].add(new Edge(4, 3));
    // }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
               if(detectCycleUtil(graph, vis, i, -1)) return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // condition-1: when neighbour is unvisted and there exits cycle
            // condition-2: when neighbour is visited and parent is also des(negihbour); cycle exits 
            if(!vis[e.des]) {
                if(detectCycleUtil(graph, vis, e.des, curr)) return true;
            } else if(vis[e.des] && parent != e.des) return true;

        }
        return false;
    }


    // directed graph
    // graph-1 (cycle exist)
    // static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 2));

    //     graph[1].add(new Edge(1, 0));

    //     graph[2].add(new Edge(2, 3));

    //     graph[3].add(new Edge(3, 0));
    // }
    // graph-2 (cycle doesn't exist)
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) return true;
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.des]) return true;
            if(!vis[e.des] && isCycleUtil(graph, e.des, vis, stack)) return true;
        }
        stack[curr] = false;
        return false;
    }


    public static void main(String[] args) {

        int V = 5;
        @SuppressWarnings("unchecked") 
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph); 

        System.out.println("Cycle exist: " + isCycle(graph));
    }
}
