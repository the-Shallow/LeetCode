class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        Set<Character> stringSet = new HashSet<>();
        int max = 0;
        while(b_pointer < s.length()){
            if( !stringSet.contains(s.charAt(b_pointer)) ){
                stringSet.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(  stringSet.size() , max );
            }else{
                stringSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        
        return max;
    }
}