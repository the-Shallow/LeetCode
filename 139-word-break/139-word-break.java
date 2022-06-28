class Solution {
    Set<String> set = new HashSet<>();
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) set.add(word);
        memo = new int[s.length()+1];
        return helper(s,0);
    }
    
    public boolean helper(String s , int start ){
        if( start == s.length() ) return true;
        
        if( memo[start] != 0 ) return memo[start] == 1 ? true : false;
        
        for( int end = start + 1;end<=s.length();end++ ){
            if( set.contains( s.substring(start,end) ) & helper( s , end ) ){
                memo[start] = 1;
                return true;
            }
        }
        
        memo[start] = -1;
        return false;
    }
}