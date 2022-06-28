class Solution {
    int[][] memo;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        
        for(int i = 1;i<=cuts.length;i++){
            newCuts[i] = cuts[i-1];
        }
        
        memo = new int[newCuts.length+1][newCuts.length+1];
        
        for(int i = 0;i<=newCuts.length;i++){
            for(int j = 0;j<=newCuts.length;j++) memo[i][j] = -1;
        }
        newCuts[newCuts.length-1] = n;
        
        return helper(newCuts,1,newCuts.length-2);
    }
    
    public int helper(int[] cuts , int start , int end){
        if(start > end) return 0;
        
        if( memo[start][end] != -1 ) return memo[start][end];
        
        int res = Integer.MAX_VALUE;
        for(int i = start ;i<=end;i++){
            int cost = cuts[end+1] - cuts[start-1] + helper( cuts,start,i-1 ) + helper(cuts,i+1,end);
            res = Math.min( res , cost);
        }
        
        memo[start][end] = res;
        return res;
    }
}