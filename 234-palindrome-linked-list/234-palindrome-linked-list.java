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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        ListNode back = reverse(slow);
        ListNode front = head;
        
        while( back != null ){
            System.out.println(front.val);
            if( front != null &&  back != null && front.val != back.val ) return false;
            front = front.next;
            back = back.next;
        }
        
        return true;
    }
    
    public ListNode reverse( ListNode head ){
        ListNode temp1 = head;
        ListNode temp3 = null;
        
        while( temp1 != null ){
            ListNode temp2 = temp1;
            temp1 = temp1.next;
            temp2.next = temp3;
            temp3 = temp2;
        }
        
        return temp3;
    }
}