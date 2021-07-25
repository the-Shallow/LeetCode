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

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int len = nums.length;
        
        for(int i = 0;i<len;i++){
            count[nums[i]]++;
        }
        
        for(int i = 1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        
        for(int i = 0;i<len;i++){
            nums[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        
        return nums;
    }
}
