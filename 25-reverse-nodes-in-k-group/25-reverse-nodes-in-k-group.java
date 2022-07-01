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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        
        ListNode groupPrev = dummy;
        
        while(true){
            ListNode kthNode = getkthNode(groupPrev,k);
            
            if(kthNode == null) break;
            
            ListNode temp = groupPrev.next;
            ListNode groupNext = kthNode.next;
            
            ListNode curr = reverse( temp , groupNext );
            
            groupPrev.next = curr;
            groupPrev = temp;
        }
        
        return dummy.next;
    }
    
    public ListNode reverse(ListNode temp1 , ListNode groupNext){
        ListNode temp3 = groupNext; // because we want to connext first node of group to next upcoming groups first element
        
        while(temp1 != groupNext){
            ListNode temp2 = temp1;
            temp1 = temp1.next;
            temp2.next = temp3;
            temp3 = temp2;
        }
        
        return temp3;
    }
    
    public ListNode getkthNode(ListNode curr , int k){
        while( k-- > 0 ){
            curr = curr.next;
            
            if(curr == null) return null;
        }
        
        return curr;
    }
}