// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends


class Solution
{
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        maxHeap.offer( x );
        minHeap.offer( maxHeap.poll() );
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       if( minHeap.size() > maxHeap.size()  ){
           int val = minHeap.poll();
           maxHeap.offer( val );
       }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek() ) / 2.0 :
                                            maxHeap.peek();
    }
    
}