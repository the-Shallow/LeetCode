// Space Complexity = O(N)
// Time Complexity = O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        
        int longestStreak = 0;
        
        for( int num : nums ){
            if( !set.contains(num-1) ){
                int streak = 1;
                while( set.contains(num+1) ){
                    num++;
                    streak++;
                }
                longestStreak = Math.max( longestStreak , streak );
            }
            
        }
        
        return longestStreak;
    }
}





















