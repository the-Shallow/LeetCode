class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        int rows = grid.length;
        int cols = grid[0].length;
        int dimension = rows * cols;
        
        k = k % dimension;
        
        for(int i = 0;i<rows;i++){
            List<Integer> temp = new ArrayList<>();
            
            res.add(temp);
            
            for(int j = 0;j<cols;j++){
                 // i * n + j original place index in 1D array
                // i * n + j - k  is to get value k steps before
                int index = ( ( (i * cols) + j ) - k + dimension ) % dimension;
                
                temp.add( grid[index / cols][index % cols ] );
            }
        }
        
        return res;
    }
}