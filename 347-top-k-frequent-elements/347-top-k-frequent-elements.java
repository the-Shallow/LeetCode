// Space Complexity = O(n)
// Time Complexity = O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> b[1] - a[1] );
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put( num , map.getOrDefault(num,0) + 1 );
        }
        
        for( Map.Entry<Integer,Integer> entry : map.entrySet() ){
            pq.add( new int[] { entry.getKey() , entry.getValue() } );
        }
        
        int index = 0;
        while( k-- > 0 ){
            res[index++] = pq.poll()[0];
        }
        
        return res;
    }
}