class Solution {
    public void solveSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for( int i = 0;i<board.length;i++ ){
            for(int j = 0;j<board[0].length;j++){
                char ch = board[i][j];
                if( ch != '.' ){
                    if(  !seen.add( ch + "seen in row" + i ) || 
                         !seen.add(ch + "seen in col" + j) || 
                         !seen.add(ch + "seen in board" + i/3 + "" + j/3)){
                        return;
                    }
                }
            }
        }
        
        solve( board , seen  );
    }
    
    public boolean solve( char[][] board , Set<String> seen ){
        for( int i = 0;i<board.length;i++ ){
            for(int j = 0;j<board[0].length;j++){
                char ch = board[i][j];
                
                if(ch == '.'){
                    for( char k = '1';k<='9';k++ ){
                        if( isValid( k , i , j, seen ) ){
                            board[i][j] = k;
                            
                            if( solve( board,seen ) ){
                                return true;
                            }else {
                                seen.remove( k + "seen in row" + i );
                                seen.remove(k + "seen in col" + j);
                                seen.remove(k + "seen in board" + i/3 + "" + j/3);
                                board[i][j] = '.';
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid( char curr , int row , int col , Set<String> seen ){
        if( seen.contains( curr + "seen in row" + row ) || seen.contains(curr + "seen in col" + col) || 
            seen.contains(curr + "seen in board" + row/3 + "" + col/3) ) return false;
        
        seen.add( curr + "seen in row" + row );
        seen.add(curr + "seen in col" + col);
        seen.add(curr + "seen in board" + row/3 + "" + col/3);
        return true;
    }
}