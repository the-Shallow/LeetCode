class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        
        res.add(temp);
        
        for( int i = 1;i<numRows;i++ ){
            List<Integer> prev = res.get(i-1);
            
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            
            for( int j = 1;j<i;j++ ){
                int sum = prev.get(j-1) + prev.get(j);
                curr.add(sum);
            }
            
            curr.add(1);
            
            res.add(curr);
        }
        
        return res;
    }
}