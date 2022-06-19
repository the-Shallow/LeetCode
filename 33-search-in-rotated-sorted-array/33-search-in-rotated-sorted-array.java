// Space Complexity = O(1)
// Time Complexity = (logn)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        
        while( left < right ){
            int mid = left + (right - left) /2;
            // System.out.println( mid );
            if( nums[mid] > nums[right] ) left = mid + 1;
            else right = mid;
        }
        
        // System.out.println( left + " " + right);
        int start = left;
        left = 0;
        right = nums.length-1;
        
        if( target >= nums[start]  && target <= nums[right] ) left = start;
        else right = start;
        
        while( left <= right ){
            int mid =  left + (right - left) /2;
            
            if( nums[mid] == target ) return mid;
            
            if( nums[mid] < target ) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1;
    }
}