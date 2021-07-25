class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        int len = nums.length;
        
        for(int i = 0;i<len-2;i++){
            int num = nums[i];
            
            if(num > 0) break;
            
            if(i > 0 && num == nums[i-1]) continue;
            
            int left = i + 1;
            int right = len - 1;
            
            while( left < right ){
                int sum = num + nums[left] + nums[right];
                if( sum < 0 ){
                    left++;
                }else if( sum > 0 ){
                    right--;
                }else 
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(num);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);
                    int last_left = nums[left];
                    int last_right = nums[right];
                    while( left < right && last_left == nums[left] ) left++;
                    while( left < right && last_right == nums[right] ) right--;
                }
            }
        }
        
        return list;
    }
}