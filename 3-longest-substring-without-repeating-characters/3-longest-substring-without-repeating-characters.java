// Space Complexity = O(N)
// Time Complexity = O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int a_pointer = 0;
        int b_pointer = 0;
        int maxLength = 0;
        
        while( b_pointer < s.length() ){
            char ch = s.charAt(b_pointer);
            
            if( !map.containsKey( ch ) ){
                map.put( ch , 0 );
                maxLength = Math.max( maxLength , map.size() );
                b_pointer++;
            }else {
                map.remove( s.charAt(a_pointer) );
                a_pointer++;
            }
        }
        
        return maxLength;
    }
}