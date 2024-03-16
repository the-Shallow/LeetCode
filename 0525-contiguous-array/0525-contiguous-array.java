class Solution {
    public int findMaxLength(int[] nums) {
        
//         Input:-- [1,1,1,1,0,1,0,0,0,0]
//         output = 10;
//         HashMap at index 3:-- [{0,-1},{1,0},{2,1},{3,2},{4,3}]
//         max_length at index 4:-- count == 3
//         map.get(3) == 2 .*. max_length = 4-2 = 2
//         max_length at index 5:-- count == 4
//         map.get(4) == 3 .*. max_length = 5 - 3 = 2
//         max_length at index 6:-- count == 3
//         map.get(3) == 2 .*. max_length = 6-2 = 4
//         max_length at index 7:-- count == 2
//         map.get(2) == 1 .*. max_length = 7-1 = 6
//         max_length at index 8:-- count == 1
//         map.get(1) == 0 .*. max_length = 8-0 = 8
//         max_length at index 9:-- count == 0
//         map.get(0) == -1 .*. max_length = 9-(-1) = 9
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int count = 0;
        int max_length = 0;
        
        for(int i = 0;i<nums.length;i++){
            
            count = count + ((nums[i] == 0)?-1:1);
            
            if(map.containsKey(count)){
                max_length = Math.max(max_length,i - map.get(count));
            }else {
                map.put(count,i);
            }
        }
        
        return max_length;
    }
}