class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for( int c = 0 ; c < cols; c++ ){
            helper( heights , pacific , 0 , c , heights[0][c] );
            helper(heights , atlantic , rows-1 , c , heights[rows-1][c] );
        }
        
        for( int r = 0; r < rows ; r++ ){
            helper( heights , pacific , r , 0 , heights[r][0] );
            helper( heights , atlantic , r , cols - 1 , heights[r][cols-1] );
        }
        
        for( int i = 0 ; i<rows ; i++ ){
            for(int j = 0; j < cols ; j++){
                if( pacific[i][j] && atlantic[i][j] ) {
                    res.add( Arrays.asList(i, j) );
                }
            }
        }
        
        return res;
    }
    
    public void helper( int[][] heights , boolean[][] visited ,  int row , int col , int prev ){
        if( row < 0 || col < 0 || row == heights.length || col == heights[0].length || visited[row][col] || heights[row][col] < prev ) return;
        
        visited[row][col] = true;
        
        helper( heights , visited , row + 1 , col , heights[row][col] );
        helper( heights , visited , row - 1 , col , heights[row][col] );
        helper( heights , visited , row  , col + 1 , heights[row][col] );
        helper( heights , visited , row  , col - 1 , heights[row][col] );
    }
}