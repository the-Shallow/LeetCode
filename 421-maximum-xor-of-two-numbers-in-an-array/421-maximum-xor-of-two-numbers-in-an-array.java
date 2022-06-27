// Space Complexity = O(n*32)
// Time Complexity = O(n*32)
class Solution {
    
    class Node {
        Node[] children;
        
        
        public Node(  ) {
            this.children = new Node[2];
        }
        
        public void insert(Node curr , int num ){
            for( int i = 31 ;i>=0;i-- ){
                int currBit = (num >> i) & 1;
                
                if(curr.children[currBit] == null ) curr.children[currBit] = new Node();
                
                curr = curr.children[currBit];
            }
        }
        
        public int maxXor(Node curr, int num){
            int xor = 0;
            
            for(int i = 31;i>=0;i--){
                int requiredBit = 1 - ( (num >> i) & 1 );
                
                if(curr.children[requiredBit] == null) {
                    curr = curr.children[1 - requiredBit];
                }else {
                    xor |= (1 << i);
                    curr = curr.children[requiredBit];
                }
            }
            
            return xor;
        }
    }
    
    Node root = new Node();
    public int findMaximumXOR(int[] nums) {
        
        for( int num : nums ){
            root.insert(root,num);
        }
        
        int maxXor = 0;
        for( int num : nums ){
            int xor = root.maxXor(root,num);
            
            maxXor = Math.max(maxXor,xor);
        }
        
        return maxXor;
    }
    
    public String toBinary( int num ){
        String validString = Integer.toBinaryString(num);
        
        while( validString.length() != 32 ){
            validString = '0' + validString;
        }
        
        return validString;
    }
    
}