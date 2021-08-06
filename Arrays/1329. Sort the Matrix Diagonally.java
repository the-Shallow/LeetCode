class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // row == 0
        for(int col = 0;col<n;col++){
            sort(mat,0,col,m,n);
        }
        
        // col == 0
        for(int row = 1;row<m;row++){
            sort(mat,row,0,m,n);
        }
        
        return mat;
    }
    
    public void sort( int[][] mat , int row,int col,int m,int n ){
        List<Integer> diagonal = new ArrayList<>(); 
        
        int r = row;
        int c = col;
        
        while( r < m && c < n ){
            diagonal.add( mat[r][c] );
            r++;
            c++;
        }
        
        Collections.sort(diagonal);
        
        r = row;
        c = col;
        int index = 0;
        while( r < m && c < n ){
            mat[r][c] = diagonal.get(index++);
            r++;
            c++;
        }
    }
}