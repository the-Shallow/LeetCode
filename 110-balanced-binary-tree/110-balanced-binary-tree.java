/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Node {
        TreeNode root;
        boolean isBalance;
        int height;
        
        public Node(TreeNode root){
            this.root = root;
            this.isBalance = true;
            this.height = 0;
        }
    }
  
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalance;
    }
    
    public Node helper(TreeNode root){
        if( root == null ){
            return new Node( null );
        }
        
        Node left = helper(root.left);
        Node right = helper(root.right);
        
        Node curr = new Node(root);
        curr.isBalance = (left.isBalance && right.isBalance) ? Math.abs(left.height - right.height) > 1 ? false:true : false;
        curr.height = Math.max( left.height, right.height ) + 1;
        return curr;
    }
}