class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    
    public int mergeSort( int[] nums , int left , int right ){
        int count = 0;
        
        if( left < right ){
            int mid = left + (right - left) / 2;
            
            count += mergeSort(nums,left,mid);
            count += mergeSort(nums,mid+1,right);
            count += merge(nums,left,mid,right);
        }
        
        return count;
    }
    
    public int merge(int[] nums , int left, int mid , int right){
        int length1 = mid - left + 1;
        int length2 = right - mid;
        int count = 0;
        int[] arr1 = new int[length1];
        int[] arr2 = new int[length2];
        
        for( int i = 0;i<length1;i++ ){
            arr1[i] = nums[left + i];
        }
        
        for(int j = 0;j<length2;j++){
            arr2[j] = nums[mid+j+1];
        }
        
        int k = left;
        int i = 0,j = 0;
        
        
        for(i = 0;i<length1;i++){
            while( j < length2 && arr1[i] > (2* (long)arr2[j]) ){
                j++;
            }
            
            count += j;
        }
        
        i = 0;
        j = 0;
        while(i < length1 && j < length2){
            if( arr1[i] <= arr2[j] ){
                nums[k++] = arr1[i++];
            }else {
                nums[k++] = arr2[j++];
            }
        }
        
        while(i < length1){
            nums[k++] = arr1[i++];
        }
        
        while(j < length2){
            nums[k++] = arr2[j++];
        }
        
        return count;
    }
}