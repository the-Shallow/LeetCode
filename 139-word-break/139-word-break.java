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
    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node('0');
        
        for( String word : wordDict ){
            insert( word , root );
        }
        
        return helper( s , root , root );
    }
    
    public boolean helper(  String s , Node curr , Node root  ){
        if( s.length() == 0 ) return true;
        
        if( map.containsKey(s) ) return map.get(s);
        boolean res = false;
        for( int i = 0;i<s.length();i++ ){
            
            char ch = s.charAt(i);
            
            if( curr.children[ch - 'a'] == null ) return false;
            curr = curr.children[ch - 'a'];
            
             if(curr.isEnd){
                res = res | helper( s.substring(i+1) , root,root) ;
            }
            
            map.put(s,res);
            if(res) return res;
        }
        
        return false;
    }
    
    public void insert( String word , Node curr ){
        for( char ch : word.toCharArray() ){
            if( curr.children[ch - 'a'] == null ) curr.children[ch - 'a'] = new Node(ch);
            
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
}