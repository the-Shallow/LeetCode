class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long res = 0;
        
        for(int i = 0;i<arr.length;i++){
            
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int mid = stack.pop();
                
                int prev_small = !stack.isEmpty() ? stack.peek() : -1;
                
                long count = ((mid - prev_small) * (i - mid)) % 1000000007;
                
                res = (res + count*arr[mid])% 1000000007;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int mid = stack.pop();
                
            int prev_small = !stack.isEmpty() ? stack.peek() : -1;
                
            long count = ((mid - prev_small) * (arr.length - mid))% 1000000007;
                
            res = (res + count*arr[mid])% 1000000007;
        }
        
        return (int)(res% 1000000007);
    }
}