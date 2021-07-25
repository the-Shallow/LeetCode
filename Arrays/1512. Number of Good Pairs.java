*** METHOD-1 ***
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] returnedArr = new int[nums.length];
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            count = 0;
            for(int j = 0;j<nums.length;j++){
                if(nums[j] < nums[i] && j!= i){
                    count++;
                }
            }
            returnedArr[i] = count;
        }
        
        return returnedArr;
    }
}

*** METHOD-1 ***

