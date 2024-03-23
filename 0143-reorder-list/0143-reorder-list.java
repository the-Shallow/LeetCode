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
    public void reorderList(ListNode head) {
        
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        while( node !=  null ){
            list.add( node.val );
            node =  node.next;
        }
        
        int start = 0 , end = list.size() - 1;
        
        while( start <= end ){
            if( start == end ){
                stack.push( list.get(start) );
                break;
            }
            stack.push( list.get(start) );
            stack.push(list.get(end));
            start++;
            end--;
        }
        
        
        node = head;
        for(int i = 0;i<stack.size();i++){
            node.val = stack.get(i);
            node = node.next;
        }
        
    }
}