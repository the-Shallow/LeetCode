class Solution {
    int res = -1;
    class Tree {
        int data;
        Tree left,right;
        
        public Tree( int data ){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        
        if(length == 1){
            return nums[0];
        }
        
        Tree root = new Tree( nums[0] );
        
        for(int i = 1;i < length ; i++ ){
            createTree( nums[i] , root );
        }
        
        
        if(root.left == null ) return root.data;
        
        singleTimeDigit(null,root);
        
        return  res ;
    }
    
    public void singleTimeDigit(  Tree parent , Tree root ){
        if( root != null ){
            
            if(parent != null && parent.data != root.data ){
                if( root.left != null && root.right == null && root.left.data != root.data ){
                    res = root.data;
                    return;
                }
            
                if( root.right != null && root.left == null && root.right.data != root.data ){
                    res = root.data;
                    return;
                }
                
                if(root.left == null && root.right == null){
                    res = root.data;
                    return;
                }
            }
            
            singleTimeDigit( root , root.left );
            singleTimeDigit(root , root.right);
        }
    }
    
    public void createTree( int data , Tree root ){
        if( root.data >= data ){
            if( root.left == null ){
                root.left = new Tree( data );
            }else 
            {
                createTree( data , root.left );
            }
        }else 
        {
            if( root.right == null ){
                root.right = new Tree(data);
            }else 
            {
                createTree( data , root.right );
            }
        }
    }
}