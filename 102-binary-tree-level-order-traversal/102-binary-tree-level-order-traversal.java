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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return helper(root);
    }
    
    public List<List<Integer>> helper( TreeNode root ){
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        res.add(temp);
        
        
        while( !queue.isEmpty() ){
            temp = new ArrayList<>();
            int size = queue.size();
            
            for( int i = 0;i<size;i++ ){
                TreeNode curr = queue.poll();
                
                if( curr.left != null ){
                    temp.add(curr.left.val);
                    queue.offer(curr.left);
                }
                
                if( curr.right != null ){
                    temp.add(curr.right.val);
                    queue.offer( curr.right );
                }
            }
            
            if( temp.size() > 0 ) res.add(temp);
        }
        
        return res;
    }
}