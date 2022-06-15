// Space Complexity = O(1)
// Time Complexity = O(logn + n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for( int[] row : matrix ){
            int start = row[0],end = row[row.length-1];
            
            if( start <= target && end >= target ){
                int left = 0 , right = row.length-1;
                
                while( left <= right ){
                    int mid = left + (right - left) / 2;
                    
                    if( row[mid] == target ) return true;
                    
                    if( row[mid] > target ) right = mid - 1;
                    else left = mid + 1;
                }
            }
        }
        
        return false;
    }
}