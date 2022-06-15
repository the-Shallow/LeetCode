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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root);
    }
    
    public List<Integer> inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        while( root != null || !stack.isEmpty() ){
            while( root != null ){
                stack.push( root );
                root = root.left;
            }
              
            TreeNode left = stack.pop();
            res.add( left.val );
            
            root = left.right;
        }
        
        return res;
    }
}