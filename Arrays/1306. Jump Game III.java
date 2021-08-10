class Solution {
    public boolean canReach(int[] arr, int start) {
        int front = -1,rear = -1;
        
        int[] queue = new int[2*arr.length];
        
        queue[++rear] = start;
        while(front != rear){
            front++;
            int val = queue[front];
            
            if( arr[val] > 0 ){
                if( val + arr[val] < arr.length ){
                    queue[++rear] = val + arr[val];
                }
                
                if( val - arr[val] >= 0){
                    queue[++rear] = val - arr[val];
                }
            }else if(arr[val] == 0) {
                return true;
            }
            
            arr[val] = -1;
        }
        
        return false;
    }
}