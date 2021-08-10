class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1,right = getMax(piles);
        return binary(piles,left,right,h);
    }
    
    public int binary(int[] piles,int left,int right,int h){
        if( left > right ){
            return left;
        }
        
        int mid = (left+right)/2;
        
        if( helper( piles,mid,h ) ){
            return binary(piles,left,right = mid-1,h);
        }else 
        {
            return binary(piles,left = mid + 1,right,h);
        }
    }
    
    public boolean helper(int[] piles ,int k,int h){
        int count = 0;
        
        for( int pile : piles ){
            int div = pile/k;
            count+=div;
            if( pile % k != 0 ) ++count;
        }
        
        return count <= h ? true : false;
    }
    
    public int getMax( int[] arr ){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            max = Math.max( max , arr[i]  );
        }
        return max;
    }
}