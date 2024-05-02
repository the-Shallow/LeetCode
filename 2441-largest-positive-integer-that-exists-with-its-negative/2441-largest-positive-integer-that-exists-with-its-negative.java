class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        
        int res = Integer.MIN_VALUE;
        
        for(int num : set){
            if(num > 0 && set.contains( -1*num ) ){
                res = Math.max(res,num);
            }
        }
        
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}