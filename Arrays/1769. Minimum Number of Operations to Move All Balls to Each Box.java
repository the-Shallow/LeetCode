class Solution {
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        
        int[] forward = new int[length];
        int[] back = new int[length];
        
        int prev = boxes.charAt(0) == '1'?1:0;
        
        for(int i = 1;i<length;i++){
            forward[i] += forward[i-1] + prev;
            prev += boxes.charAt(i) == '1'?1:0;
        }
        
        prev = boxes.charAt(length - 1) == '1'?1:0;
        
        for(int i = length - 2;i>=0;i--){
            back[i] += back[i+1] + prev;
            prev += boxes.charAt(i) == '1'?1:0;
        }
        
        int[] res = new int[length];
        for(int i = 0;i<length;i++){
            res[i] = forward[i] + back[i];
        }
        
        return res;
    }
}