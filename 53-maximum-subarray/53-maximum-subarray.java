// Space Complexity = O(1)
// Time Complexity = O(N)
class Solution {
    public int maxSubArray(int[] nums) {
        int max_here = Integer.MIN_VALUE;
        int max_end_here = 0;
        for( int i = 0;i<nums.length;i++ ){
             max_end_here += nums[i];
            
            max_here = Math.max( max_here , max_end_here );
            
            if( max_end_here < 0 ) max_end_here = 0;
        }
        
        return max_here;
    }
}