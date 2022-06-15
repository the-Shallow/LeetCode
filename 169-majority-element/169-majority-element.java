// Space Complexity = O(1)
// Time Complexity = O(n)

/*
                            Approach 6: Boyer-Moore Voting Algorithm
Intuition:--

    If we had some way of counting instances of the majority element as +1+1 and instances of any other element as -1−1, summing them would make it obvious that the majority element is indeed the majority element.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        
        for( int num : nums ){
            if( count == 0 ){
                candidate = num;
            }
            
            count += ( num == candidate ) ? 1 : -1;
        }
        
        return candidate;
    }
}