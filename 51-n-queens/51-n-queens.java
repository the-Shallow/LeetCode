// Space Complexity = o(N^2)
// Time Complexity = O(n!)
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        
        
        List<List<String>> board = new ArrayList<>();
        
        for( int i = 0;i<n;i++ ){
            List<String> temp = new ArrayList<>();
            for( int j = 0;j<n;j++ ){
                temp.add(".");
            }
            
            board.add(temp);
        }
        
        helper( cols,posDiag,negDiag,board,0,n );
        return res;
    }
    
    
    public void helper( Set<Integer> cols , Set<Integer> posDiag,Set<Integer> negDiag, List<List<String>> board ,int curr_row , int n  ) {
        
        if( curr_row == n ){
            List<String> validBoard = getValidBoard( board );
            res.add(validBoard);
            return;
        }
        
        for( int j = 0;j<n;j++ ){
            if( cols.contains(j) || posDiag.contains(curr_row+j) || negDiag.contains(curr_row-j) ) continue;
            cols.add(j);
            posDiag.add(curr_row+j);
            negDiag.add(curr_row-j);
            
            board.get(curr_row).set(j,"Q");
            
            helper( cols,posDiag,negDiag,board,curr_row+1,n );
            
            cols.remove(j);
            posDiag.remove(curr_row+j);
            negDiag.remove(curr_row-j);
            
            board.get(curr_row).set(j,".");
            
        }
    }
    
    public List<String> getValidBoard(List<List<String>> board){
    
        List<String> validBoard = new ArrayList<>();
        
        for( int i = 0;i<board.size();i++ ){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<board.get(0).size();j++){
                sb.append( board.get(i).get(j) );
            }
            validBoard.add(sb.toString());
        }
        
        return validBoard;
    }
    
    
}