// Space Complexity = O(N^2)
// Time Complexity = O(N^2)
class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length+1][2];
        
        for(int i = 0;i<=prices.length;i++){
            for(int j = 0;j<2;j++){
                memo[i][j] = -1;
            }
        }
        
        return helper(prices,0,1,0);
    }
    
    public int helper(int[] prices , int index , int tran , int des){
        if( index == prices.length || tran <= 0 ) return 0;
        
        if(memo[index][des] != -1) return memo[index][des];
        
        // des == 0 equals to buy stock
        // des == 1 equals to sell a stock
        // tran can be 1 or 0 because only one transaction of buyinh and selling can be done
        if( des == 0 ){
            return  memo[index][des] = Math.max( helper(prices,index+1,tran,1) - prices[index] , helper(prices,index+1,tran,0)  ) ;
        }else {
            return memo[index][des] = Math.max( helper( prices,index+1,tran-1,0 ) + prices[index] , helper(prices,index+1,tran,1) );
        }
    }
}