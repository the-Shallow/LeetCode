// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}// } Driver Code Ends


class Solution
{
    
    static class Node  {
        char ch;
        int freq;
        
        public Node(char ch){
            this.ch = ch;
            this.freq = 0;
        }
    }
    
	public static String rearrangeCharacters(String str) {
	    int[] freq = new int[26];
	    
	    for( char ch : str.toCharArray() ){
	        freq[ch-'a']++;
	    }
	    
	    PriorityQueue<Node> queue = new PriorityQueue<>( (a,b) -> b.freq - a.freq );
	    
	    for(int i = 0;i<26;i++){
	        if(freq[i] > 0 ){
	            Node curr = new Node( (char)( 'a' + i ) );
	            curr.freq = freq[i];
	            
	            queue.offer(curr);
	        }
	    }
	    
	    Node prev = null;
	    
	    StringBuilder sb = new StringBuilder("");
	    
	    while( !queue.isEmpty() ){
	        Node curr = queue.poll();
	        
	        if(prev != null && prev.freq > 0 ){
	            queue.offer(prev);
	        }
	        
	        sb.append( curr.ch );
	        curr.freq--;
	        
	        prev = curr;
	    }
	    
	    return sb.toString().length() != str.length() ? "-1" : sb.toString();
	}
}