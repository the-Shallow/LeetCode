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
            ListNode kth = getkthNode( groupPrev , k);
            
            if(kth == null) break;
           
            ListNode groupNext = kth.next;
            
            ListNode temp3 = reverse( groupPrev.next , groupNext );
            
            ListNode temp = groupPrev.next;
            groupPrev.next = temp3;
            groupPrev = temp;
        }
        
        return dummy.next;
    }
    
    public ListNode reverse(ListNode curr, ListNode groupNext){
        ListNode temp1 = curr;
        ListNode temp3 = groupNext;
        
        while( temp1 != groupNext){
            ListNode temp2 = temp1;
            temp1 = temp1.next;
            temp2.next = temp3;
            temp3 = temp2;
        }
        
        return temp3;
    }
    

    
    public ListNode getkthNode( ListNode curr, int k ){
        while(k-- > 0){
            curr = curr.next;
            
            if(curr == null ) return null;
        }
        
        return curr;
    }
}