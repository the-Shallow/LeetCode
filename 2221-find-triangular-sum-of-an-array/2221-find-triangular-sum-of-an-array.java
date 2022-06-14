class Solution {
    public int triangularSum(int[] nums) {
        int length = nums.length;
        
        for( int j = length ; j > 0 ;j-- ){
            for( int i = 0;i<j-1;i++ ){
                
                int sum = ( nums[i] + nums[i+1] ) % 10;
                // System.out.println(sum);
                nums[i] = sum;
            }
        }
        
        // for(int i = 0;i<length;i++){
        //     System.out.println( nums[i] );
        // }
        
        return nums[0];
    }
}