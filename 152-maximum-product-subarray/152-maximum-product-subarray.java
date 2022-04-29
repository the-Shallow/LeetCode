class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int currMax = 1,currMin = 1;
        
        for(  int num : nums  ){
            int temp = currMax ;
            
            currMax = Math.max( Math.max( currMax*num , currMin * num ) , num );
            currMin = Math.min( Math.min( temp * num , currMin * num ) , num );
            res = Math.max( res , currMax );
        }
        
        return res;
    }
}