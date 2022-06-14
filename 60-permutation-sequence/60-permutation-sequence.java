class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        
        for( int i = 1;i<=n;i++ ){
            nums[i-1] = i;
        }
        
        for( int j = 0;j<k-1;j++ ){
            createNextPermutation(nums,n);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for( int i = 0;i<n;i++ ){
            sb.append( nums[i] );
        }
        
        return sb.toString();
    }
    
    public void createNextPermutation( int[] nums , int length ){
        int first = length - 1;
        
        while( first > 0 && nums[first-1] >= nums[first] ){
            first--;
        }
        
        if( first == 0 ){
            Arrays.sort(nums);
            return;
        }
        
        first--;
        
        int second = length - 1;
        
        while( first < second && nums[second] <= nums[first] ){
            second--;
        }
        
        swap( nums, first , second );
        reverse(nums,first+1,length-1);
    }
    
    public void swap(int[] nums , int loc1,int loc2){
        int temp = nums[loc1];
        nums[loc1] = nums[loc2];
        nums[loc2] = temp;
    }
    
    public void reverse( int[] nums , int loc1 , int loc2 ){
        while( loc1 < loc2 ){
            swap( nums , loc1, loc2 );
            loc1++;
            loc2--;
        }
    }
}