class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        
        for( int i = 0;i<k;i++ ){
            
            while( !queue.isEmpty() && nums[i] >= nums[queue.peekLast()] ){
                queue.removeLast();
            }
            
            queue.addLast( i );
        }
        
        res[index++] = nums[queue.peek()];
        
        for(int i = k;i<nums.length;i++){ 
            
            while( !queue.isEmpty() && queue.peek() <= (i-k) ){
                queue.removeFirst();
            }
            
            while( !queue.isEmpty() && nums[i] >= nums[ queue.peekLast() ] ){
                queue.removeLast();
            }
            
            queue.addLast(i);
            
            res[index++] = nums[queue.peek()];
        }
        
        return res;
    }
}