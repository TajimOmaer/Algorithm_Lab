import java.util.*;

public class BFS {

    static char[] c = {'A','B','C','D','E','F','G','S'};
    static int e[] = {2,2,2,2,2,2,3,3};
    static int list[][] = {{3,7},{4,7},{5,7},{0,6},{1,6},{2,6},{3,4,5},{0,1,2}}; 
                                      // adjacency list

    static int[] checked = new int[20];
    static int[] queue = new int[20];
    static int first = 0, last = 0;

    public static void main(String[] args) {
        int n;
        enqueue(7); // start from node 'S'
        while (first < last) {
            n = dequeue();
            for (int i = 0; i < e[n]; i++) {
                if (notChecked(list[n][i]) == 1)
                    enq(list[n][i]);
            }
        }
    }

    static int notChecked(int n) { // check if node is visited
        if (checked[n] == 1)
            return 0;
        return 1;
    }

    static void enqueue(int n) { // enqueue
        checked[n] = 1;
        queue[last] = n;
        last++;
    }

    static int dequeue() { // dequeue
        System.out.print(c[queue[first]] + " ");
        first++;
        return queue[first - 1];
    }
}


/* The OUTPUT is : 
S A B C D E F G 
=== Code Execution Successful ===
*/
