// Space Complexity = O(1)
// Time Complexity = O(logn)
class Solution {
    public double myPow(double x, int n) {
        if( n == Integer.MIN_VALUE && x > 1 ) return 0;
        if( n == Integer.MIN_VALUE && x == 1 ) return 1;
        double res = helper( x , Math.abs(n) ) ;
        
        return n >= 0 ? res : 1/res;
    }
    
    public double helper( double x , int n ){
        if( x == 0 ) return 0;
        if( n == 0 ) return 1;
        
        double res = helper( x , n / 2 );
        res = res * res;
        
        return n % 2 == 1 ? x * res : res;
    }
}