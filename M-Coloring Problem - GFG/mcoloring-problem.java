// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    int[] colorOfNode;
    Map<Integer,List<Integer>> map = new HashMap<>();
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        colorOfNode = new int[n];
        
        for( int i = 0;i<graph.length;i++ ){
            List<Integer> temp = new ArrayList<>();
            for( int j = 0;j<graph[0].length;j++ ){
                if( graph[i][j] ){
                    temp.add( j );
                }
            }
            
            map.put(i,temp);
        }
        
        return helper(0,n,m);
        
    }
    
    public boolean helper( int node , int n , int m ){
        if( node == n ) return true;
        
        for( int i = 1;i<=m;i++ ){
            if( isPossible( node , i ) ){
                colorOfNode[node] = i;
                if( helper(node+1,n,m) ) return true;
                colorOfNode[node] = 0;
            }
        }
        
        return false;
    }
    
    public boolean isPossible(int node , int color){
        List<Integer> temp = map.get(node);
        if( temp == null ) return true;
        
        for( int val : temp ){
            if( colorOfNode[val] == color ) return false;
        }
        
        return true;
    }
}