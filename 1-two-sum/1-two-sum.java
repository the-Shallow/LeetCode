// Space Complexity = O(n)
// Time Complexity = O(n)
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         Map<Integer,Integer> map = new HashMap<>();
        
//         for( int i = 0; i < nums.length ; i++ ){
//             if( map.containsKey( target - nums[i] ) ){
//                 return new int[]{ map.get(target-nums[i]) , i };
//             }else {
//                 map.put(nums[i],i);
//             }
//         }
        
//         return null;
//     }
// }


// Approach 2
// Space Complexity = O(N)
// Time Complexity = O(nlogn)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[][] indexArray = new int[nums.length][2];
        
        for(int i = 0;i<nums.length;i++){
            indexArray[i][0] = nums[i];
            indexArray[i][1] = i;
        }
        
        Arrays.sort(indexArray,(a,b)->a[0] - b[0]);
        
        int start = 0,end = nums.length - 1;
        while(start < end){
            int sum = indexArray[start][0] + indexArray[end][0];
            if(sum == target) return new int[]{indexArray[start][1] , indexArray[end][1]};
            if( sum > target ) end--;
            else start++;
        }
        
        return null;
    }
}
