// class Solution {
//     int max = Integer.MIN_VALUE;
//     List<Integer> res;
//     Map<Integer,List<Integer>> map = new HashMap<>();
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         res = new ArrayList<>();
//         for(int i = 0;i<nums.length;i++){
//             List<Integer> temp = new ArrayList<>();
//             int curr = nums[i];
//             temp.add(curr);
//             helper(nums,curr,i+1,0,temp);
//         }
        
        
//         // System.out.println(max);
//         return res;
//     }
    
//     public void helper(int[] nums, int curr, int index, int resLength, List<Integer> list){
        
//         if( map.containsKey(index) ) {
//             list.add(map.get(index));
            
//             if( list.size() >= max ){
//                 max = list.size();
//                 res = new ArrayList<>(list); 
//                 map.put(index, res);
//             }
            
//             return;
//         }
        
//         if(resLength >= max){
//             max = resLength;
//             res = new ArrayList<>(list);
//             map.put(index, res);
//             // System.out.println(res);
//         }
        
//          if(index >= nums.length) return;
        
//         for(int i = index;i<nums.length;i++){
//             int temp = nums[i];
//             // System.out.println(curr + " " + temp);
//             if(temp % curr == 0){
//                 list.add(temp);
//                 helper(nums,temp,i+1,resLength+1,list);
//                 list.remove(list.size()-1);
//             }
//         }
//     }
// }


// class Solution {
    
//     List<Integer> res = new ArrayList<>();
//     int maxLen = 0;
    
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         backtrack(nums, new ArrayList<>(), 0, new HashSet<>());
//         return res;
//     }
    
//     private void backtrack(int[] nums, List<Integer> currList, int start, Set<Set<Integer>> visited) {
//         if(start >= nums.length) return;
//         if(currList.size() > 0 && currList.get(currList.size() - 1) > nums[nums.length - 1] / 2) return;
//         for(Set<Integer> set : visited) {
//             if(set.size() <= currList.size()) continue;
//             if(set.containsAll(currList) && set.size() > currList.size()) return;
//         }
//         visited.add(new HashSet<>(currList));
//         List<Integer> list = new ArrayList<>(currList);
//         for(int i = start; i < nums.length; i++) {
//             if(list.size() == 0 || nums[i] % list.get(list.size() - 1) == 0) {
//                 list.add(nums[i]);
//                 if(list.size() > maxLen) {
//                     res = new ArrayList<>(list);
//                     maxLen = list.size();
//                 }
//                 backtrack(nums, list, i + 1, visited);
//                 list.remove(list.size() - 1);
//             }
//         }
//     }
// }


 class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        
        int maxSize = 1, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int num = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (num % nums[i] == 0 && dp[i] == maxSize) {
                result.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }
        
        return result;
    }
}