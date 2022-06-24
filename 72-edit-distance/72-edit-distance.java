class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        memo = new int[m+1][n+1];
        
        for( int i = 0;i<=m;i++ ){
            for(int j = 0;j<=n;j++) memo[i][j] = -1;
        }
        
        int lcs = helper( word1,word2,m,n );
        
        return lcs;
     }
    
    public int helper( String word1 , String word2 , int m , int n ){
        
        if(m == 0 && n == 0) return 0;
        if(m == 0) return n;
        if(n == 0) return m;
        
        if(memo[m][n] != -1) return memo[m][n];
        
        if( word1.charAt(m-1) == word2.charAt(n-1) ){
            return memo[m][n] =  helper( word1,word2,m-1,n-1 );
        }else {
            return memo[m][n] = Math.min( 1 + helper( word1,word2,m-1,n-1 ),
                                        Math.min(1 + helper(word1,word2,m,n-1) , 1 + helper(word1,word2,m-1,n) ) );
        }
    }
}