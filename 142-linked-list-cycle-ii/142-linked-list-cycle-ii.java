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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null ) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            
            
            if(fast == slow) break;
        }
        
        if(fast == null) return null;
        
        ListNode entry = head;
        
        while(entry != null && slow != null && entry != slow){
            entry = entry.next;
            slow = slow.next;
        }
        
        return slow == entry ? slow : null;
    }
}