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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode curr = root;
        TreeNode prev = null;
        while( curr != null ){
            if(curr.val == key) break;
            
            if( curr.val < key ){
                prev = curr;
                curr = curr.right;
            }else {
                prev = curr;
                curr = curr.left;
            }
        }
        
        if(curr == null) return root;
        
        if(curr.left == null && curr.right == null){
            if(prev == null) return null;
            if(prev.left == curr) prev.left = null;
            else prev.right = null;
        }
        else if( curr.left == null ) {
            if(prev  == null) return curr.right;
            if(prev.left == curr) prev.left = curr.right;
            else prev.right = curr.right;
        }
        else if(curr.right == null) {
            if(prev  == null) return curr.left;
            if(prev.left == curr) prev.left = curr.left;
            else prev.right = curr.left;
        }
        else {
            TreeNode temp = curr.right;
            prev = temp;
            while(temp.left != null) {
                prev = temp;
                temp = temp.left;
            }
            
            curr.val = temp.val;
            if(temp == curr.right){
                curr.right = temp.right;
            }else {
                prev.left = temp.right;
            }
        }
       
        
        return root;
    }
    
}