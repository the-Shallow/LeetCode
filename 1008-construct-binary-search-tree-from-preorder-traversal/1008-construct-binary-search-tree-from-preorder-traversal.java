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
    int preIndex = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOfRange(preorder,0,preorder.length);
        Arrays.sort(inorder);
        
        return helper(preorder,inorder);
    }
    
    public int find(int[] inorder,int val){
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == val ) return i;
        }
        
        return -1;
    }
    
    public TreeNode helper( int[] preorder , int[] inorder ){
        
        if(inorder.length == 0) return null;
        
        int val = preorder[preIndex++];
        
        int rootIndex = find(inorder,val);
        
        
        TreeNode left = helper(preorder , Arrays.copyOfRange(inorder,0,rootIndex) );
        TreeNode right = helper(preorder , Arrays.copyOfRange(inorder,rootIndex+1 , inorder.length));
        
        TreeNode root = new TreeNode(val);
        root.left = left;
        root.right = right;
        
        return root;
    }
}