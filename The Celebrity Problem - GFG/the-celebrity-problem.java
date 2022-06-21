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
    	Stack<Integer> st = new Stack<>();
        int c;
 
        // Step 1 :Push everybody
        // onto stack
        for (int i = 0; i < n; i++)
        {
            st.push(i);
        }
 
        while (st.size() > 1)
        {
            // Step 2 :Pop off top
            // two persons from the
            // stack, discard one
            // person based on return
            // status of knows(A, B).
            int a = st.pop();
            int b = st.pop();
 
            // Step 3 : Push the
            // remained person onto stack.
            if (knows(M , a, b))
            {
                st.push(b);
            }
 
            else
                st.push(a);
        }
       
        // If there are only two people
        // and there is no
        // potential candidate
        if(st.empty())
            return -1;
 
        c = st.pop();
 
        // Step 5 : Check if the last
        // person is celebrity or not
        for (int i = 0; i < n; i++)
        {
            // If any person doesn't
            //  know 'c' or 'a' doesn't
            // know any person, return -1
            if (i != c && (knows(M,c, i) ||
                          !knows(M,i, c)))
                return -1;
        }
        return c;
    }
    
    boolean knows( int[][] M , int A , int B ){
        return M[A][B] == 1 ? true : false;
    }
}