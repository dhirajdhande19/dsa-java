import java.util.ArrayList;

public class GraphsImplementation {
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
    public static void main(String[] args) {
        /*
        Creating a Graph (Adjacency List)
        Example Graph Representation:  Bi-direction or un-directed Graph (Weighted)

                   (5) 
                0-------1
                       / \
                  (1) /   \ (3)
                     /     \
                    2-------3
                    |  (1)
                    |
                (2) |
                    |
                    4
        */
       int V = 5; // number of vertices
       @SuppressWarnings("unchecked") 
       ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];
       // to convet null list to empty list
       for(int i = 0; i < V; i++) {
        graph[i] = new ArrayList<>();
       }

       // 0 vertex
       graph[0].add(new Edge(0, 1, 5));
       // 1 vertex
       graph[1].add(new Edge(1, 0, 5));
       graph[1].add(new Edge(1, 2, 1));
       graph[1].add(new Edge(1, 3, 3));
       // 2 vertex
       graph[2].add(new Edge(2, 1, 1));
       graph[2].add(new Edge(2, 3, 1));
       graph[2].add(new Edge(2, 4, 2));
       // 3 vertex
       graph[3].add(new Edge(3, 1, 3));
       graph[3].add(new Edge(3, 2, 1));
       // 4 vertex
       graph[4].add(new Edge(4, 2, 2));


       // to get 2's neigbhours
       for(int i = 0; i < graph[1].size(); i++) {
        Edge e = graph[1].get(i);
        System.out.println(e.des);
       }
    }
}