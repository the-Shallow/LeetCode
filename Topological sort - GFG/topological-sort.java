// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[V];
        int[] res = new int[V];
        int k = 0;
        // System.out.println( adj.size() );
        for( int i = 0;i<V;i++ ){
            // System.out.println(i);
            // System.out.println( adj.get(i).size() );
            for( int j = 0;j<adj.get(i).size();j++ ){
                indegree[ adj.get(i).get(j) ]++;
            }
        }
        
        // System.out.println("Indegree--->");
        // for(int top : indegree ){
        //     System.out.println(top);
        // }
        
        // System.out.println("--->");
        
        Queue<Integer> queue = new LinkedList<>();
        
        for( int i = 0;i<indegree.length;i++ ){
            if( indegree[i] == 0 ){
                queue.offer( i );
            }
        }
        
        if( queue.isEmpty() ) return new int[] {};
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for(int i = 0;i<size;i++){
                int val = queue.poll();
                // System.out.println(val);
                // System.out.println("-----------");
                res[k++] = val;
                for( int j = 0;j<adj.get(val).size();j++ ){
                    indegree[adj.get(val).get(j)]--;
                    // System.out.println( indegree[adj.get(val).get(j)]  );
                    if( indegree[ adj.get(val).get(j)]  == 0 ){
                        queue.offer( adj.get(val).get(j) );
                    }
                }
            }
        }
        
        //   System.out.println("Res--->");
        // for( int i = 0;i<res.length;i++ ){
        //     System.out.println( res[i] );
        // }
        
        return res;
    }
}
