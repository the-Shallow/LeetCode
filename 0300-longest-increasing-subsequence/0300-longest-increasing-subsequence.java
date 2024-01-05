class Solution {
    Map<Integer,Integer> map;
    public int lengthOfLIS(int[] nums) {
       map = new HashMap<>();
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            res = Math.max(res, helper(nums,nums[i],Integer.MIN_VALUE,i));
        }
        
        return res;
    }
    
    public int helper(int[] nums, int curr, int prev, int index){
        if(curr <= prev || index == nums.length) return 0;
        
        if(map.containsKey(index)) return map.get(index);
        
        int count = 0;
        
        for(int i = index+1;i<nums.length;i++ ){
            int val = nums[i];
            
            count = Math.max(count, helper(nums,val,curr,i));
        }
        
        map.put(index,count+1);
        return count + 1;
    }
}