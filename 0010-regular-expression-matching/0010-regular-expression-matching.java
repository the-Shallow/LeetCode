class Solution {
    Map<String,Boolean> map;
    public boolean isMatch(String s, String p) {
        map = new HashMap<>();
        return helper(s,p,0,0);
    }
    
    public boolean helper(String s, String p, int i, int j){
        
        String curr = i + ":" + j;
        if(map.containsKey(curr)) return map.get(curr);
        if(i >= s.length() && j>= p.length()) return true;
        
        if(j >= p.length()) return false;
        
        boolean match = (i < s.length() && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ));
        
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean temp = helper(s,p,i,j+2) || (match && helper(s,p,i+1,j));
            map.put(curr,temp);
            return temp;
        }
        
        if( match ) {
            boolean temp = helper(s,p,i+1,j+1);
            map.put(curr,temp);
            return temp;  
        } 
        
        map.put(curr,false);
        return false;
    }
}