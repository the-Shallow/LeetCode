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

class NodeInfo {
    long min;
    long max;
    int ans;
    int size;
    boolean isBST;
    
    public NodeInfo(){};
    
    public NodeInfo( long min , long max , int ans , int size, boolean isBST ){
        this.min = min;
        this.max = max;
        this.ans = ans;
        this.size = size;
        this.isBST = isBST;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helperBST(root).isBST;
    }
    
    public NodeInfo helperBST(TreeNode root){
        if(root == null) {
            return new NodeInfo( Long.MAX_VALUE,Long.MIN_VALUE , 0,0,true );
        }
        
        if( root.left == null && root.right == null ){
            return new NodeInfo( root.val , root.val , 1,1,true );
        }
        
        NodeInfo left = helperBST(root.left);
        NodeInfo right = helperBST(root.right);
        
        NodeInfo curr = new NodeInfo();
        
        curr.size = left.size + right.size;
        
        if( left.isBST && right.isBST && left.max < root.val && right.min > root.val ){
            curr.min = Math.min( left.min , Math.min(root.val,right.min)  );
            curr.max = Math.max( left.max , Math.max(root.val , right.max) );
            curr.ans = curr.size;
            curr.isBST = true;
            return curr;
        }
        
        curr.ans = Math.max( left.ans,right.ans );
        curr.isBST = false;
        
        return curr;
    }
}

/*
if(root == null){
            return new NodeInfo(Long.MAX_VALUE,Long.MIN_VALUE,0,0,true);
        }
        
        if( root.left == null && root.right == null){
            return new NodeInfo(root.val,root.val,1,1,true);
        }
        
        
        NodeInfo left = helperBST(root.left);
        NodeInfo right = helperBST(root.right);
        
        NodeInfo curr = new NodeInfo();
        curr.size = 1 + left.size + right.size;
        
        if( left.isBST && right.isBST && root.val > left.max && root.val < right.min ){
            curr.min = Math.min(left.min , Math.min(root.val,right.min));
            curr.max = Math.max(left.max , Math.max(root.val,right.max));
            curr.ans = curr.size;
            curr.isBST = true;
            return curr;
        }
        
        curr.ans = Math.max( left.ans,right.ans );
        curr.isBST = false;
        return curr;
*/







































// class NodeInfo {
//     long min;
//     long max;
//     int size;
//     int ans;
//     boolean isBST;
    
//     public NodeInfo(){};
    
//     public NodeInfo(long min,long max,int size,int ans,boolean isBST){
//         this.min = min;
//         this.max = max;
//         this.size = size;
//         this.ans = ans;
//         this.isBST = isBST;
//     }
// }

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return helperBST(root).isBST;
//     }
    
//     public NodeInfo helperBST(TreeNode root){
//         if(root == null){
//             return new NodeInfo( Long.MAX_VALUE,Long.MIN_VALUE,0,0,true );
//         }
        
//         if( root.left == null && root.right == null ){
//             return new NodeInfo(root.val,root.val,1,1,true);
//         }
        
//         NodeInfo leftTree = helperBST(root.left);
//         NodeInfo rightTree = helperBST(root.right);
        
//         NodeInfo curr = new NodeInfo();
//         curr.size = 1 + leftTree.size + rightTree.size;
//         // System.out.println(curr.size);
        
//         if( leftTree.isBST && rightTree.isBST && root.val > leftTree.max && root.val < rightTree.min ){
//             curr.min = Math.min( leftTree.min,Math.min(rightTree.min,root.val) );
//             curr.max = Math.max( leftTree.max,Math.max(rightTree.max,root.val) );
//             curr.ans = curr.size;
//             curr.isBST = true;
//             return curr;
//         }
        
//         curr.ans = Math.max( leftTree.ans,rightTree.ans );
//         System.out.println(curr.ans);
//         curr.isBST = false;
//         return curr;
//     }
// }