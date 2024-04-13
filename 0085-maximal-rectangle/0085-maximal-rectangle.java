class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int res = 0;
        for(int i = 0; i < row; i++) {  
            for(int j = 0; j < col; j++) {
                int val = Character.getNumericValue(matrix[i][j]);
                heights[j] = val == 0 ? 0 : heights[j] + val;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
        
    }
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int[] leftLimit = new int[size];
        int[] righLimit = new int[size];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < size; i++) {
            
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                leftLimit[i] = 0;
            } else {
                leftLimit[i] = stack.peek()+1;
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = size - 1; i >= 0; i--) {
            
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                righLimit[i] = size-1;
            } else {
                righLimit[i] = stack.peek()-1;
            }
            stack.push(i);            
        }
        int res = 0;
        for(int i = 0; i < size; i++) {
            int area = (righLimit[i] - leftLimit[i] + 1) * heights[i];
            res = Math.max(res, area);
        }
        return res;

    }
}