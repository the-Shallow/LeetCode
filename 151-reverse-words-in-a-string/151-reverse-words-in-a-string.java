// Space Complexity = O( length );
// Time Complexity = O( length * max(word length) )
class Solution {
    public String reverseWords(String s) {
        List<String> tempList = new ArrayList<>();
        s = s.trim();
        
        String[] strArr = s.split(" ");
        // System.out.println( strArr[strArr.length-2].length() );
        StringBuilder sb = new StringBuilder();
        
        for( int i = strArr.length-1 ;i > 0;i-- ){
            if( strArr[i].length() == 0 ) continue;
            sb.append( strArr[i].trim()  + " " );
        }
        
        sb.append( strArr[0].trim() );
        
        return sb.toString();
    }
}