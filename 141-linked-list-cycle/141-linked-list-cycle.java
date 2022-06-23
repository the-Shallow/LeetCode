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
        ListNode rabbit = head;
        ListNode turtoise = head;
        
        while( rabbit != null && rabbit.next != null ){
            rabbit = rabbit.next.next;
            turtoise = turtoise.next;
            
            if(rabbit == turtoise) return true;
        }
        
        return false;
    }
}