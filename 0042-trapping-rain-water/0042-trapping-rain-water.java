class Solution {
    public int trap(int[] height) {
        int[] left = leftMax(height);
        int[] right = rightMax(height);
        int total = 0;
        for(int i=0; i<height.length; i++) {
            total += Math.min(left[i], right[i])-height[i];
        }
        return total;
    }

    public int[] leftMax(int[] height) {
        int[] left = new int[height.length];
        int max = height[0];
        for(int i=0; i<height.length; i++) {
            if(height[i] <= max) {
                left[i] = max;
            } else {
                max = height[i];
                left[i] = max;
            }
        }
        return left;
    }

    public int[] rightMax(int[] height) {
        int[] right = new int[height.length];
        int max = height[height.length-1];
        for(int i=height.length-1; i>=0; i--) {
            if(height[i] <= max) {
                right[i] = max;
            } else {
                max = height[i];
                right[i] = max;
            }
        }
        return right;
    }
}