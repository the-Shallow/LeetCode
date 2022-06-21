class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int counter = 0;
        for( int i = 0;i<rows;i++ ){
            for(int j = 0;j<cols;j++){
                if( grid[i][j] == 2 || grid[i][j] == 1 ) counter++;
                if( grid[i][j] == 2 ) queue.offer( new int[]{i,j} );
            }
        }
        
        int[][] directions = new int[][] { { -1,0 } , {1 , 0} , {0,-1},{0,1} };
        
        int level = 0;
        while( !queue.isEmpty() ){
            level++;
            
            int size = queue.size();
            
            for( int i = 0;i<size;i++ ){
                int[] curr = queue.poll();
                counter--;
                for( int[] dir : directions ){
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    
                    if( newX < 0 || newY < 0 || newX == grid.length || newY == grid[0].length ) continue;
                    
                    if( grid[newX][newY] == 1 ){
                        grid[newX][newY] = 2;
                        queue.offer( new int[] {newX,newY} );
                    }
                }
            }
        }
        
        if(counter > 0) return -1;
        
        return level > 0 ? level - 1 : 0;
    }
}