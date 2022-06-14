class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
       
        for(int rot = 0 ;rot<4;rot++){
            rotate(mat);
            boolean flag = true;
            for( int i = 0;i < mat.length;i++ ){
                for( int j = 0;j<mat[0].length;j++ ){
                    if( mat[i][j] != target[i][j] ) flag = false;
                }
            }
            
            if(flag) return true;
        }
        
        return false;
    }
    
    public void rotate(int[][] matrix){
        int length = matrix.length;
        
        // Transpose
        for(int i = 0;i<length;i++){
            for(int j = i;j<length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reflect
        for(int i = 0 ;i < length;i++){
            for(int j = 0;j<length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-1-j];
                matrix[i][length-1-j] = temp;
            }
        }
    }
}