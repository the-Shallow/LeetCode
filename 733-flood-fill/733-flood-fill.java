class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        
        helper( image, sr,sc,image[sr][sc] , color );
        
        return image;
    }
    
    public void helper( int[][] grid , int row , int col , int currColor , int newColor ){
        if( row < 0  || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != currColor || grid[row][col] == newColor ) return;
        
        grid[row][col] = newColor;
        
        helper( grid , row - 1, col , currColor,newColor );
        helper( grid , row + 1,col ,currColor, newColor);
        helper( grid , row , col-1,currColor,newColor);
        helper( grid, row , col + 1, currColor, newColor);
        
        return;
    }
}