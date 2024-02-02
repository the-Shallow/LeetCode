class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        
        int low_digit = (low + "").length();
        int high_digit = (high + "").length();
        
        for(int digit = low_digit;digit<=high_digit;digit++){
            for(int start = 1;start<9;start++){
                if(digit + start > 10) break;
                
                int num = start;
                int prev = start;
                for(int i = 0;i<digit-1;i++){
                    num = num * 10;
                    prev += 1;
                    num += prev;
                }
                
                if(num >= low && num <= high) res.add(num);
            }
        }
        
        return res;
    }
}