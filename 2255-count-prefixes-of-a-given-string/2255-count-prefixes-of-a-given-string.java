// Space Complexity = O(N)
// Time Complexity = O(N^2) ( N = length of string s  ) If we have all strings in our word array equal to length n then each would take n time to check if it is a prefix.
class Solution {
    class Node {
        char ch;
        Node[] children;
        boolean isEnd;
        
        public Node(char ch){
            this.ch = ch;
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    
    Node root = new Node('0');
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        insert(s);
        
        for( String word : words ){
            Node curr = root;
            boolean isWord = true;
            for(char ch : word.toCharArray()){
                if( curr.children[ch-'a'] == null ) {
                    isWord = false;
                    break;
                }
                
                curr = curr.children[ch-'a'];
            }
            
            if(isWord) res++;
        }
        
        return res;
    }
    
    public void insert( String s ){
        Node curr = root;
        
        for(char ch : s.toCharArray()){
            if( curr.children[ch-'a'] == null ) curr.children[ch-'a'] = new Node(ch);
            
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
}

/*
Here At first we have created a trie structure given the s string.

Trie Structure stores each character of string s in the given order.
Now we traverse through all  the string in our words array and check for each one if it is a prefix of s.

To check we just need to check if each character of string are placed in trie in order then it is a prefix.
*/