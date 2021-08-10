class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        int length = nums.length;
        
        int[] res = new int[length];
        
        for(int i = 0;i<length;i++){
            if(nums[i] % 2 == 0) sum+=nums[i];
        }
    
        for(int i = 0;i<queries.length;i++){
            int val = queries[i][0],index = queries[i][1];
            
            if( nums[index] % 2 == 0 ) sum -= nums[index];
            nums[index]+=val;
            if(nums[index] % 2 == 0) sum += nums[index];
            res[i] = sum;
        }

        
        return res;
    }
}