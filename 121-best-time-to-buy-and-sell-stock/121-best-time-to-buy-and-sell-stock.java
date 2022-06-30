// Space Complexity = O(N^2)
// Time Complexity = O(N^2)
// class Solution {
//     int[][] memo;
//     public int maxProfit(int[] prices) {
//         memo = new int[prices.length+1][2];
        
//         for(int i = 0;i<=prices.length;i++){
//             for(int j = 0;j<2;j++) memo[i][j] = -1;
//         }
//         return helper(prices,0,0,1);
//     }
    
//     public int helper( int[] prices , int index , int des , int tran ){
//         if( index == prices.length || tran <= 0 ) return 0;
        
//         if(memo[index][des] != -1) return  memo[index][des];
//         if(des == 0){
//             return memo[index][des] = Math.max( helper(prices,index+1,1,tran) - prices[index]  , 
//                            helper(prices,index+1,0,tran));
//         }else {
//             return memo[index][des] = Math.max( helper( prices , index + 1 , 0 , tran-1 ) + prices[index] , 
//                            helper(prices,index+1,1,tran));
//         }
//     }
// }

// Approach 2
// Space Complexity = O(1)
// Time Complexity = O(N)
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,max = 0;
        
        for(int i = 0;i<prices.length;i++){
            if(prices[i] < min) min = prices[i];
            else if( prices[i] > min ){
                max = Math.max(max , prices[i] - min);
            }
        }
        
        return max;
    }
    
   
}