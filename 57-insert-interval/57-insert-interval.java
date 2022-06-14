class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if( intervals.length == 0 ) return new int[][] {newInterval};
        
        
        intervals = Arrays.copyOf(intervals,intervals.length+1);
        intervals[intervals.length-1] = newInterval;
         
        Arrays.sort( intervals, (arr1,arr2)-> arr1[0] - arr2[0] );
        
        
        List<int[]> list = new ArrayList<>();
        int[] curr_interval = intervals[0];
        list.add( curr_interval );
        
        for( int[] interval : intervals ){
            int curr_begin = curr_interval[0];
            int curr_end = curr_interval[1];
            int new_begin = interval[0];
            int new_end = interval[1];
            
            if( curr_end >= new_begin ){
                curr_interval[1] = Math.max( curr_end , new_end );
            }else {
                curr_interval = interval;
                list.add( curr_interval );
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}