class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        
        int m = rowSum.length;
        int n = colSum.length;
        
        int i = 0,j = 0;
        
        while( i < m && j < n ){
            int min = Math.min( rowSum[i],colSum[j] );
            res[i][j] = min;
            
            rowSum[i] -= min;
            colSum[j] -= min;
            
            if( rowSum[i] == 0 )i++;
            if(colSum[j] == 0) j++;
        }
        
        return res;
    }
}