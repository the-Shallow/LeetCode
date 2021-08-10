class Solution {
    int[][] memo = new int[1001][1001]; 
    public int twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        
        for(int i = 0;i<1001;i++){
            for(int j = 0;j<1001;j++){
                memo[i][j] = -1;
            }
        }
        return helper( costs , length -1, length/2,length/2 );
    }
    
    public int helper( int[][] costs , int length , int a , int b ){
        if( length < 0 || ( a == 0 && b == 0 ) ){
            return 0;
        }
        
        if(memo[a][b] != -1 ){
            return memo[a][b];
        }
        
        if( a > 0 && b > 0 ){
            return memo[a][b] =  Math.min( costs[length][0] +  helper(costs,length-1,a-1,b) , costs[length][1] + helper(costs,length-1,a,b-1) );
        }else if( a == 0  ){
            return memo[a][b] = costs[length][1] + helper(costs,length-1,a,b-1) ;
        }else if( b == 0  ) {
            return memo[a][b] = costs[length][0] + helper(costs,length-1,a-1,b);
        }
        
        return 0;
    }
}