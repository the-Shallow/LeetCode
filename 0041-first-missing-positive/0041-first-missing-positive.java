// Space Complexity = O(1)
// Time Complexity = O(n)
// Not done by Khush
class Solution {
    public int firstMissingPositive(int[] nums) {
        for( int i = 0 ;i<nums.length;i++ ){
            if( nums[i] < 0 ) nums[i] = 0;
        }
        
        for( int i = 0;i<nums.length;i++ ){
            int val = Math.abs( nums[i] );
            
            if( val >= 1 && val <= nums.length ){
                if( nums[val-1] > 0 ){
                    nums[val-1] *= -1;
                }else if( nums[val-1] == 0 ){
                    nums[val-1] = -1 * ( nums.length + 1 );
                }
            }
        }
        
        for( int i = 1;i<=nums.length;i++ ){
            if( nums[i-1] >= 0 ) return i;
        }
        
        return nums.length + 1;
    }
}