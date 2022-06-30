// Spcae Complexity = O(1)
// Time Complexity = O(nlogn)
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1,high = nums.length - 1;
        
        int duplicate = -1;
        
        while(low <= high){
            int mid = ( low + high )/2;
            int count = 0;
            for( int num : nums ){
                if( num <= mid ) count++; 
            }
            
            if(count > mid){
                duplicate = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return duplicate;
    }
}