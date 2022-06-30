// Space Complexity = O(1)
// Time Complexity = O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return null;
        
        Arrays.sort(intervals , (a,b)-> a[0] - b[0]);
        
        List<int[]> res = new ArrayList<>();
        
        int[] currInterval = intervals[0];
        
        for(int[] curr : intervals ){
            int start = currInterval[0];
            int end = currInterval[1];
            int currStart = curr[0];
            int currEnd = curr[1];
            
            if( end >= currStart ){
                currInterval[1] = Math.max(end , currEnd);
            }else {
                res.add( currInterval );
                currInterval = curr;
            }
        }
        
        res.add(currInterval);
        return getArray(res);
    }
    
    public int[][] getArray( List<int[]> list ){
        int[][] res = new int[list.size()][2];
        
        for(int i = 0;i<list.size();i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        
        return res;
    }
}