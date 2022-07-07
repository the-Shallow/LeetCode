class Solution {
    Set<String> set = new HashSet<>();
    Map<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for( String word : wordDict ) set.add(word);
        
        return helper(s);
    }
    
    public boolean helper( String s ){
        if( s.length() == 0 ) return true;
        
        if( map.containsKey(s) ) return map.get(s);
        
        if( set.contains(s) ) {
            map.put(s,true);
            return true;
        }
        
        for(int i = 0;i<s.length();i++){
            if( set.contains( s.substring(0,i+1) ) && helper( s.substring(i+1) ) ){
                map.put(s,true);
                return true;
            }
        }
        
        map.put(s,false);
        return false;
    }
}