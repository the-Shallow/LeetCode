// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution
{
    
    class Pair {
        int row;
        int col;
        int steps;
        
        public Pair(int row , int col , int distance){
            this.row = row;
            this.col = col;
            this.steps = distance;
        }
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[N+1][N+1];
        
        int[] x = {-2,-2,2,2,-1,-1,1,1};
        int[] y = {-1,1,-1,1,2,-2,2,-2};
        
        
        Pair initial = new Pair( KnightPos[1] , KnightPos[0] , 0 );
        queue.offer(initial);
        visited[KnightPos[1]][KnightPos[0]] = 1;
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for( int i = 0;i<size;i++ ){
                Pair pair = queue.poll();
                
                if( pair.row == TargetPos[1] && pair.col == TargetPos[0] ){
                    return pair.steps;
                }
                
                for( int j = 0;j<8;j++ ){
                    int row = x[j] + pair.row;
                    int col = y[j] + pair.col;
                    
                    if( row < 0 || col < 0 || row > N || col > N || visited[row][col] == 1) continue;
                    visited[row][col] = 1;
                    queue.offer( new Pair(row,col,pair.steps+1) );
                }
            }
        }
        
        
        return -1;
    }
}