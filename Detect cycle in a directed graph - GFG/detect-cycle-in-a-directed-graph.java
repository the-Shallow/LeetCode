// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    Set<Integer> visited = new HashSet<>();
    Set<Integer> dfsVisited = new HashSet<>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0;i<adj.size();i++){
            List<Integer> temp = new ArrayList<>();
            for( int j = 0;j<adj.get(i).size();j++ ){
                temp.add( adj.get(i).get(j) );
            }
            
            map.put(i,temp);
        }
        
        // Start visiting each node
        for( int i = 0;i<V;i++ ){
            if( !visited.contains(i) ){
                if( checkCycle(i) ) return true;
            }
        }
        
        return false;
    }
    
    public boolean checkCycle( int node ){
        visited.add( node );
        dfsVisited.add(node);
        
        List<Integer> neighbors = map.get(node);
        
        for( int neighbor : neighbors ){
            if( !visited.contains(neighbor) ){
                if( checkCycle(neighbor) ) return true;
            }else if( dfsVisited.contains(neighbor) ) return true;
        }
        
        dfsVisited.remove(node);
        return false;
    }
}