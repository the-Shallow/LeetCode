*** METHOD-1 ***
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        
        for(int i = 0;i<nums.length;i++){
            int j = nums.length - 1;
            while(j != index[i]){
                res[j] = res[j-1];
                j--;
            }
            res[index[i]] = nums[i];
        }
        
        
        return res;
    }
}

*** METHOD-2 ***

