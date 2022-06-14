class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        
        List<Integer> firstRow = new ArrayList();
        firstRow.add(1);
        pascal.add(firstRow);
        
        for( int i = 1;i<numRows;i++ ){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prevRow = pascal.get(i-1);
            
            for( int j = 1 ; j < i ;j++ ){
                int firstEle = prevRow.get(j-1);
                int secondEle = prevRow.get(j);
                
                temp.add( firstEle + secondEle );
            }
            
            temp.add(1);
            
            pascal.add(temp);
            
        }
        
        return pascal;
    }
}