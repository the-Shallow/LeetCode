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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        
        ListNode temp = head;
        while( temp != null ){
            temp = temp.next;
            count++;
        }
        
        count = count - n;
        
        
        ListNode prev = null;
        temp = head;
        while( count > 0 ){
            prev = temp;
            temp = temp.next;
            count--;
        }
        
        if(count == 0 && prev == null){
            temp = temp.next;
            head = temp;
            return head;
        }
        
       
        
        prev.next = temp.next;
        
        return head;
    }
}