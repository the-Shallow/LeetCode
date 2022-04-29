class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while( left  < right ){
            int midpoint = left + (right - left) / 2;
            
            if( nums[midpoint] > nums[right] ) left = midpoint + 1;
            else right = midpoint;
        }
        
        return nums[left];
    }
}