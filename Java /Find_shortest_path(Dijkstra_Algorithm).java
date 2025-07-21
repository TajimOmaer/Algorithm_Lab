import java.util.*;
import java.lang.*;
import java.io.*;

class Shortest_Path{
    static final int V = 5;

    int min_distance(int dist[], Boolean spt_set[]){
        int min_cost = Integer.MAX_VALUE, min_index = -1;
        for(int v=0; v<V; v++){
            if(!spt_set[v] && dist[v] <= min_cost){
                min_cost = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void Print_Min_Cost(int dist[], int parent[], int src){
        System.out.println("Vertix \t Cost \t Path");
        for(int i=0; i<V; i++){
            System.out.print(i + " \t\t " + dist[i] + " \t\t ");
            printPath(parent, i);
             System.out.println();
        }
    }

    void printPath(int parent[], int j){
        if(parent[j] == -1){
            System.out.print(j);
            return;
        }
        printPath(parent, parent[j]);
        System.out.print(","+j);
    }

    void Dijkstra(int graph[][], int vertexCost[], int src){
        int dist[] = new int[V];           
        Boolean spt_set[] = new Boolean[V];
        int parent[] = new int[V];         

        for(int i=0; i<V; i++){
            dist[i] = Integer.MAX_VALUE;
            spt_set[i] = false;
            parent[i] = -1;
        }
        dist[src] = vertexCost[src];

        for(int count=0; count<V-1; count++){
            int u = min_distance(dist, spt_set);
            spt_set[u] = true;

            for(int v=0; v<V; v++){
                if(!spt_set[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] + vertexCost[v] < dist[v]){

                    dist[v] = dist[u] + graph[u][v] + vertexCost[v];
                    parent[v] = u; 
                }
            }
        }
        Print_Min_Cost(dist, parent, src);
    }

    public static void main(String[] args){
        int graph[][] = {{0, 8, 5, 0, 0},
                         {0, 0, 2, 1, 0},
                         {0, 3, 0, 9, 2},
                         {0, 0, 0, 0, 4},
                         {7, 0, 0, 6, 0}};
        int vertexCost[] = {1, 2, 3, 4, 5};
        Shortest_Path sp = new Shortest_Path();
        sp.Dijkstra(graph, vertexCost, 0);
    }
}

/*
Vertix 	 Cost 	 Path
0 		 1 		 0
1 		 11 		 0,1
2 		 9 		 0,2
3 		 16 		 0,1,3
4 		 16 		 0,2,4

=== Code Execution Successful ===
*/
