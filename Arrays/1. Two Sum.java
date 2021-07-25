class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
    
        
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            int val = target - num;
            Integer returnVal = map.get(val);
            
            if( returnVal != null ){
                return new int[] { returnVal,i };
            }else 
            {
                map.put( num,i );
            }
        }
        
        return null;
    }
}