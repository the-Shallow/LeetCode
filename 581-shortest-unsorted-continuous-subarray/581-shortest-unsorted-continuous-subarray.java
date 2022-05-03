class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = Arrays.copyOfRange(nums,0,nums.length);
        
        Arrays.sort(sorted);
        int start = nums.length , end = 0;
        for(int i = 0;i<nums.length;i++){
            if( nums[i] != sorted[i] ){
                start = Math.min(start , i );
                end = Math.max( end , i );
            }
        }
        
        return end - start >= 0 ? end - start + 1 : 0;
    }
}