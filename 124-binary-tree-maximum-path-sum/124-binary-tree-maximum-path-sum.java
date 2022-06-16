// Space Complexity = O(H)
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
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        posorder(root);
        return res;
    }
    
    public int posorder( TreeNode root ){
        if(root == null ) return 0;
        
        int left = Math.max( posorder(root.left) , 0 );
        int right = Math.max( posorder(root.right) , 0 );
        
        res = Math.max( res , left + root.val + right );
        
        return Math.max( left,right ) + root.val;
    }
}