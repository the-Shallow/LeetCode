*** METHOD 1 ***

private int[][] rectangle;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1;i<=row2;i++){
            for(int j = col1;j<=col2;j++){
                rectangle[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }

*** METHOD 2 ***

class SubrectangleQueries {
    private int[][] rectangle;
    private List<int[]> newChange;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.newChange = new ArrayList<>();
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        this.newChange.add(new int[]{row1,col1,row2,col2,newValue} );
    }
    
    public int getValue(int row, int col) {
       int res = rectangle[row][col];
        for(int[] arr : newChange ){
            int row1 = arr[0];
            int col1 = arr[1];
            int row2 = arr[2];
            int col2 = arr[3];
            int val = arr[4];
            
            if( row >= row1 && row <= row2 && col >= col1 && col <= col2 ){
                res = val;
            }
        }
        
        return res;
    }
}
