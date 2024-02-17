class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y) -> Integer.compare(y, x));
        
        
        for(int i = 0;i<heights.length-1;i++){
            int diff = heights[i+1] - heights[i];
            
            if(diff <= 0 )continue;
            
            bricks -= diff;
            queue.add(diff);
            
            if(bricks < 0){
                if(ladders == 0) return i;
                
                ladders--;
                bricks += queue.poll();
            }
        }
        
        return heights.length - 1;
    }
}