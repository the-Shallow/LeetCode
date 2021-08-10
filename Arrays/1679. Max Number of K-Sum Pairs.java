****METHOD 1****
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0;i<length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        int count = 0;
        for(int num : map.keySet()){
            if( map.containsKey(num) &&  map.containsKey(k-num) ){
                if( num != k-num ){
                    count+= Math.min( map.get(num),map.get(k - num) );
                    map.put(num,0);
                    map.put(k-num,0);
                }else {
                    count+=Math.floor( map.get(num)/2 );
                    map.put( num,0 );
                }
            }
        }
        
        return count;
    }
}

****METHOD 2****
class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int left = 0,right = nums.length-1;
        while(left < right){
            int sum = nums[left] + nums[right];
            
            if(sum == k){
                left++;
                right--;
                count++;
            }else if( sum < k ){
                left++;
            }else 
            {
                right--;
            }
        }
        return count;
    }
}