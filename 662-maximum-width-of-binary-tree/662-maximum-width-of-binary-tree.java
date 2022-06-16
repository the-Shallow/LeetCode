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
    int maxWidth = 0;
    Map<Integer,Integer> leftMost = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        helper(root,0,0);
        return maxWidth;
    }
    
    public void helper( TreeNode root , int depth , int position ){
        if(root == null) return;
        
        leftMost.putIfAbsent(depth,position);
        maxWidth = Math.max( maxWidth , position - leftMost.get(depth) + 1);
        
        helper( root.left,depth+1,2*position);
        helper( root.right,depth+1,2*position+1);
    }
}