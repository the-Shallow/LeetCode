class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        
        while(left < right){
            char prefix = s.charAt(left);
            char suffix = s.charAt(right);
            
            if(prefix == suffix){
                while( left <= right && s.charAt(left) == prefix ) left++;
                while( left <= right && s.charAt(right) == prefix ) right--;
            }else {
                break;
            }
        }
        
        
        return right - left + 1;
    }
}