class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open_brac = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        int length = s.length();
        
        for(int i = 0;i<length;i++){
            char ch = s.charAt(i);
            
            if( ch == '(' ){
                open_brac.push(i);
            }else if( ch == '*' ){
                star.push(i);
            }else 
            {
                if( !open_brac.isEmpty() ){
                    open_brac.pop();
                }else if( !star.isEmpty() ){
                    star.pop();
                }else 
                {
                    return false;
                }
            }
        }
        
        while( !open_brac.isEmpty() ){
            if( star.isEmpty() ){
                return false;
            }else if( star.peek() > open_brac.peek() ){
                open_brac.pop();
                star.pop();
            }else 
            {
                return false;
            }
        }
        
        return true;
    }
}