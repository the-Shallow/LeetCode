class Solution {
    
    class Node {
        char ch ;
        boolean isEnd;
        Node[] children;
        
        public Node(char ch){
            this.ch = ch;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }
    
    Map<String ,Boolean> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
         Node root = new Node('0');
        
        for( String word : wordDict ){
            insert( word , root );
        }
        
        helper( s , root , root , "" );
        
        return result;
    }
    
    public void helper(  String s , Node curr , Node root, String validString  ){
        if( s.length() == 0 ) {
            result.add( validString );
        }
        
        // System.out.println( s + " " + validString );
        // if( map.containsKey(s) ) return map.get(s);
        // boolean res = false;
        for( int i = 0;i<s.length();i++ ){
            
            char ch = s.charAt(i);
            
            if( curr.children[ch - 'a'] == null ) return;
            curr = curr.children[ch - 'a'];
            
             if(curr.isEnd){
                helper( s.substring(i+1) , root,root , validString + s.substring(0,i+1) + 
                       (s.substring(i+1).length() == 0 ? "" : " ") ) ;
            }
           
        }
        
       
    }
    
    public void insert( String word , Node curr ){
        for( char ch : word.toCharArray() ){
            if( curr.children[ch - 'a'] == null ) curr.children[ch - 'a'] = new Node(ch);
            
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
}