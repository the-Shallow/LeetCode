class Solution {
    Set<Integer> dayset = new HashSet<>();
    int[] memo = new int[366];
    public int mincostTickets(int[] days, int[] costs) {
        for(Integer day:days){
            dayset.add(day);
        }
        
        for(int i = 0;i<366;i++){
            memo[i] = -1;
        }
        
        return helper(costs,1);
    }
    
    public int helper( int[] costs , int day ){
        if( day > 365 ){
            return 0;
        }
        
        if( memo[day] != -1  ){
            return memo[day];
        }
        
        if( dayset.contains( day ) ){
            return memo[day] = Math.min( costs[0] + helper(costs,day + 1) , Math.min( costs[1] + helper(costs,day + 7),costs[2] + helper(costs,day + 30) ) );
        }else 
        {
            return memo[day] = helper(costs,day + 1);
        }
    }
}