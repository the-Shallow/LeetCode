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
    Map<Integer,List<Integer>> map = new HashMap<>();
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        
        for(int i = 0;i<adj.size();i++){
            List<Integer> temp = new ArrayList<>();
            for( int j = 0;j<adj.get(i).size();j++ ){
                temp.add(adj.get(i).get(j) );
                indegree[ adj.get(i).get(j) ]++;
            }
            
            map.put(i,temp);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for( int i = 0;i<V;i++ ){
            if(indegree[i] == 0 ) queue.offer(i);
        }
        
        while( !queue.isEmpty() ){
            int node = queue.poll();
            
            for( int neighbor : map.get(node) ){
                indegree[neighbor]--;
                
                if( indegree[neighbor] == 0 ){
                    queue.offer(neighbor);
                }
            }
        }
        
        for( int num : indegree ) if(num != 0) return true;
        return false;
    }
}