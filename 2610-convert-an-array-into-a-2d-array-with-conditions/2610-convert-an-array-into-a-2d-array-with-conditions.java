class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1 );
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        while(!map.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            boolean flag = false;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int key = entry.getKey();
                int value = entry.getValue();
                
                // System.out.println(key + " " + value);
                if(value == 0) continue;
                if(!temp.contains(key)){
                    temp.add(key);
                    flag = true;
                    map.put(key,value-1);
                }
            }
            
            if(!flag) break;
            res.add(temp);
        }
        
        return res;
    }
}