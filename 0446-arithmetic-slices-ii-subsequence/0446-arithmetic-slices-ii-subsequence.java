class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer>[] map = new HashMap[n];
        
        int res = 0;
        for(int i = 0;i<n;i++){
            map[i] = new HashMap<>();
            for(int j = 0;j<i;j++){
                long diff = (long) nums[i] - nums[j];
                
                if(diff > Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) continue;
                
                int curr = (int) diff;
                
                map[i].put(curr, map[i].getOrDefault(curr,0) + map[j].getOrDefault(curr,0) + 1 );
                
                // diffMap[i][diff] += 1 + diffMap[j][diff];
                res += map[j].getOrDefault(curr,0);
            }
        }
        
        return  res;
    }
}