class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] res = new int[nums.length/3][3];
        
        Arrays.sort(nums);
        int g = 0;
        for(int i = 0;i<nums.length;i+=3){
            for(int j = i;j<i+3;j++){
                if( nums[i+2] - nums[i] > k ) return new int[][] {};
                res[g][j-i] = nums[j];
            }
            g++;
        }
        
        return res;
    }
}