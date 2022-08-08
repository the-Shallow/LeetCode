class Solution {
    
    class Pair {
        int row;
        int col;
        int steps;
        
        public Pair(int row, int col , int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(entrance[0] ,entrance[1] , 0 ) );
        maze[entrance[0]][entrance[1]] = '+';
        int[][] directions = { {-1,0} , {1,0} , {0,-1} , {0,1} };
        boolean flag = false;
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for(int i = 0;i<size;i++){
                Pair curr = queue.poll();
                
                
                if( (curr.row == 0 || curr.row == maze.length -1 || curr.col == 0 || curr.col == maze[0].length - 1) && flag ) return curr.steps;
                flag = true;
                for(int[] dir : directions ){
                    int row = dir[0] + curr.row;
                    int col = dir[1] + curr.col;
                    
                    if( row < 0 || row == maze.length || col < 0 || col == maze[0].length || maze[row][col] == '+'  ) continue;
                    maze[row][col] = '+';
                  
                    queue.offer( new Pair(row,col,curr.steps+1) );
                }
            }
        }
        
        return -1;
    }
}