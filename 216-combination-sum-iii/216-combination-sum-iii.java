class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if( k > n ) return res;
        
     
            helper( 1 , new ArrayList<Integer>() , k , 0 , n);
        
        return res;
    }
    
    public void helper( int start , List<Integer> list , int max , int curr , int sum ){
        if( max == 0 ){
            if( curr == sum && !res.contains(list) ){
                res.add( new ArrayList<>(list) );
            }
            
            return;
        }
        
        for( int i = start ; i<=9;i++ ){
            list.add(i);
            helper( i+1,list,max-1,curr+i,sum );
            list.remove( list.size() - 1 );
        } 
    }
}