class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int k = 0;
        for(int[] query : queries){
            for(int[] point : points){
                int x = point[0];
                int y = point[1];
                int cx = query[0];
                int cy = query[1];
                int rad = query[2];
                
                int ans = (int) Math.pow( (x - cx) , 2 ) + (int) Math.pow( (y - cy) , 2 );
                
                if( ans <= (rad*rad) ){
                    res[k]++;
                }
            }
            k++;
        }
        
        return res;
    }
}