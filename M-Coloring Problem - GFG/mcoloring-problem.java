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
    int[] colorofNode;
    Map<Integer,List<Integer>> map = new HashMap<>();
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        for( int i = 0;i<graph.length;i++ ){
            for(int j = 0;j<graph[0].length;j++){
                // System.out.println( i + " " + j + " " + graph[i][j] );
                if( graph[i][j] ){
                    List<Integer> temp = map.getOrDefault(i,new ArrayList<>());
                    temp.add( j );
                    
                    map.put(i , temp);
                }
            }
        }
        
        colorofNode = new int[n+1];
        
        for( int i = 0;i<=n;i++ ) colorofNode[i] = -1;
        
        return helper( 0 , n ,m);
        // return false;
        
    }
    
    public boolean helper( int node , int n ,int m){
        if(node == n ) return true;
        
        for( int j = 1;j<=m;j++ ){
            
            if( possible(node , j,n) ){
                colorofNode[node] = j;
                if( helper( node+1 , n ,m ) ) return true;
                colorofNode[node] = -1;
            }
            
        }
        
        return false;
    }
    
    public boolean possible(int node , int color,int n){
        
        List<Integer> adjacent = map.get(node);
        
        if(adjacent == null) return true;
     
        for( int val : adjacent ){
            // System.out.println(val);
            if( colorofNode[val] == color ) return false;
        }
        
        return true;
    }
}