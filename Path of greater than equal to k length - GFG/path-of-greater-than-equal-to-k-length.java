// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  V = Integer.parseInt(input_line[0]);
            int  E = Integer.parseInt(input_line[1]);
            int  K = Integer.parseInt(input_line[2]);
            int A[] = new int[3*E + 1];
            String input_line1[] = read.readLine().trim().split("\\s+");
            for(int i=0;i<3*E;i++){
                A[i] = Integer.parseInt(input_line1[i]);
            }
        
            Solution ob = new Solution();
            if(ob.pathMoreThanK(V, E, K, A)){
                System.out.println(1);
            } else{
                System.out.println(0);   
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    class Node {
        int end;
        int cost;
        
        public Node(int end,int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    
    Map<Integer,List<Node>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    boolean pathMoreThanK(int V , int E , int K , int [] A){
        
        for( int i = 0;i<A.length-1;i+=3 ){
            // if(i >= A.length ||  i+1 >= A.length || i+2 >= A.length) {
            //      System.out.println(i + " " + (i+1) + " " + (i+2) );
            //      return false;
            // }
            int start = A[i];
            int end = A[i+1];
            int cost = A[i+2];
            // System.out.println(i + " " + (i+1) + " " + (i+2) );
            Node neighbor = new Node(end,cost);
            List<Node> temp = map.getOrDefault( start , new ArrayList<>() );
            temp.add(neighbor);
            map.put(start , temp);
            
            Node newNeighbor = new Node(start,cost);
            temp = map.getOrDefault(end,new ArrayList<>());
            temp.add( newNeighbor );
            map.put(end,temp);
        }
        
        visited.add(0);
        return helper(0,K);
        
    }
    
    boolean helper( int start , int k ){
        if(k <= 0) return true;
        
        List<Node> temp = map.get(start);
        
        if(temp == null){
            return false;
        }
        
        
        for( Node neighbor : temp ){
            int end = neighbor.end;
            int cost = neighbor.cost;
            
            if(visited.contains(end) ) continue;
            visited.add( end );
            if( cost >= k ) return true;
            
            if( helper(end , k - cost) ) return true;
            
            visited.remove(end);
        }
        
        return false;
    }
    
}