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
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0;i<index.length;i++){
            temp.add( index[i] , nums[i] );
        }
        
        for(int i = 0;i<temp.size();i++){
            nums[i] = temp.get(i);
        }
        
        return nums;
    }
}
