// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int res = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for( int i = 0;i<rows;i++ ){
            for(int j = 0;j<cols;j++){
                if( grid[i][j] == '1' ){
                    // res++;
                    res += helper( grid , i , j );
                }
            }
        }
        
        
        return res;
    }
    
    public int helper( char[][] grid , int row , int col ){
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length 
        || grid[row][col] == '0' ) return 0;
        
        grid[row][col] = '0';
        int res = 1;
        res |= helper( grid , row + 1 , col  );
        res |= helper( grid, row - 1 ,col  );
        res |= helper( grid , row , col + 1 );
        res |= helper( grid , row , col - 1 );
        res |= helper( grid , row + 1, col + 1 );
        res |= helper(grid ,  row -1 , col - 1);
        res |= helper( grid , row + 1, col - 1 );
        res |= helper( grid , row - 1, col + 1 );
        
        return res;
    }
}