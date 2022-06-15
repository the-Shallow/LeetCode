// Normal Preorder using recursion and stack Traversal:--
    // Sapce Complexity = O(n)
    // Time Complexity = O(n)

// Morris Traversal:--
    // Sapce Complexity = O(1)
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
                    res.add(curr.val);
                    pre.right = curr;  
                    curr = curr.left;
                }else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return res;
    }
    
}

/*
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
*/