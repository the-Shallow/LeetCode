// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    class Node {
        char ch;
        List<Integer> indexes;
        Node[] children;
        boolean isEnd;
        
        public Node(char ch){
            this.ch = ch;
            this.indexes = new ArrayList<>();
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    
    Node root = new Node('0');
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> Anagrams(String[] string_list) {
       createTrie( string_list );
       
       helper( root , string_list );
       
       return res;
    }
    
    public void helper( Node curr  , String[] words ){
        if(curr == null ) return;
        
        
        if(curr.isEnd){
            List<String> temp = new ArrayList<>();
            
            for(Integer index : curr.indexes ){
                temp.add( words[index] );
            }
            
            res.add(temp);
            
            return;
        }
        
        for(int i = 0;i<26;i++){
            if(curr.children[i] != null  ){
                helper(curr.children[i] , words );
            }
        }
    }
    
    public void createTrie( String[] words ){
        
        for( int i = 0;i<words.length;i++ ){
            char[] charArr = words[i].toCharArray();
            
            Arrays.sort(charArr);
            
            insert( new String(charArr) , i );
        }
    }
    
    public void insert(String word , int index){
        Node curr = root;
        
        for(char ch : word.toCharArray() ){
            if( curr.children[ch-'a'] == null ) curr.children[ch-'a'] = new Node(ch);
            
            curr = curr.children[ch-'a'];
        }
        
        if(curr.isEnd){
            curr.indexes.add(index);
            return;
        }
        
        curr.indexes.add(index);
        curr.isEnd = true;
        return;
    } 
}
