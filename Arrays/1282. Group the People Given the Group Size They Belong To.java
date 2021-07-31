class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        int length = groupSizes.length;
        
        for(int i = 0;i<length;i++){
            int current_grp = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            
            if( map.containsKey(current_grp) ){
                temp = map.get(current_grp);
            }
            
            temp.add(i);
            map.put(current_grp,temp);
            
            if(temp.size() == current_grp){
                res.add(temp);
                map.remove(current_grp);
            }
        }
        
        return res;
    }
}