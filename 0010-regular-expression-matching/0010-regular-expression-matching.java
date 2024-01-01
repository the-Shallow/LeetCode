class Solution {
    // Map<String,Boolean> map;
    int[][] map;
    public boolean isMatch(String s, String p) {
        // map = new HashMap<>();
        map = new int[s.length() + 1][p.length() + 1];
        
        for(int i = 0;i<=s.length();i++){
            for(int j = 0;j<=p.length();j++) map[i][j] = -1;
        }
        
        
        return helper(s,p,0,0);
    }
    
    public boolean helper(String s, String p, int i, int j){
        
        // String curr = i + ":" + j;
        // if(map.containsKey(curr)) return map.get(curr);
        
        if( map[i][j] != -1 ){
            return map[i][j] == 1 ? true : false;
        }
        
        
        if(i >= s.length() && j>= p.length()) return true;
        
        if(j >= p.length()) return false;
        
        boolean match = (i < s.length() && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ));
        
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean temp = helper(s,p,i,j+2) || (match && helper(s,p,i+1,j));
            // map.put(curr,temp);
            map[i][j] = temp ? 1 : 0;
            return temp;
        }
        
        if( match ) {
            boolean temp = helper(s,p,i+1,j+1);
            // map.put(curr,temp);
            map[i][j] = temp ? 1 : 0;
            return temp;  
        } 
        
        // map.put(curr,false);
        map[i][j] = 0;
        return false;
    }
}