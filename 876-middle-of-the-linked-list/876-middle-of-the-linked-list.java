// Space Complexity = O(1)
// Time Complexity = O(N)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode rabbit = head;
        ListNode turtoise = head;
        while( rabbit != null &&  rabbit.next != null ){
            rabbit = rabbit.next.next;
            turtoise = turtoise.next;
        }
        
        return turtoise;
    }
}