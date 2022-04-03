class Solution {
    public void nextPermutation(int[] nums) {
        int first = nums.length - 1;
        
        while( first >= 1 && nums[first-1] >= nums[first] ) {
            first--;
        }
        
        
        if(first == 0) {
            Arrays.sort(nums);
            return;
        }
        
        first--;
        
        int second = nums.length-1;
        
        while( first < second && nums[second] <= nums[first] ){
            second--;
        }
        
        swap( nums , first , second );
        
        reverse( nums, first + 1 , nums.length - 1 );
        
    }
    
    
    public void swap(int[] nums , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public void reverse( int[] nums , int left , int right ){
        while( left < right ){
            swap( nums,left,right );
            left++;
            right--;
        }
    }
}