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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] memo;
	public int minOperations(String str1, String str2) 
	{ 
	    int m = str1.length();
	    int n = str2.length();
	    memo = new int[m+1][n+1];
	    
	    for(int i = 0;i<=m;i++){
	        for(int j = 0;j<=n;j++) memo[i][j] = -1;
	    }
	    
	    
	    return helper( str1,str2,m,n );
	}
	
	public int helper( String str1 , String str2 , int m , int n ){
	    if(m == 0 && n == 0) return 0;
	    if(m == 0) return n;
	    if(n == 0) return m;
	    
	    if( memo[m][n] != -1 ) return memo[m][n];
	    
	    
	    if( str1.charAt(m-1) == str2.charAt(n-1) ){
	        return memo[m][n] =  helper(str1,str2,m-1,n-1);
	    }else {
	        return memo[m][n] = Math.min( 1 + helper(str1,str2,m-1,n) , 1 + helper(str1,str2,m,n-1) );
	    }
	}
}