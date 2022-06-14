class Solution {
    public void nextPermutation(int[] nums) {
        int first = nums.length-1;
        
        while( first > 0 && nums[first-1] >= nums[first] ){
            first--;
        }
        
        if(first == 0){
            Arrays.sort(nums);
            return;
        }
        
        first--;
        
        int second = nums.length - 1;
        
        while( first < second && nums[first] >= nums[second] ){
            second--;
        }
        
        swap( nums, first , second );
        
        reverse(nums,first+1,nums.length-1);
    }
    
    public void swap( int[] nums, int loc1 , int loc2 ){
        int temp = nums[loc1];
        nums[loc1] = nums[loc2];
        nums[loc2] = temp;
    }
    
    public void reverse( int[] nums, int loc1 , int loc2 ){
        while( loc2 > loc1 ){
            swap( nums, loc1,loc2 );
            loc2--;
            loc1++;
        }
    }
}