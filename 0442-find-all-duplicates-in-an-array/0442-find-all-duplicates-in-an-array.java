class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        
        List<Integer> res = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == 2) res.add(key);
        }
        
        return res;
    }
}