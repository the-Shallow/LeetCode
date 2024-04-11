class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : num.toCharArray()){
            
            while(!stack.isEmpty() && k > 0 &&  stack.peek() > ch ){
                stack.pop();
                k--;
            }
            
            stack.push(ch);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while( !stack.isEmpty() ){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
        
        String res = removeZero(sb.toString());
        return res.equals("") ? "0" : res;
    }
    
    public static String removeZero(String str)
    {
 
        // Count leading zeros
 
        // Initially setting loop counter to 0
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
            i++;
 
        // Converting string into StringBuffer object
        // as strings are immutable
        StringBuffer sb = new StringBuffer(str);
 
        // The StringBuffer replace function removes
        // i characters from given index (0 here)
        sb.replace(0, i, "");
 
        // Returning string after removing zeros
        return sb.toString();
    }
}