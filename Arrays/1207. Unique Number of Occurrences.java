class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int num : arr){
            map.put(num , map.getOrDefault( num,0 ) + 1 );
        }
        
        for(int num : map.keySet()){
            set.add( map.get(num) );
        }
        
        return set.size() == map.size();
        
    }
}