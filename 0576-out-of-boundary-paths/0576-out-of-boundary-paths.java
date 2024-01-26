class Solution {
    long[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long result = 0;
        dp = new long[m+1][n+1][maxMove+1];
        
        for(int i = 0;i<=m;i++){
            for(int j = 0;j<=n;j++){
                for(int k = 0;k<=maxMove;k++) dp[i][j][k] = -1;
            }
        }
        
        
//         for(int i = 1;i<=maxMove;i++){
//             result = (result + helper(m,n,i,startRow, startColumn))% 1000000007 ;
//         }
        
        return (int)(helper(m,n,maxMove,startRow, startColumn));
    }
    
    public long helper(int m, int n, int maxMove, int row, int col){
        
         if(maxMove < 0)  return 0;
        if( row < 0 || col < 0 || row == m || col == n  )  return 1;
        // System.out.println(maxMove + " " + row + " " + col);
        
        if(dp[row][col][maxMove] != -1) return dp[row][col][maxMove];
        // System.out.println(maxMove + " " + row + " " + col);
        long left = helper(m,n,maxMove-1,row,col-1);
        long right = helper(m,n,maxMove-1,row,col+1);
        long down = helper(m,n,maxMove-1,row + 1,col);
        long up = helper(m,n,maxMove-1,row - 1,col);
        
        return dp[row][col][maxMove] = (left + right + down + up)% 1000000007;
    }
}