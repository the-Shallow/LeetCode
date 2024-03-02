class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int left = 0, right = 0;
        
        while( left < nums.length && nums[left] < 0 ) left++;
        right = left;
        left--;
        // System.out.println(left + " " + right);
        
        int counter = 0;
        while(left >= 0 && right < res.length){
            int square_left = nums[left] * nums[left];
            int square_right = nums[right] * nums[right];
            
            if(square_left >= square_right) {
                res[counter++] = square_right;
                right++;
            }else{
                res[counter++] = square_left;
                left--;
            }
        }
        
        while(left >= 0){
            res[counter++] = nums[left] * nums[left];
            left--;
        }
        
        while(right < res.length){
            res[counter++] = nums[right] * nums[right];
            right++;
        }
        
        return res;
    }
}