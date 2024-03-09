class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;
        
        while(pointer1 < nums1.length && pointer2 < nums2.length){
            if(nums1[pointer1] == nums2[pointer2] ) return nums1[pointer1];
            
            while( pointer1 < nums1.length && pointer2 < nums2.length && nums1[pointer1] < nums2[pointer2]  ) pointer1++;
            while( pointer1 < nums1.length && pointer2 < nums2.length && nums2[pointer2] < nums1[pointer1]  ) pointer2++;
        }
        
        return -1;
    }
}