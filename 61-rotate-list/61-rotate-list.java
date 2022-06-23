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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        ListNode newHead = null;
        ListNode temp = head;
        int count = 1;
        
        while( temp.next != null ){
            count++;
            temp = temp.next;
        }
        
        k = k % count;
        
        if(k == 0) return head;
        
        count = count - k - 1;
        ListNode curr = head;
        while(count-- > 0){
            curr = curr.next;
        }
        
        newHead = curr.next;
        curr.next = null;
        temp.next = head;
        
        return newHead;
    }
}