class Solution {
    
    class Point {
        int number;
        int steps;
        
        public Point( int number , int steps ){
            this.number = number;
            this.steps = steps;
        }
    }
    
    Map<Integer,int[]> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        n = n*n;
        
        intToPos(board);
        
        
        Queue<Point> queue = new LinkedList<>();
        Point start = new Point( 1 , 0 );
        queue.add(start);
        visited.add(1);
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for(int i = 0;i<size;i++){
                Point curr = queue.poll();
                int pos = curr.number;
                
                if(pos >= n) return curr.steps;
                
                for( int j = 1 ;j < 7;j++  ){
                    int val = pos + j;
                    
                    if(val > n) break;
                    
                    Point next = new Point(val,curr.steps+1);
                    int[] cor = map.get(val);

                    if(  board[cor[0]][cor[1]] != -1) {
                        val = board[cor[0]][cor[1]];
                    }
                    
                    if(visited.contains(val)) continue;
                    
                    next.number = val;
                    visited.add(val);
                    queue.offer( next );
                }
            }
        }
        
        return -1;
    }
    
    public void intToPos( int[][] board ){
        int rows = board.length;
        int cols = board[0].length;
        int val = 1;
        boolean change = false;
        for( int i = rows-1 ;i>=0;i-- ){
            
            if(change){
                for( int j = cols-1;j>=0;j-- ){
                    map.put( val , new int[] {i,j} );
                    val++;
                }
                change = false;
            }else {
                for( int j = 0;j<cols;j++ ){
                    map.put( val , new int[] {i,j} );
                    val++;
                }
                 change = true;
            }
        }
    }
}