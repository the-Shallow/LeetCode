class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0,right = 0;
        
        while(right < nums.length){
            int num = nums[right];
            
            int freq = map.getOrDefault(num,0) + 1;
            map.put(num,freq);
            
            while(left < nums.length && freq > k){
                int leftNum = nums[left];
                
                if(leftNum != num){
                    map.put(leftNum, map.get(leftNum)-1);
                }else {
                    map.put(leftNum,map.get(leftNum)-1);
                    freq = map.get(leftNum);
                }
                left++;
            }
            
           
            res = Math.max(res, right - left + 1);
            right++;
        }
        
        return res;
    }
}