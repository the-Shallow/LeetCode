class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] matrixSum = new int[rows][cols];
        
        computeSubMatrixSum(matrix,matrixSum,rows,cols);
        // displayMatrix(matrixSum);
        
        for(int r1 = 0;r1<rows;r1++){
            for(int r2 = r1;r2<rows;r2++){
                for(int c1 = 0;c1<cols;c1++){
                    for(int c2 = c1;c2<cols;c2++){
                        // System.out.println(r1 + " " + r2 + " " + c1 + " " + c2);
                        int totalSum = matrixSum[r2][c2];
                        int up = r1-1 >= 0 ? matrixSum[r1-1][c2] : 0;
                        int left = c1-1 >= 0 ? matrixSum[r2][c1-1] : 0;
                        int diag = ( r1 - 1 >= 0 && c1 - 1 >= 0 ) ? matrixSum[r1-1][c1-1] : 0; 
                        int sum =  totalSum - up - left + diag;
                        
                        if(sum == target) res++;
                    }
                }
            }
        }
        
        return res;
    }
    
    public void computeSubMatrixSum(int[][] matrix, int[][] matrixSum, int rows, int cols){
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols ; c++ ){
                int up = r - 1 >= 0 ? ( matrixSum[r-1][c] ) : 0;
                int left = c - 1 >= 0 ? ( matrixSum[r][c-1] ) : 0; 
                int diag = ( r - 1 >= 0 && c - 1 >= 0) ? matrixSum[r-1][c-1] : 0;
                int curr = matrix[r][c];
                int sum = up + left + curr - diag;
                
                matrixSum[r][c] = sum;
            }
        }
    }
    
    public void displayMatrix(int[][] matrix){
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                System.out.println(i + " " + j + " " + matrix[i][j]);
            }
        }
    }
}