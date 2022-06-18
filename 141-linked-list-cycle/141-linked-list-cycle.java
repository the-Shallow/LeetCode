// Space Complexity = O(1)
// Time Complexity = O(N)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if( head == null ) return false;
        
        
        ListNode prev = head;
        ListNode next = head;
        
        while( next != null && next.next != null ){
            prev = prev.next;
            next = next.next.next;
            
            if(prev == next) return true;
        }
        
        return false;
    }
}