class Solution {
    
    class Node {
        char ch;
        Node[] children;
        
        
        public Node( char ch ) {
            this.ch = ch;
            this.children = new Node[2];
        }
        
        public void insert( Node curr , String binary ){
            for( char ch : binary.toCharArray() ){
                if( curr.children[ ch=='0'?0:1 ] == null ) curr.children[ch=='0'?0:1] = new Node(ch);
                
                curr = curr.children[ch=='0'?0:1];
            }
        }
        
        public int maxXor( Node curr , String binary ){
            String validString = "";
            for( char ch : binary.toCharArray() ){
                if( ch == '0' ){
                    if( curr.children[1] == null ){
                        validString += '0';
                        curr = curr.children[0];
                    }else {
                        validString += '1';
                        curr = curr.children[1];
                    }
                    
                }else {
                    if( curr.children[0] == null ){
                        validString += '0';
                        curr = curr.children[1];
                    }else {
                        validString += '1';
                        curr = curr.children[0];
                    }
                }
            }
            
            return Integer.parseInt( validString,2 );
        }
    }
    
    Node root = new Node('o');
    public int findMaximumXOR(int[] nums) {
        
        for( int num : nums ){
            String binary = toBinary(num);
            
            root.insert(root,binary);
        }
        
        int maxXor = 0;
        for( int num : nums ){
            String binary = toBinary(num);
            int xor = root.maxXor(root,binary);
            
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