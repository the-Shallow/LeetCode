// Space Complexity = O(mn)
// Time Complexity = O(mn)
class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {   
        return helper( 0 , 0 , m  , n  ); 
    }
    
    public int helper( int curr_row , int curr_col , int m , int n ){
        // System.out.println(curr_row + " " + curr_col + " " + m + " " + n);
        if( curr_row >= m  || curr_col >= n ){
            return 0;
        }
        
        
        if( curr_row == m-1 && curr_col == n-1 ){
            return 1;
        }
        
        if( map.containsKey(curr_row+":"+curr_col) )  {
            // System.out.println("HIII");
            int val = map.get(curr_row+":"+curr_col); 
            return val;
        }
                
       int val1 = helper( curr_row + 1 , curr_col , m , n ) ;
       
       int val2 =  helper( curr_row  , curr_col + 1, m , n ) ;
        
     
       map.put( curr_row+":"+curr_col , val1 +  val2  );
        
        return val1+val2;
    }
}