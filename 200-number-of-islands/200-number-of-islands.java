class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
    
        
        
        for( int i = 0 ; i < rows ; i++ ){
            for( int j = 0 ; j < cols; j++ ){
                if( grid[i][j] == '1' ){
                    res += helper( grid , i , j );
                }
            }
        }
        
        return res;
    }
    
    public int helper( char[][] grid , int row , int col ){
        if( row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == '0' ){
            return 1;
        }
        
        int ans = 1;
        grid[row][col] = '0';
        
        ans ^= helper( grid , row + 1 ,col );
        ans ^= helper( grid , row - 1 ,col );
        ans ^= helper( grid , row  ,col + 1 );
        ans ^= helper( grid , row  ,col - 1 );
        
        return ans;
        
    }
}