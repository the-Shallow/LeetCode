class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        for(int i = 0;i<m;i++){
            for(int j = n-1;j>=0;j--){
                if( box[i][j] == '#' ){
                    int empty = j + 1;
                    while( empty < n &&  box[i][empty] == '.' ){
                        empty++;
                    }
                    
                    if( empty-1 < n && box[i][empty-1] == '.'  ){
                        box[i][empty - 1] = '#';
                        box[i][j] = '.';
                    }
                }
            }
        }
        
        char[][] res = new char[n][m];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                res[i][j] = box[ (m-1) -  j ][i];
            }
        }
        
        return res;
    }
}