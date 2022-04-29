public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        StringBuilder sb = new StringBuilder( Integer.toBinaryString(n) );
        
        sb.reverse();
        
        sb.append( "0".repeat(32-sb.length()) );
        
        System.out.println(sb);
        
        return (int) Long.parseLong(sb.toString(),2);
    }
}