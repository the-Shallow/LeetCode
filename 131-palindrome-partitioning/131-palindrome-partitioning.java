// Space Complexity = O(n*2^n)
// Time Complexity = O(t*2^n) (t == time to check if it is a palindrome)
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper( s , 0 , new ArrayList<String>()  );
        
        return res;
    }
    
    public void helper( String s , int curr_index , List<String> temp ){
        if( curr_index == s.length() ){
            res.add( new ArrayList<>(temp) );
            return;
        }
        
        for( int j = curr_index ; j<s.length();j++ ){
            if(  isPalindrome( s , curr_index ,j )  ){
                temp.add( s.substring(curr_index,j+1) );
                helper( s , j+1,temp );
                temp.remove( temp.size() - 1 );
            }
        }
        
    }
    
    public boolean isPalindrome( String s , int start , int end ){
        while( start <= end ){
            if( s.charAt(start) != s.charAt(end) ) return false;
            start++;
            end--;
        }
        
        return true;
    }
}