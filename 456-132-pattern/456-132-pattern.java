class Solution {
    public boolean find132pattern(int[] nums) {
       int length = nums.length;
        
        int[] min_arr = new int[length];
        
        min_arr[0] = nums[0];
        for( int i = 1 ;i < length ; i++ ){
            min_arr[i] = Math.min( min_arr[i-1] , nums[i] );
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for( int j = length - 1 ;j>=0;j-- ){
            int val = nums[j];
            
            while( !stack.isEmpty() && stack.peek() <= min_arr[j] ) stack.pop();
            
            if( !stack.isEmpty() && stack.peek() < val ) return true;
            
            stack.push(val);
        }
        
        
        return false;
    }
}


/*
 int length = nums.length;
        
        // for creating the min array
        int[] min_arr = new int[length];
        min_arr[0] = nums[0];
        for(int i = 1;i<length;i++){
            min_arr[i] = Math.min( min_arr[i-1] , nums[i] );
        }
        
        
        Stack<Integer> stack = new Stack<>();
        
        for( int j = length-1; j>=0 ; j--){
            int val = nums[j];
            
            // values in stack smaller than min values till current j pointer are useless as they are never going to become larger.
            while( !stack.isEmpty() && stack.peek() <= min_arr[j] ){
                stack.pop();
            }
            
            // there are still values larger than the minimum at the current j and now we check if the current value is greater than stacks peek value which are nothing but k and current is j.
            if( !stack.isEmpty()  && stack.peek() < val ) return true;
            
            stack.push( val );
            
        }
        
        // at the very end we simply return false;
        return false;
*/