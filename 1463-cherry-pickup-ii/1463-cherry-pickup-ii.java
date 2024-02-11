class Solution {
    int[][][][] dp;
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows+1][cols+1][rows+1][cols+1];
        
        for(int i = 0;i<=rows;i++){
            for(int j = 0;j<=cols;j++){
                for(int k = 0;k<=rows;k++){
                    for(int l = 0;l<=cols;l++) dp[i][j][k][l] = -1;
                }
            }
        }
        
        return helper(grid, 0,0, 0, cols - 1);
    }
    
    public int helper(int[][] grid, int row1, int col1, int row2, int col2){
        if(row1 < 0 || row1 == grid.length || col1 < 0 || col1 == grid[0].length) return 0;
        if(row2 < 0 || row2 == grid.length || col2 < 0 || col2 == grid[0].length) return 0;
        
        if(dp[row1][col1][row2][col2] != -1) return dp[row1][col1][row2][col2];
        
        int temp1 = grid[row1][col1];
        int temp2 = grid[row2][col2];
        int res = temp1 + temp2;
        
        if(row1 == row2 && col1 == col2){
            res = temp1;
        }
        
        grid[row1][col1] = 0;
        grid[row2][col2] = 0;
        
        int pos1 = res + helper(grid, row1+1,col1-1, row2+1,col2-1);
        int pos2 = res + helper(grid, row1+1,col1-1, row2+1,col2);
        int pos3 = res + helper(grid, row1+1,col1-1, row2+1,col2+1);
    
        
        int pos4 = res + helper(grid, row1+1,col1, row2+1,col2-1);
        int pos5 = res + helper(grid, row1+1,col1, row2+1,col2);
        int pos6 = res + helper(grid, row1+1,col1, row2+1,col2+1);
        
        int pos7 = res + helper(grid,row1 + 1, col1 + 1, row2+1,col2-1);
        int pos8 = res + helper(grid, row1 + 1,col1 + 1, row2+1,col2);
        int pos9 = res + helper(grid, row1 + 1,col1 + 1, row2+1,col2+1);
        
        grid[row1][col1] = temp1;
        grid[row2][col2] = temp2;
        return dp[row1][col1][row2][col2] = Math.max(  pos1 , Math.max( pos2, Math.max( pos3 , Math.max( pos4
                                                                          , Math.max(pos5,
                                                                                    Math.max(pos6, Math.max(pos7, Math.max(pos8, pos9))))) )  ) );
    }
}