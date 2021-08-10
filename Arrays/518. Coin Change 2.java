class Solution {
    int[][] memo = new int[5001][301];
    public int change(int amount, int[] coins) {
        
        for(int i = 0;i<5001;i++){
            for(int j = 0;j<301;j++){
                memo[i][j] = -1;
            }
        }
        
        return helper( coins , coins.length - 1 ,amount );
    }
    
    public int helper( int[] coins , int length , int amount ){
        if( length < 0  ){
            return 0;
        }
        
        if( amount <= 0 ){
            return 1;
        }
        
        if( memo[amount][length] != -1 ) return memo[amount][length];
        
        if( coins[length] <= amount ){
            return memo[amount][length] =  helper( coins , length , amount - coins[length] ) + helper( coins , length - 1 , amount );
        }else 
        {
            return memo[amount][length] =  helper( coins , length-1 ,amount );
        }
    }
}