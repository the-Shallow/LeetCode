class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<= 1) return 0;
        
        int res = 0,prod = 1;
        int left = 0, right = 0;
        
        while(right < nums.length){
            prod *= nums[right];
            
            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            
            res += right - left + 1;
            right++;
        }
        
        return res;
    }
}