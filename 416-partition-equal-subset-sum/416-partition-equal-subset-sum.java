class Solution {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int length = nums.length;
        for(int num : nums) sum += num;
        
        if( sum % 2 != 0 ) return false;
        
        sum = sum / 2;
        
        memo = new int[length+1][sum+1];
        
        for(int i = 0;i<=length;i++){
            for(int j = 0;j<=sum;j++) memo[i][j] = -1;
        }
        
        return helper( nums, nums.length - 1 , sum ) == 1 ? true : false;
    }
    
    public int helper( int[] nums , int m , int target ){
        if( target == 0 ) return 1;
        
        if( m < 0 ) return 0;
        
        if(  memo[m][target] != -1  ) return memo[m][target]; 
        
        if( nums[m] > target ){
            return memo[m][target] =  helper( nums , m-1,target );
        }else {
            return memo[m][target] =  helper( nums , m-1, target - nums[m] ) | helper( nums , m-1,target );
        }
    }
}