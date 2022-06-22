class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        
        for( int i = 0;i<length;i++ ){
            helper( candidates , 0 , new ArrayList<>() , i , target );
        }
        
        
        return res;
    }
    
    public void helper( int[] candidates , int sum , List<Integer> temp , int curr_index, int target ){
        if( sum == target ){
            if( !res.contains(temp) ){
                res.add( new ArrayList<>(temp) );
                return;
            }
        }
        
        if(sum > target) return;
        
        for( int i = curr_index ; i<candidates.length;i++ ){
            temp.add( candidates[i] );
            helper( candidates , sum + candidates[i] , temp , i , target );
            temp.remove( temp.size() - 1 );
        }
    }
}