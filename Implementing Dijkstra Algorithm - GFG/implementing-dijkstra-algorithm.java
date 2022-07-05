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
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    
    static class Pair {
        int end;
        int distance;
        
        public Pair(int end , int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
    
    static int minIndex(int[] arr ,int[] visited ){
        int min = Integer.MAX_VALUE,min_index = -1;
        
        for(int i = 0;i<arr.length;i++){
            if( visited[i] == -1 &&  arr[i] < min ){
                min = arr[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        
        Map<Integer,List<Pair>> map = new HashMap<>();
        
        for( int i = 0;i<adj.size();i++ ){
            List<Pair> temp = new ArrayList<>();
            for( int j = 0;j<adj.get(i).size();j++ ){
                int end = adj.get(i).get(j).get(0);
                int distance = adj.get(i).get(j).get(1);
                
                Pair pair = new Pair( end ,distance );
                temp.add(pair);
            }
            
            map.put( i , temp );
        }
        
        int[] visited = new int[V];
        
        int[] res = new int[V];
        
        for( int i = 0;i<V;i++ ){
            visited[i] = -1;
            res[i] = Integer.MAX_VALUE;
        }
        
        res[S] = 0;
        
        for( int i = 0;i<V;i++ ){
            
            int node = minIndex(res,visited);
            
            visited[node] = 1;
            
            for( Pair neighbor : map.get(node) ){
                if( visited[neighbor.end] == -1 && neighbor.distance != 0 
                && res[node] + neighbor.distance < res[neighbor.end]  ){
                    res[neighbor.end] = res[node] + neighbor.distance;
                }
            }
        }
        
        return res;
    }
}

