class Solution {
    public void rotate(int[][] matrix) {
        int length  = matrix.length;
        
        // Transpose 
        for( int i = 0;i<length;i++ ){
            for(int j = i;j<length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reflect(Just interchange element from every row till we reach midpoint)
        for(int i = 0;i<length;i++){
            for(int j = 0;j<(length/2);j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-1-j];
                matrix[i][length-j-1] = temp;
            }
        }
    }
}