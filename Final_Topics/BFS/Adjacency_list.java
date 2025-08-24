import java.util.*;

public class BreadFS {

    static char[] c = {'A','B','C','D','E','F','G','S'};
    static int e[] = {2,2,2,2,2,2,3,3};
    static int list[][] = {{3,7},{4,7},{5,7},{0,6},{1,6},{2,6},{3,4,5},{0,1,2}}; 
                                      // adjacency list

    static int[] checked = new int[20];
    static int[] que = new int[20];
    static int first = 0, last = 0;

    public static void main(String[] args) {
        int n;
        enq(7); // start from node 'S'
        while (first < last) {
            n = dq();
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

    static void enq(int n) { // enqueue
        checked[n] = 1;
        que[last] = n;
        last++;
    }

    static int dq() { // dequeue
        System.out.print(c[que[first]] + " ");
        first++;
        return que[first - 1];
    }
}


/* The OUTPUT is : 
S A B C D E F G 
=== Code Execution Successful ===
*/
