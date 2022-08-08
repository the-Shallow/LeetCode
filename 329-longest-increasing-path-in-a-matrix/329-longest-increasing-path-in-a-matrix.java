class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++) dp[i][j] = -1;
        }
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                res = Math.max( res , helper(matrix,i,j,-1, dp) );
            }
        }
        
        return res;
    }
    
    public int helper( int[][] grid , int row , int col , int prev  ,int[][] dp){
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] <= prev ) return 0;
        
        if( dp[row][col] != -1 ) return dp[row][col];
        
        int left = helper(grid,row,col-1,grid[row][col] ,dp);
        int right = helper(grid,row,col+1,grid[row][col] ,dp);
        int up = helper(grid,row-1,col,grid[row][col] , dp);
        int down = helper(grid,row + 1,col,grid[row][col] ,dp);
        
        return dp[row][col] = 1 + Math.max( Math.max(left,right) , Math.max(up,down) );
    }
}