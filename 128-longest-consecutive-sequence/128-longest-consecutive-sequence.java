class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for( int num : nums ) set.add(num);
        
        int longestStreak = 0;
        
        for( int num : nums ){
            if( !set.contains( num - 1 ) ){
                int currStreak = 1;
                
                while( set.contains( num + 1 ) ){
                    num++;
                    currStreak++;
                }
                
                longestStreak = Math.max( longestStreak , currStreak );
            }
        }
        
        return longestStreak;
    }
}