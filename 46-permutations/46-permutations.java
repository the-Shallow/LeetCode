// Space Complexity = O(n!*n)
// Time Complexity = O(n!)
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        helper(nums,list,0);
        
        return result;
    }
    
    public void helper( int[] nums , List<Integer> list , int index ){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            
            list.add(nums[i]);
            helper(nums,list,index+1);
            list.remove(list.size() - 1);
        }
    }
}