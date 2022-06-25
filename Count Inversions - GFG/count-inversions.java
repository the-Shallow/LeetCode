// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr,0,arr.length-1);
    }
    
    public static long mergeSort( long[] arr , int left , int right ){
        long inverse_count = 0;
        if( left < right ){
            int mid = left + (right-left) /2;
            
            inverse_count += mergeSort(arr,left,mid);
            inverse_count += mergeSort(arr,mid+1,right);
            
            inverse_count += merge(arr,left,mid,right);
        }
        
        return inverse_count;
    }
    
    public static long merge(long[] arr , int left , int mid , int right ){
        int length1 = mid - left + 1;
        int length2 = right - mid;
        long inverse_count = 0;
        long[] arr1 = new long[length1];
        long[] arr2 = new long[length2];
        
        for(int i = 0;i<length1;i++){
            arr1[i] = arr[left+i]; 
        }
        
        for(int j = 0;j<length2;j++){
            arr2[j] = arr[mid+j+1];
        }
        
        int k = left;
        int i = 0 , j = 0;
        
        while( i < length1 && j < length2 ){
            if( arr1[i] <= arr2[j] ){
                arr[k++] = arr1[i++];
            }else {
                arr[k++] = arr2[j++];
                
                inverse_count += ( length1 - i );
            }
        }
        
        while(i < length1){
            arr[k++] = arr1[i++];
        }
        
        while(j < length2){
            arr[k++] = arr2[j++];
        }
        
        // System.out.println("-------------");
        // System.out.println(left + " " + mid + " " + right);
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));
        // System.out.println(Arrays.toString(arr));
        // System.out.println("-------------");
        
        return inverse_count;
    } 
}