import java.util.Scanner;

public class AdjacencyMatrix {
    static int[][] matrix;

    public static void main(String[] args) {
        int e = 7, n = 5; 
        // e = number of edges, n = number of vertices

        matrix = new int[n][n]; // use n instead of 20

        Inmatrix(e);
        System.out.println("Output:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void Inmatrix(int e) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter The Edges (like A B):");

        for (int i = 0; i < e; i++) {
            char j = sn.next().charAt(0);
            char k = sn.next().charAt(0);
            matrix[(int) j - 65][(int) k - 65] = 1;
            matrix[(int) k - 65][(int) j - 65] = 1;
            // undirected graph, so both ways
        }
    }
}


/* The OUt PUT is : 
Enter The Edges (like A B):
A B
A C
A D
A E
B C
C D
C E
Output:
0 1 1 1 1 
1 0 1 0 0 
1 1 0 1 1 
1 0 1 0 0 
1 0 1 0 0 

=== Code Execution Successful ===
*/
