class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> isGreatest = new ArrayList<Boolean>();
        
        int max = max(candies);
        
        
        for(int i = 0;i<candies.length;i++){
            if(candies[i] + extraCandies >= max){
                isGreatest.add(true);
            }else 
            {
                isGreatest.add(false);
            }
        }
        
        
        return isGreatest;
    }
    
    public int max( int[] arr ){
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        
        return max;
    }
}