class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length,n = grid1[0].length;
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if( grid2[i][j] == 1 ){
                    count += helper( grid1,grid2,i,j );
                }
            }
        }
        
        return count;
    }
    
    public int helper( int[][] grid1 , int[][] grid2 , int row , int col ){
        int res = 1;
        if( row < 0 || row == grid1.length || col < 0 || col == grid1[0].length || grid2[row][col] == 0 ){
            return 1;
        }
        
        grid2[row][col] = 0;
        res &= helper( grid1,grid2,row-1,col );
        res &= helper( grid1,grid2,row+1,col );
        res &= helper( grid1,grid2,row,col-1 );
        res &= helper( grid1,grid2,row,col+1 );
        
        return res & grid1[row][col];
        
    }
}