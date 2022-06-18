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
    public ListNode reverseList(ListNode head) {
        if( head == null ) return null;
        
        ListNode temp1 = head;
        ListNode temp3 = null;
        
        while( temp1 != null ){
            ListNode temp2 = temp1;
            temp1 = temp1.next;
            temp2.next =  temp3;
            temp3 = temp2;
        }
        
        return temp3;
    }
}