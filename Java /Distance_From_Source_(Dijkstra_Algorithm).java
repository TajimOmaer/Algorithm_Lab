import java.util.*;
import java.lang.*;
import java.io.*;

class Shortest_Path{
    static final int V = 5;
    int min_distance(int dist[], Boolean spt_set[]){
        int min_cost = Integer.MAX_VALUE, min_index = -1;
        
        for(int v = 0; v < V; v++){
            if(spt_set[v] == false && dist[v] <= min_cost){
                min_cost = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    void Print_Solution(int dist[]){
        System.out.println("Vertex \t\t Distance From Source");
        for (int i = 0; i< V; i++){
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
    void Dijkstra(int graph[][], int src){
        int dist[] = new int[V];
        Boolean spt_set[] = new Boolean[V];
        
        for(int i=0; i<V; i++){
            dist[i] = Integer.MAX_VALUE;
            spt_set[i] = false;
        }
        dist[src] = 0;
            for(int count=0; count<V-1; count++){
                int u = min_distance(dist, spt_set);
                spt_set[u] = true;
                
                for(int v=0; v<V; v++)
                    if(!spt_set[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                        dist[v] = dist[u] + graph[u][v];
            }
            Print_Solution(dist);
    }
    public static void main(String[] args){
        int graph[][] = {{0, 8, 5, 0, 0},
                         {0, 0, 2, 1, 0},
                         {0, 3, 0, 9, 2},
                         {0, 0, 0, 0, 4},
                         {7, 0, 0, 6, 0}};
        Shortest_Path t = new Shortest_Path();
        t.Dijkstra(graph, 0);
    }
}


// Simple OUT PUT
/*
Vertex 		 Distance From Source
0 		 0
1 		 8
2 		 5
3 		 9
4 		 7

=== Code Execution Successful ===
*/
