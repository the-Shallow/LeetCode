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
    
    static class Pair {
        int end;
        int distance;
        
        public Pair(int end , int distance){
            this.end = end;
            this.distance = distance;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        Map<Integer,List<Pair>> map = getMatrix( adj );
        // System.out.println(adj.size() );
        int[] dist = new int[V];
        Set<Integer> visited = new HashSet<>();
        
        for( int i = 0;i<V;i++ ){
            dist[i] = Integer.MAX_VALUE;
        }
        
        
        dist[S] = 0;
        
        for( int i = 0;i<V-1;i++ ){
            
            int u = getNextIndex( dist,visited );
            
            visited.add(u);
            
            List<Pair> temp = map.get( u );
            
            for( Pair pair : temp ){
                if( !visited.contains(pair.end) && pair.distance != 0 &&
                    dist[u] + pair.distance < dist[pair.end] ){
                        dist[pair.end] = dist[u] + pair.distance;
                    }
            }
        }
        
        return dist;
    }
    
    static int getNextIndex( int[] dist , Set<Integer> set ){
        int min_index = -1,min = Integer.MAX_VALUE;
        
        for( int i = 0;i<dist.length;i++ ){
            if( !set.contains(i) && dist[i] < min ){
                min = dist[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
    
    static Map<Integer,List<Pair>> getMatrix( ArrayList<ArrayList<ArrayList<Integer>>> adj){
        
        Map<Integer,List<Pair>> map = new HashMap<>();
        
        for( int i = 0;i<adj.size();i++ ){
            List<Pair> temp = new ArrayList<>();
            for( int j = 0;j<adj.get(i).size();j++ ){
                Pair pair = new Pair( adj.get(i).get(j).get(0) , adj.get(i).get(j).get(1) );
                temp.add(pair);
            }
            
            map.put(i , temp);
        }
        
        return map;
    }
}

