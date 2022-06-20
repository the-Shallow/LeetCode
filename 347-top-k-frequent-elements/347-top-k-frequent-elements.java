import java.util.Map.Entry; 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map  = new HashMap<>();
        
        
        for(int num : nums){
            map.put( num , map.getOrDefault(num,0) + 1 );
        }
        
        List<Entry<Integer,Integer>> freq = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
        
        Collections.sort(freq,new Comparator<Entry<Integer,Integer>>(){
            public int compare(Entry<Integer,Integer> o1 ,Entry<Integer,Integer> o2 ){
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        int[] res = new int[k];
        int i = 0;
        for(Entry<Integer,Integer> entry : freq ){
            if(i == k) break;
            res[i++] = entry.getKey();
        }
        
        return res;
    }
}