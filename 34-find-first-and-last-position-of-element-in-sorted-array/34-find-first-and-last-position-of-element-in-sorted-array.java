class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums,0,nums.length-1,target);
        res[1] = findLast(nums,0,nums.length-1,target) ;
        return res;
    }
    
    public int findFirst(int[] nums , int low , int high , int target){
        int res = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if( nums[mid] == target ){
                res = mid;
                high = mid - 1;
            }else if(nums[mid] < target){
                low  = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return res;
    }
    
    public int findLast(int[] nums , int low , int high , int target){
        int res = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] < target){
                low  = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }
            
            if(nums[mid] == target) {
                res = mid;
                low = mid + 1;
            }
        }
        
        return res;
    }
}