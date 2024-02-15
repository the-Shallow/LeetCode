class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        long total = 0,res = -1;
        
        for(int i = 0;i<nums.length;i++){
            if(total > nums[i]){
                res = total + nums[i];
            }
            total += nums[i];
        }
        
        return res;
    }
}