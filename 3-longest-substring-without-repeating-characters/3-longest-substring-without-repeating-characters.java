class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int a_pointer = 0;
        int b_pointer = 0;
        int maxLength = 0;
        
        while( b_pointer < s.length() ){
            char ch = s.charAt(b_pointer);
            
            while( a_pointer < s.length() && set.contains( ch ) ){
                maxLength = Math.max(maxLength , set.size());
                
                set.remove(s.charAt(a_pointer++));
            }
            
            set.add(ch);
            b_pointer++;
        }
        
        return maxLength = Math.max(maxLength,set.size());
    }
}