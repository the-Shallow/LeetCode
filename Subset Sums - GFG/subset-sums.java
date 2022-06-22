// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        
        for( int k = 0;k<=N;k++ ){
            helper( arr , k ,0, 0 , N );
        }
        
        return list;
    }
    
    public void helper( ArrayList<Integer> arr , int k , int sum ,int curr_index , int N ){
        if( k == 0 ){
            list.add(sum);
            return;
        }
        
        for( int i = curr_index ; i < N;i++ ){
            helper( arr , k - 1 , sum + arr.get(i) , i+1,N );
        }
    }
}