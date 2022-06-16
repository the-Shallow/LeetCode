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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
         
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        
        res.add( temp   );
        queue.offer(root);
       
        while( !queue.isEmpty() ){
            temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = queue.poll();
                
                int level = res.size();
                if(level%2 == 0){
                    if( curr.left != null ){
                        stack.push(curr.left);
                        temp.add(curr.left.val);
                    }
                    
                    if( curr.right != null ){
                        stack.push( curr.right );
                        temp.add( curr.right.val );
                    }
                }else {
                    if(curr.right != null){
                        stack.push( curr.right );
                        temp.add(curr.right.val);
                    }
                    
                    if(curr.left != null){
                        stack.push(curr.left);
                        temp.add(curr.left.val);
                    }
                }
                
            }
            
            
            while(!stack.isEmpty()){
                queue.offer(stack.pop());
            }
            
            if(temp.size() > 0) res.add(temp);
        }
        
        return res;
    }
}