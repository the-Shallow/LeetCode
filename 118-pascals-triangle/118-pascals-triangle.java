class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        
        for( int i = 1;i<numRows;i++ ){
            temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = res.get(i-1);
            
            for(int j = 1;j<i;j++){
                int firstEle = prev.get(j-1);
                int secondEle = prev.get(j);
                
                temp.add(firstEle + secondEle);
            }
            
            temp.add(1);
            
            res.add(temp);
        }
        
        return res;
    }
}