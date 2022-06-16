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
    
    class state {
        TreeNode root;
        int diameter;
        int height;
        
        public state(TreeNode root){
            this.root = root;
            this.diameter = 0;
            this.height = -1;
        }
    }
    
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }
    
    public state helper( TreeNode root ){
        if( root == null){
            return new state(null);
        }
        
        state left = helper( root.left );
        state right = helper(root.right);
        
        state curr_state = new state(root);
        curr_state.height = Math.max(left.height,right.height) + 1;
        curr_state.diameter = left.height + right.height + 2;
        res = Math.max(res,curr_state.diameter);
        return curr_state;
    }
}