class Solution {
    public int splitArray(int[] nums, int m) {
        int max = smallestMax(nums);
        int sum = sum(nums);
        
        
        return binarySearch(nums,m,max,sum);
        
        
    }
    
    public int binarySearch( int[] nums , int m , int low , int right ){
        int res = right;
        System.out.println(low + " " + right);
        while( low <= right ){
            int midpoint = low + (right-low) / 2;
            
            if( isSubarray( nums, midpoint, m ) ){
                res = midpoint;
                // System.out.println("Midpoint " + midpoint + " Result " + res);
                // System.out.println("Right " + right);
                right = midpoint  - 1;
                System.out.println("Right " + right);
            }else {
                 // System.out.println("false");
                // System.out.println("Low " + low);
                low = midpoint + 1;
                System.out.println("Low " + low);
            }
        }
        
        return res;
    }
    
    public boolean isSubarray(int[] nums , int requiredSum , int m){
        int curr_sum = 0;
        int totalSubarray = 0;
        
        System.out.println( "RequiredSum " + requiredSum );
        for(int num : nums){
            curr_sum += num;
            System.out.println(" CurrSum " + curr_sum);
            if( curr_sum > requiredSum ){
                curr_sum = num;
                totalSubarray += 1;
            }
        }
        
        System.out.println( totalSubarray + 1 );
        // System.out.println(" Result " + requiredSum);
    
        return ( totalSubarray + 1 ) <= m;
    }
    
    public int smallestMax(int[] nums){
        int max = 0;
        for(int num : nums){
            max = Math.max( max , num );
        }
        
        return max;
    }
    
    public int sum(int[] nums){
        int sum = 0;
        for(int num : nums) sum += num;
        
        return sum;
    }
    
}