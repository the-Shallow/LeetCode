class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = 0;
        
        for(int i = 0;i<bank.length;i++){
            int curr = 0;
            for(int j = 0;j<bank[i].length();j++){
                curr += bank[i].charAt(j) == '1' ? 1 : 0; 
            }
            
            if(prev != 0 && curr == 0) continue;
            int temp = prev * curr;
            if( i != 0 ) res += temp;
             prev = curr;
        
        }
        
        return res;
    }
}