// Normal Stack or Recursion Traversal:--
    // Space Complexity = O(n)
    // Time Complexity = O(n)

// Morris Traversal:--
    // Space Complexity = O(1)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root);
    }
    
    public List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left == null){
                 res.add(curr.val);
                curr = curr.right;
            }else {
                TreeNode pre = curr.left;
                while(pre.right != null &&  pre.right != curr){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = curr;  
                    curr = curr.left;
                }else {
                    res.add(curr.val);
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return res;
    }
}


/*
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
*/