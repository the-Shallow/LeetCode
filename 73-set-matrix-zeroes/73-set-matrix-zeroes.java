class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isRow = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if( matrix[i][j] == 0 ){
                    matrix[0][j] = 0;
                    
                    if(i > 0){
                        matrix[i][0] = 0;
                    }else {
                        isRow = true;
                    }
                }
            }
        }
        
        
        for( int i = 1;i<rows;i++ ){
            for( int j = 1;j<cols;j++ ){
                if( matrix[i][0] == 0 || matrix[0][j] == 0 ){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int i = 0;i<rows;i++){
                matrix[i][0] = 0;
            }
        }
        
        if(isRow){
            for( int j = 0;j<cols;j++ ){
                matrix[0][j] = 0;
            }
        }
    }
}