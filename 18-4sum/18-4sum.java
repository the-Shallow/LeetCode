class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res =  new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0;i<nums.length;i++){
            if(i != 0 && nums[i] == nums[i-1] ) continue;
            
            for( int j = i+1;j<nums.length;j++ ){
                if(j != i+1 && nums[j] == nums[j-1] ) continue;
                long newTarget = (long)target - nums[i] - nums[j];
                
                int left = j+1;
                int right = nums.length-1;
                
                while(left < right){
                    int sum = nums[left] + nums[right];
                    
                    if( sum == newTarget ){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                         left++;
                        right--;
                        while(left < nums.length && nums[left] == nums[left-1]) left++;
                        while( right >= 0 && nums[right] == nums[right+1] ) right--;
                    }else if( sum < newTarget ){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        
        return res;
    }
}