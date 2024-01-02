class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for(int curr : nums){
            int count = map.getOrDefault(curr,0);
            
            if(res.size() == count){
                res.add(new ArrayList<>());
            }
            
            res.get(count).add(curr);
            
            map.put(curr, count+1);
        }
        
        return res;
    }
}