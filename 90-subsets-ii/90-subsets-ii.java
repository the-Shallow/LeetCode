// Space Complexity = O(n2^n)
// Time Complexity = O(n2^n)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        
        for(int k = 0;k<length+1;k++){
            helper( nums,k,new ArrayList<>(),0 );
        }
        
        return result;
    }
    
    public void helper( int[] nums, int k, List<Integer> list , int index ){
        if( list.size() == k ){
            if(!result.contains(list)){
                result.add(new ArrayList<>(list));
                return;
            }
        }
        
        for(int i = index ; i<nums.length;i++){
            list.add(nums[i]);
            helper(nums,k,list,i+1);
            list.remove(list.size() - 1);
        }
    }
}