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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        
        while(head != null){
            
            while(!stack.isEmpty() && stack.peek().val < head.val){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                ListNode prev = stack.peek();
                
                prev.next = head;
            }
            
            stack.push(head);
            head = head.next;
        }
        
        return stack.isEmpty() ? null : stack.get(0);
    }
}