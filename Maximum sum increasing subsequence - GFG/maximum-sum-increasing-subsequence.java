// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] memo;
	public int maxSumIS(int arr[], int n)  
	{  
	    memo = new int[n+1][n+1];
	    
	    for(int i = 0;i<=n;i++){
	        for(int j = 0;j<=n;j++) memo[i][j] = -1;
	    }
	    return helper(arr,0,n,-1);
	}  
	
	public int helper( int[] arr  , int index , int n ,int prev ){
	    if( index == n ) {
	        return 0;
	    }
	    
	    if(memo[index][prev+1] != - 1) return memo[index][prev+1];
	   // if( map.containsKey( index + ":" + prev + ":" + sum ) ) return map.get(index + ":" + prev + ":" + sum);

	    if( prev != -1 && arr[prev] >= arr[index] ){
	        return memo[index][prev+1] = helper( arr , index + 1, n , prev );
	    }else {
	        return memo[index][prev+1] = Math.max( arr[index] + helper(arr,index+1,n,index) ,
	        helper(arr,index+1,n,prev) );
	    }
	}
}