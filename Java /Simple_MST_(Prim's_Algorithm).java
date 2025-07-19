public class MST {
    private static final int V = 5;

    int minkey(int key[], Boolean mst_set[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (!mst_set[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printMST(int parent[], int graph[][]) {
        int Total_cost = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            Total_cost += graph[i][parent[i]];
        }
        System.out.println("Total cost of MST : "+ Total_cost);
    }

    void prim_MST(int graph[][]) {
        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean mst_set[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mst_set[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minkey(key, mst_set);
            mst_set[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mst_set[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        MST t = new MST();
        int graph[][] = new int[][]{
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        t.prim_MST(graph);
    }
}


/*
Edge 	Weight
0 - 1	2
1 - 2	3
0 - 3	6
1 - 4	5
Total cost of MST : 16

=== Code Execution Successful ===
*/
