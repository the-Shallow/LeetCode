class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = 2*nums.length;
        
        int[] res = new int[len];
        
        for(int i = 0;i<len;i++){
            res[i] = nums[i%nums.length];
        }
        
        return res;
    }
}