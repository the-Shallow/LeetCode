// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    
    class Node {
        int val;
        int parent;
        
        public Node(int val , int parent){
            this.val = val;
            this.parent = parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    Set<Integer> visited = new HashSet<>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        for( int i = 0;i<adj.size();i++ ){
            List<Integer> temp = new ArrayList<>();
            for( int j = 0;j<adj.get(i).size();j++ ){
                temp.add( adj.get(i).get(j) );
            }
            
            map.put(i,temp);
        }
        
        for( int i = 0;i<V;i++ ){
            if( !visited.contains( i ) ){
                if( cycleCheck(i,-1) ) return true;
            }
        }
        
        return false;
    }
    
    public boolean cycleCheck( int node,int prev ){
        Queue<Node> queue = new LinkedList<>();
        queue.add( new Node( node,prev ) );
        
        visited.add( node );
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for( int i = 0;i<size;i++ ){
                Node curr = queue.poll();
                
                for( int neighbor : map.get(curr.val) ){
                    if( visited.contains(neighbor) ) {
                        if( curr.parent != neighbor ) return true;
                    }else {
                        visited.add(neighbor);
                        queue.offer(new Node(neighbor , curr.val) );
                    }
                }
            }
        }
        
        return false;
    }
}