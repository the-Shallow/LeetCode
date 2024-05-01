class Solution {
    public String reversePrefix(String word, char ch) {
        int index = -1;
        
        for(int i = 0;i<word.length();i++) {
            if( word.charAt(i) == ch ) {
                index = i;
                break;
            }
        }
        
        char[] res = reverse( word.toCharArray(), index );
        
        // System.out.println(res);
        return new String(res);
    }
    
    public char[] reverse(char[] word, int length){
        int left = 0,right = length;
        
        while(left < right){
            char ch = word[left];
            word[left] = word[right];
            word[right] = ch;
            left++;
            right--;
        }
        
        return word;
    }
}