// Space Complexity = O(N)
// Time Complexity = O(N^2)
class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1,text2,text1.length(),text2.length());
    }
    
    public int helper(String text1,String text2 ,int m , int n){
        
        if(m <= 0 || n <= 0) return 0;
        
        if( map.containsKey( m + ":" + n ) ) return map.get(m + ":" + n);
        
        if( text1.charAt(m-1) == text2.charAt(n-1) ){
            int val = 1 + helper( text1,text2,m-1,n-1 );
            map.put( m + ":" + n , val);
            return val;
        }else {
            int val = Math.max(helper( text1,text2,m-1,n ) , helper(text1,text2,m,n-1));
            map.put(m + ":" + n , val);
            return val;
        }
    }
}