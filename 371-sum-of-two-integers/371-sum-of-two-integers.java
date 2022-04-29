class Solution {
    public int getSum(int a, int b) {
        String input1 = Integer.toBinaryString(a);
        String input2 = Integer.toBinaryString(b);
        
        // System.out.println( input1.length() + " " +  input2.length() );
        // System.out.println( input1  + " " + input2 );
        
        if( input1.length() != input2.length() ){
            if( input1.length() < input2.length() ){
                while(  input1.length() != input2.length() ) {
                    input1 = "0" + input1;
                }
            }else{
                while(  input1.length() != input2.length() ) {
                    input2 = "0" + input2;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int length = input1.length();
        
        
        
        int carry = 0;
        for( int i = length-1 ; i >= 0 ;i-- ){
            char ch1 = input1.charAt(i);
            char ch2 = input2.charAt(i);
            
            String combined = carry + "" + ch1 + "" + ch2;
            // System.out.println(combined);
                
            switch( combined ){
                case "000":{
                    carry = 0;
                    sb.append('0');
                    break;
                }
                    
                case "001":
                case "010":{
                    carry = 0;
                    sb.append('1');
                    break;
                }
                    
                case "011":{
                    carry = 1;
                    sb.append('0');
                    break;
                }
                    
                case "100":{
                    carry = 0;
                    sb.append('1');
                    break;
                }
                    
                case "101":
                case "110":{
                    carry = 1;
                    sb.append('0');
                    break;
                }
                    
                case "111":{
                    carry = 1;
                    sb.append('1');
                    break;
                }
            } 
        }
        
        if(carry == 1) sb.append('1');
        sb.reverse();
        // System.out.println( sb.toString() );
        return (int)Long.parseLong( sb.toString() , 2 );
    }
}