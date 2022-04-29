class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length+1][2];
        
        for( int i = 0;i<=prices.length;i++ ){
            for(int j = 0;j<2;j++){
                memo[i][j] = -1;
            }
        }
        
        
        return helper( prices, 0, 1 , 0 );
    }
    
    public int helper( int[] prices , int index  , int tran , int des ){
        if( index >= prices.length || tran <= 0  ) return 0;
        
        if( memo[index][des] != -1 ) return memo[index][des];
        
        if(des == 0){
            return memo[index][des] =  Math.max( helper(  prices , index + 1 , tran  , 1  ) - prices[index] , 
                           helper(  prices , index+1,tran,0 )); 
        }else {
            return memo[index][des] =  Math.max( helper( prices , index + 1 , tran -1 , 0 ) + prices[index] , 
                            helper( prices , index+1 , tran , 1  )  );
        }
    }
}