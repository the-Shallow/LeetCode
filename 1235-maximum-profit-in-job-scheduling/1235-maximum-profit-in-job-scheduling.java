class Solution {
    int[] dp;
    class Pair {
        int start;
        int end;
        int profit;
        
        public Pair(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Pair[] pairs = new Pair[startTime.length];
       dp = new int[startTime.length];
        
        
        for(int i = 0;i<startTime.length;i++){
            int start = startTime[i];
            int end = endTime[i];
            int currProfit = profit[i];
            
            Pair curr = new Pair(start,end,currProfit);
            pairs[i] = curr;
            dp[i] = -1;
        }
        
        dp[dp.length-1] = -1;
        Arrays.sort(pairs, (a,b) -> a.start - b.start);
        
        for(int i = 0;i<startTime.length;i++) startTime[i] = pairs[i].start;
        return helper(pairs,startTime,0);
    }
    
    public int helper(Pair[] pairs, int[] startTime, int curr){
        if(curr == pairs.length) return 0;
        
        if(dp[curr] != -1) return dp[curr];
        
        int nextGreaterElement = search(startTime,curr,pairs[curr].end);
        
        int choose = pairs[curr].profit + helper(pairs,startTime,nextGreaterElement);
        int left = helper(pairs,startTime,curr+1);
        return dp[curr] = Math.max(choose,left);
    }
    
    public int search(int[] startTime, int curr, int end){
        int left = curr;
        int right = startTime.length;
        
        while(left < right){
            int mid = left + (right - left)/2;
            
            if( startTime[mid] >= end ) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
}