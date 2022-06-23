class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1;
        int currMin = 1;
        int res = Integer.MIN_VALUE;
        
        for( int num : nums ){
            int temp = currMax;
            
            currMax = Math.max( num , Math.max( currMax * num , currMin * num ) );
            currMin = Math.min( num , Math.min(temp*num , currMin * num ));
            
            res = Math.max(res,currMax);
        }
        
        return res;
    }
}