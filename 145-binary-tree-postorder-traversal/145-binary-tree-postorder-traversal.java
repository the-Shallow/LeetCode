// Space Complexity = O(n)
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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>(); 
        return postorder(root);
    }
    
    public List<Integer> postorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(  !stack.isEmpty() ){
            TreeNode current =  stack.pop();
            
            res.add(0,current.val);
            
            if( current.left != null ){
                stack.push(current.left);
            }
            
            if( current.right != null ){
                stack.push(current.right);
            }
        }
        
        return res;
    }
}