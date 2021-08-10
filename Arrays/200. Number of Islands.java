class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length,n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if( grid[i][j] == '1' ){
                    count+=helper(grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    public int helper(char[][] grid,int row,int col){
        int res = 1;
        if( row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == '0' ) {
                return 1;
        }
        
        grid[row][col] = '0';
        res &= helper( grid,row-1,col );
        res &= helper( grid,row+1,col );
        res &= helper( grid,row,col-1 );
        res &= helper( grid,row,col+1 );
        
        return res;
    }
}