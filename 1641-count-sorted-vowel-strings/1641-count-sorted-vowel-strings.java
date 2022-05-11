class Solution {
    int count = 0;
    public int countVowelStrings(int n) {
        helper(n,-1,0);
        return count;
    }
    public void helper(int n, int pre, int index){
        if(n == 0 || pre > index){
            // System.out.println(n==0);    
            count += n == 0 ? 1 : 0;
            return;
        }
        for(int i = index; i<5; i++){
            // System.out.println( (char)(index + 97) );
            // System.out.println( (char)(i + 97) );
            // System.out.println( index + " " + i );
            // System.out.println("----------------------");
            helper(n-1,index,i);
        }
    }
}