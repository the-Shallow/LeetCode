// Time complexity : O(N) to build a traversal.
// Space complexity : O(N) to keep an inorder traversal.
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root,nums);
        return nums.get(k-1);
    }
    
    public void inorder(TreeNode root , List<Integer> nums){
        if(root == null) return;
        
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
}