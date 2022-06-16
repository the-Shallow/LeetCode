// Space Complexity = O(n)
// Time Complexity = O(n)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        Node prev = null;
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for( int i = 0;i<size;i++ ){
                Node curr = queue.poll();
                
                if( curr.left != null ){
                    if(prev != null){
                        prev.next = curr.left;
                    }
                    prev =  curr.left;
                    
                    queue.offer(curr.left);
                }
                
                if(curr.right != null){
                    prev.next = curr.right;
                    prev = curr.right;
                    queue.offer(curr.right);
                }
            }
            
            prev = null;
        }
        
        return root;
    }
}