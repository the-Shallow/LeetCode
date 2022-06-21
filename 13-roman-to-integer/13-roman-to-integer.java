// Space Complexity = O(1)
// Time Complexity = O(N)
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int prev = 0;
          
        for( int i = s.length() - 1;i>=0;i-- ){
            char ch = s.charAt(i);
            if( priority( ch ) < prev ){
                sum -= priority( ch );
            }else {
                sum += priority( ch );
            }
            
            prev = priority(ch);
        }
        
        return sum;
    }
    
    
    
    public int priority(char s){
        switch(s) {
            case 'I':return 1;
                
            case 'V':return 5;
                
            case 'X':return 10;
                
            case 'L':return 50;
                
            case 'C':return 100;
                
            case 'D':return 500;
                
            case 'M':return 1000;
        }
        
        return 0;
    }
}