class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][] {new int[] {newInterval[0],newInterval[1]} } ;
        int[][] res = new int[intervals.length+1][2];
        int counter = 0;
        for(int[] interval : intervals) res[counter++] = interval;
        res[counter++] = newInterval;
        
        Arrays.sort(res, (a,b)->a[0]-b[0]);

        List<int[]> list = new ArrayList<>();
        
        
        for(int i = 0;i<res.length;i++){
            int[] interval = res[i];
            int start = interval[0];
            int end = interval[1];
            
            
            if(list.size() > 0 &&  start <= list.get(list.size()-1)[1] ) {
                list.get(list.size()-1)[1] = Math.max(end, list.get(list.size()-1)[1]);
            }else {
                list.add(interval);
            }
        }
        
        
        counter = 0;
        int[][] resultArr = new int[list.size()][2];
        
        for(int[] temp : list){
            resultArr[counter++] = temp;
        }
        
        return resultArr;
    }
}