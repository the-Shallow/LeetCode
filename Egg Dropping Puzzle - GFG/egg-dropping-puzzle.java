// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}


// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int[][] memo;
    static int eggDrop(int n, int k) 
	{
	    memo = new int[n+1][k+1];
	    
	    for(int i = 0;i<=n;i++){
	        for(int j = 0;j<=k;j++) memo[i][j] = -1;
	    }
	    
	    return helper(n,k);
	}
	
	static int helper(int e , int f){
	    if(f == 0 || f == 1) return f;
	    
	    if(e == 1) return f;
	    
	    if(memo[e][f] != -1 ) return memo[e][f];
	    
	    int res = Integer.MAX_VALUE;
	    
	    for(int k = 1;k<=f;k++){
	        int temp = 1 + Math.max( helper( e-1,k-1 ) , helper( e , f - k ) );
	        
	        res = Math.min(res,temp);
	    }
	    
	    memo[e][f] = res;
	    return res;
	}
}