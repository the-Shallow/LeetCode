class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        
        helper(s,0,temp);
        
        return result;
    }
    
    public void helper( String s , int curr_index , List<String> temp ){
        if( curr_index == s.length() ){
            result.add(new ArrayList<String>(temp));
            return;
        }
        
        for( int j = curr_index ; j<s.length();j++ ){
            if( isPalindrome( s.substring( curr_index , j+1 ) ) ){
                temp.add( s.substring(curr_index,j+1) );
                helper( s , j+1 , temp );
                temp.remove( temp.size() - 1 );
            }
        }
    }
    
    public boolean isPalindrome( String s ){
        int start = 0 ,end = s.length() - 1;
        
        while( start <= end ){
            if( s.charAt(start) != s.charAt(end) ) return false;
            start++;
            end--;
        }
        
        return true;
    }
}