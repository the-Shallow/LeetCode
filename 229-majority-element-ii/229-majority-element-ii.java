// Space Complexity = O(1)
// Time Complexity = O(n)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] candidates = getCandidates(nums);
        
        int count1 = 0,count2 = 0;
        
        for( int i = 0;i<nums.length;i++ ){
            if( nums[i] == candidates[0] ) count1++;
            else if( nums[i] == candidates[1] ) count2++;
        }
        
        if( count1 > (nums.length/3) ){
            res.add( candidates[0] );
        }
        
        if( count2 > (nums.length/3) ){
            res.add(candidates[1]);
        }
        
        return res;
        
    }
    
    public int[] getCandidates( int[] nums ){
        int candidate1 = -1,count1 = 0;
        int candidate2 = -1,count2 = 0;
        
        for( int i = 0;i<nums.length;i++ ){
            if( candidate1 == nums[i] ){
                count1++;
            }else if( candidate2 == nums[i] ){
                count2++;
            }else if( count1 == 0 ){
                candidate1 = nums[i];
                count1 = 1;
            }else if( count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        
        return new int[] { candidate1 , candidate2 };
    }
}