class Solution {
    
    class Node {
        char ch;
        boolean isEnd;
        Node child;
        
        public Node(char ch){
            this.ch = ch;
            this.isEnd = false;
            this.child = null;
        }
    }
    
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        Node root = new Node('/');
        
        insert( pattern , root );
        
        List<Boolean> res = new ArrayList<>();
        
        for(String query : queries){
            res.add( helper( query , root ) );
        }
        
        return res;
    }
    
    public boolean helper( String query , Node curr ){
        
        for(char ch : query.toCharArray()){
            if( ch >= 'A' && ch <= 'Z' ){
                if( curr.child == null || curr.child.ch != ch ) return false;
            }
            
            // System.out.println(curr.ch);
            if( curr.child != null && curr.child.ch == ch ) {
                curr = curr.child;
            }
        }
        
        return curr.isEnd;
    }
    
    public void insert( String word , Node curr ){
        
        for( char ch : word.toCharArray() ){
            curr.child = new Node(ch);
            curr = curr.child;
        }
        
        curr.isEnd = true;
    }
} 