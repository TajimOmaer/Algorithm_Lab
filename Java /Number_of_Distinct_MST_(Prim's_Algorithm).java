import java.util.*;
import java.lang.*;
import java.io.*;

class MST {
    private static final int V = 5;

    int minKey(int key[], Boolean mst_Set[], int[] Min_count) {
        int min_cost = Integer.MAX_VALUE, min_index = -1;
        Min_count[0] = 0;

        for (int v = 0; v < V; v++) {
            if (!mst_Set[v] && key[v] < min_cost) {
                min_cost = key[v];
                min_index = v;
                Min_count[0] = 1;
            } else if (!mst_Set[v] && key[v] == min_cost) {
                Min_count[0]++;
            }
        }

        return min_index;
    }

    void print_MST(int parent[], int graph[][]) {
        int total_Weight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            total_Weight += graph[i][parent[i]];
        }
        System.out.println("Total weight of MST (shortest path value): " + total_Weight);
    }

    void prims_MST(int graph[][]) {
        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean mst_Set[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mst_Set[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        long total_MSTs = 1;
        int[] Min_count = new int[1]; 

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mst_Set, Min_count);
            total_MSTs *= Min_count[0]; 
            mst_Set[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mst_Set[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        
        print_MST(parent, graph);
        System.out.println("Number of possible distinct MSTs (due to tie weights): " + total_MSTs);
    }
    
    public static void main(String[] args) {
        MST t = new MST();
        int graph[][] = new int[][] {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        t.prims_MST(graph);
    }
}
