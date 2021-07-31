class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int[] rowMax = new int[length];
        int[] colMax = new int[length];
        int res = 0;
        
        for(int r = 0;r < length ; r++ ){
            for(int c = 0;c<length; c++){
                rowMax[r] = Math.max( rowMax[r] , grid[r][c] );
                colMax[c] = Math.max( colMax[c] , grid[r][c] );
            }
        }
        
        for(int i = 0;i<length;i++){
            for(int j = 0;j<length;j++){
                res += Math.min( rowMax[i] , colMax[j] ) - grid[i][j];
            }
        }
        
        return res;
    }
}