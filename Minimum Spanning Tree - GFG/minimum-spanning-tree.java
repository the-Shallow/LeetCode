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
    static class Node {
        int start;
        int end;
        int distance;
        
        public Node(int start , int end , int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
    
    static class Disjoint {
        int rank;
        int parent;
        
        public Disjoint(){};
        
        public Disjoint(int rank , int parent){
            this.rank = rank;
            this.parent = parent;
        }
    }
    
    static int find( Disjoint[] disjoint , int node ){
        if( disjoint[node].parent != node ){
            return find( disjoint , disjoint[node].parent );
        }
        
        return disjoint[node].parent;
    }
    
    static void union(Disjoint[] disjoint , int start , int end ){
        int startRoot = find(disjoint,start);
        int endRoot = find(disjoint,end);
        
        if( disjoint[startRoot].rank < disjoint[endRoot].rank ){
            disjoint[startRoot].parent = endRoot;
        }else if( disjoint[startRoot].rank > disjoint[endRoot].rank ){
            disjoint[endRoot].parent = startRoot; 
        }else {
            disjoint[endRoot].parent = startRoot;
            disjoint[startRoot].rank++;
        }
    }
    
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int res = 0;
        List<Node> nodes = new ArrayList<>();
        
        for( int i = 0;i<adj.size();i++ ){
            for(int j = 0;j < adj.get(i).size();j++ ){
                int start = i;
                int end = adj.get(i).get(j).get(0);
                int distance = adj.get(i).get(j).get(1);
                
                Node node = new Node(start,end,distance);
               
                nodes.add(node);
            }
        }
        
        
        Collections.sort(nodes , (a,b) -> a.distance - b.distance );
        Disjoint[] disjoint = new Disjoint[V];
        
        for(int i = 0;i<V;i++){
            disjoint[i] = new Disjoint();
            disjoint[i].rank = 0;
            disjoint[i].parent = i;
        }
        
        for( int i = 0;i<nodes.size();i++ ){
            Node curr = nodes.get(i);
            // System.out.println(curr.distance);
            int start = curr.start;
            int end = curr.end;
            
            
            int startRoot = find(disjoint,start);
            int endRoot = find(disjoint,end);
            
            if(startRoot != endRoot){
                res += curr.distance;
                union( disjoint  , startRoot, endRoot );
            }
        }
        
        return res;
    }
}
