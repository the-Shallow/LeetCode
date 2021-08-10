class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        
        int temp = 1;
        for(int i = 0;i<length;i++){
            res[i] = temp;
            temp*=nums[i];
        }
        
        temp = 1;
        for(int i = length - 1;i>=0;i--){
            res[i] *= temp;
            temp*=nums[i];
        }
        
        return res;
    }
}