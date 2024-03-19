// Not done by Khush
class Solution {
    public int findMinArrowShots(int[][] points) {
        int count = 1;
        Arrays.sort(points, (a,b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for(int i = 0 ; i < points.length-1 ; i++) {
            if(points[i][1] >= points[i+1][0]) {
                points[i+1][1] = Math.min(points[i][1], points[i+1][1]);
            } else {
                count++;
            }
        }
        return count;
    }
}