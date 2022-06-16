// Space Complexity = O(height)
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
    private int currmax = Integer.MIN_VALUE;
    class NodeInfo {
        int min;
        int max;
        int sum;
        int currmax;
        boolean isBST;
        
        public NodeInfo() {};
        
        public NodeInfo(int min , int max, int sum ,int currmax , boolean isBST){
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.currmax = currmax;
            this.isBST = isBST;
        }
    }
    public int maxSumBST(TreeNode root) {
        int val = helper(root).currmax;
        return val > 0 ? val : 0;
    }
    
    public NodeInfo helper( TreeNode root ){
        if(root == null){
            return new NodeInfo(Integer.MAX_VALUE,Integer.MIN_VALUE,0,0,true);
        }
        
        if(root.left == null && root.right == null){
            currmax = Math.max( currmax , root.val );
            return new NodeInfo( root.val , root.val ,root.val,currmax,true );
        }
        
        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);
        
        NodeInfo curr = new NodeInfo();
      
        
        if( left.isBST && right.isBST && root.val > left.max && root.val < right.min ){
            curr.min = Math.min( left.min , Math.min( root.val , right.min ) );
            curr.max = Math.max( left.max , Math.max( root.val , right.max ) );
           
            int curr_sum = left.sum + root.val + right.sum;
            
            currmax = Math.max( currmax , curr_sum );
            curr.currmax = currmax;
            curr.sum = curr_sum;
            curr.isBST = true;
            return curr;
        }
        
        curr.sum = left.sum + root.val + right.sum;
        curr.currmax = currmax;
        curr.isBST = false;
        return curr;
    }
}