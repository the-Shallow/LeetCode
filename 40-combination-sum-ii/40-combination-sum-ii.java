class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i<candidates.length;i++){
            helper(candidates,0,target,temp,0);
        }
        
        return res;
    }
    
    public void helper(int[] candidates , int sum , int target , List<Integer> temp,int start){
        if( sum == target ){
            if(!res.contains(temp)){
                res.add(new ArrayList<>(temp) );
            }
            return;
        }
        
        if(sum > target) return;
        
        
        for(int i = start;i<candidates.length;i++){
            if( i > start && candidates[i] == candidates[i-1] ) continue;
            int val = candidates[i];
            temp.add( val );
            helper( candidates,sum+val,target,temp,i+1 );
            temp.remove( temp.size() - 1 );
        }
    }
}