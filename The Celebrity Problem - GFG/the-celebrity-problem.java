// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Queue<Integer> queue = new LinkedList<>();
    	
    	for( int i = 0;i<n;i++ ){
    	    queue.offer(i);
    	}
    	
    	int prev_size = Integer.MAX_VALUE;
    	int counter = 0;
    	while( queue.size() > 1 ){
    	    prev_size = queue.size();
    	    int a = queue.poll();
    	    int b = queue.poll();
    	    
    	    if( counter == n ) return -1;
    	    boolean a_knows = knows( M ,a , b );
    	    boolean b_knows = knows( M ,b  ,a );
    	    
    	    if( ( a_knows && b_knows ) || ( !a_knows && !b_knows )  ){
    	   
    	        if( queue.size() == 0 ) return -1;
    	        
    	        queue.offer( a );
    	        queue.offer( b );
    	        
    	        if( queue.size() == prev_size ){
    	            counter++;
    	        }else {
    	            counter = 0;
    	        }
    	    }else {
    	        if( a_knows ) queue.offer( b );
    	        else queue.offer( a );
    	        counter = 0;
    	    }
    	}
    	
    	return queue.poll();
    }
    
    boolean knows( int[][] M , int A , int B ){
        return M[A][B] == 1 ? true : false;
    }
}