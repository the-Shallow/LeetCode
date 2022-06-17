// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    // class Pair {
    //      int start;
    //      int 
    // }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int res = 0;
        int[] dist = new int[V];
        Set<Integer> visited = new HashSet<>();
        for( int i = 0;i < V;i++ ){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[0] = 0;
        
        for( int i = 0 ; i<adj.size()-1;i++ ){
            int u = getNextIndex( dist , visited );
            
            visited.add(u);
            // System.out.println(u);
            // System.out.println( adj.get(u) );
            for( int j = 0;j<adj.get(u).size();j++ ){
                int end = adj.get(u).get(j).get(0);
                int distance = adj.get(u).get(j).get(1);
                // System.out.println(end);
                if( !visited.contains( end ) && dist[u] != Integer.MAX_VALUE && 
                    distance != 0 &&
                     distance < dist[end] ){
                        dist[end] =  distance ;
                    }
            }
            
            // for( int num : dist ) System.out.print(num + " " );
            // System.out.println("----------");
        }
        
        
        for( int num : dist ) res+=num;
        
        return res;
    }
    
    static int getNextIndex( int[] dist , Set<Integer> set ){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        
        for( int i = 0;i<dist.length;i++ ){
            if( !set.contains(i) && dist[i] < min ){
                min = dist[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
}
