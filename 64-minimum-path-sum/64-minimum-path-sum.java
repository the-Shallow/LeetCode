// Spcae Complexity = O(N^2)
// Time Complexity = O(N^2)
class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        memo = new int[rows+1][cols+1];
        
        for(int i = 0;i<=rows;i++){
            for(int j = 0;j<=cols;j++) memo[i][j] = -1; 
        }
        
        return helper( grid , 0 , 0 );
    }
    
    public int helper( int[][] grid , int row , int col ){
        
        if( row == grid.length  && col == grid[0].length - 1  ) return 0;
        if( row == grid.length - 1  && col == grid[0].length  ) return 0;
        if( row == grid.length ) return Integer.MAX_VALUE - 1000;
        if( col == grid[0].length ) return Integer.MAX_VALUE - 1000;
        
        if( memo[row][col] != -1 ) return memo[row][col];
        
        int right = grid[row][col] +  helper( grid , row , col + 1 );
        int down =  grid[row][col] + helper( grid , row + 1, col );
        // System.out.println( row + " " + col + " " + right + " " + down );
        return memo[row][col] =  Math.min( right , down );
    }
}