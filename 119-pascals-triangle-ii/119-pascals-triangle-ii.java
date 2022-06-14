class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> firstRow = new ArrayList();
        firstRow.add(1);
        pascal.add( firstRow );
        
        for( int i = 1;i<=rowIndex;i++ ){
            List<Integer> temp = new ArrayList<>();
            temp.add( 1 );
            List<Integer> prevRow = pascal.get(i-1);
            for( int j = 1;j<i;j++ ){
                temp.add( prevRow.get(j-1) + prevRow.get(j) );
            }
            
            temp.add(1);
            
            pascal.add(temp);
        }
        
        return pascal.get( rowIndex );
    }
}