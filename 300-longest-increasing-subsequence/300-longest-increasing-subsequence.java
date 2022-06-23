// Space Complexity = O(N)
// Time Complexity = O(N^2)
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        
        for( int i = nums.length-1;i>=0;i-- ){
            int val = helper(nums,nums[i],Integer.MIN_VALUE,i );
            
            res = Math.max( res , val );
        }
        
        return res;
    }
    
    public int helper(int[] nums , int curr , int prev , int index ){
        
        if( curr <= prev ) return 0;
        
        if( index == nums.length ) return 0;
        
        if( map.containsKey(index) ) return map.get(index);
        
        int count = 0;
        
        for( int i = index + 1;i<nums.length;i++ ){
            int val = nums[i];
            
            count = Math.max( count , helper( nums , val , curr , i   ) ) ;
        }
        
        map.put( index , count+1 );
        return count + 1;
    }
}