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
    Map<Integer,Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if( root == null ) return false;
        
        if( map.containsKey( k - root.val ) ) return true;
        else map.put( root.val , 0 );
        
        boolean left = findTarget( root.left,k );
        boolean right = findTarget(root.right, k);
        
        return left || right;
    }
}