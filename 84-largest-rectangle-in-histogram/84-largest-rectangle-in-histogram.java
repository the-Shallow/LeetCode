// Space Complexity = O(N)
// Time Complexity = O(N)
class Solution {
    
    class Pair {
        int index;
        int value;
        
        public Pair( int index , int value ){
            this.index = index;
            this.value = value;
        }
    }
    
    
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        
        int maxArea = 0;
        
        for( int i = 0;i<heights.length;i++ ){
            int curr_index = i;
            while( !stack.isEmpty() && stack.peek().value > heights[i] ){
                Pair pair = stack.pop();
                int index = pair.index;
                int val = pair.value;
                curr_index = index;
                maxArea = Math.max(maxArea , ( i - index )*val );
            }
            
            stack.push( new Pair( curr_index , heights[i] ) );
        }
        
        while( !stack.isEmpty() ){
            Pair pair = stack.pop();
            maxArea = Math.max(maxArea , ( heights.length - pair.index ) * pair.value );
        }
        
        return maxArea;
    }
}