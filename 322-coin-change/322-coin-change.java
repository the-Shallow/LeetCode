class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        
        memo = new int[m+1][amount+1];
        
        for( int i = 0;i<=m;i++ ){
            for(int j = 0;j<=amount;j++){
                memo[i][j] = -1;
            }
        }
        
        int val = helper(coins,m-1,amount);
        
        return val == Integer.MAX_VALUE-1 ? -1 : val ;
    }
    
    public int helper( int[] coins , int curr , int target  ){
        
        if(target == 0) return 0;
        
        if( curr < 0  ) return Integer.MAX_VALUE - 1;
        
        if( memo[curr][target] != -1 ) return memo[curr][target];
        
        if( coins[curr] > target ){
            return memo[curr][target] =  helper( coins , curr - 1, target  );
        }else {
            return memo[curr][target] = Math.min(  1 + helper( coins,curr,target - coins[curr] ) , helper( coins , curr - 1, target )  );
        }
    }
}