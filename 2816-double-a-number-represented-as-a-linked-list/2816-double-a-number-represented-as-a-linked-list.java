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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        
        int prev = 0;
        ListNode temp = head,temp2 = null;
        
        while(temp != null){
            int curr = (temp.val * 2);
            int rema = curr % 10;
            temp.val = rema + prev;
            prev = curr / 10;
            temp2 = temp;
            temp = temp.next;
        }
        
        if(prev != 0) temp2.next = new ListNode(prev);
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head){
        ListNode temp1 = head;
        ListNode temp3 = null;
        
        while(temp1 != null){
            ListNode temp2 = temp1;
            temp1 = temp1.next;
            temp2.next = temp3;
            temp3 = temp2;
        }
        
        return temp3;
    }
}