// Sapce Complexity = O(n)
// Time Complexity = O(n)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorder(root);
    }
    
    public List<Integer> preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        while( root != null || !stack.isEmpty() ){
            while( root != null  ){
                res.add( root.val );
                stack.push( root );
                root = root.left;
            }
            
            TreeNode mid = stack.pop();
            
            root = mid.right;
        }
        
        return res;
    }
}