// Space Complexity = O(1)
// Time Complexity = O(logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0 , right = m*n-1;
        
        while( left <= right ){
            int mid = left + (right -left) / 2;
            
            if( matrix[mid/n][mid%n] == target ) return true;
            
            if( matrix[mid/n][mid%n] > target ) right = mid - 1;
            else left = mid + 1;
        }
        
        return false;
    }
}