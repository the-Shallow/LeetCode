class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0;i<s.length();i++){
            res += helper(s,i);
        }
        
        return res;
    }
    
    public int helper(String s, int start ){
        if(map.containsKey(start)) return map.get(start);
        
        int count = 0;
        for(int i = start;i<s.length();i++){
            String substringStr = s.substring(start,i+1);
            
            boolean flag = isPalindrome(substringStr);
            if(flag) count++;
        }
        
        map.put(start,count);
        
        return count;
    }
    
    public boolean isPalindrome(String curr){
        StringBuilder sb = new StringBuilder(curr);
        
        return sb.reverse().toString().equals(curr);
    }
}