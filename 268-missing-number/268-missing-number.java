class Solution {
    public int missingNumber(int[] nums) {
        
         if(nums == null || nums.length == 0){
            return 0;
        }
        
        int res = nums[0];
        
        for(int i = 1;i<nums.length;i++){
            res ^= nums[i];
        }
        
        // 3^0^1
        
        for( int i = 0 ; i<=nums.length ; i++ ){
            res ^= i;
        }
        
        // 3^0^1^0^1^2^3
        
        return res;
    }
}