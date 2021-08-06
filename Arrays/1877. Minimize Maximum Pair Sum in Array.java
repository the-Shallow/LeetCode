class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int max = 0;
        for(int i = 0;i<size/2;i++){
            max = Math.max(max , nums[i] + nums[size - i-1]);
        }
        
        return max;
    }
}